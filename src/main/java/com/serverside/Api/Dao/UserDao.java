package com.serverside.Api.Dao;


import com.serverside.Api.Model.LoginInfo;
import com.serverside.Api.Model.Return_Data;
import com.serverside.Api.Model.Users_data;
import com.serverside.Api.Reposetries.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;


import static org.hibernate.internal.util.StringHelper.isBlank;

@Service
public class UserDao {


    @Autowired
    UsersRepo userR ;
    CheckingData checkingData =new CheckingData();

    JWT jwt;

    // add user
    public Return_Data add(Users_data u){
        String p=u.getPassword();
                Long x= checkingData.generateId_code();
        if (x != null && !isBlank(String.valueOf(x))) {
             x= checkingData.generateId_code();
        }

      u.setId_code(x);
        u.setJwt_date(checkingData.getTime());
        u.setPassword(checkingData.hashString(p));

     Users_data y=userR.save(u);

        Return_Data r=new Return_Data(y.getId_code(),y.getFirst_name(),y.getSecond_name(),y.getAmount(),y.getEmail(),checkingData.JWebGenerate(y.getId_code()));
      return  r;

    }

    public List<Users_data> getAll(){

        return userR.findAll();

    }

    public Users_data getOne(Long id){
       return userR.findById(id).get();
    }


// find by email
    public Return_Data getByEmail(LoginInfo e) {

        try {

            Users_data i = userR.findByEmail(e.getEmail()).get();

            if (checkingData.hashString(e.getPassword()).equals(i.getPassword())) {
               i.setJwt_date(checkingData.getTime());
                Return_Data r = new Return_Data(i.getId_code(), i.getFirst_name(), i.getSecond_name(), i.getAmount(), i.getEmail(), checkingData.JWebGenerate(i.getId_code()));
                  return r;

            } else {


                return null;
            }


        } catch (Exception exception) {


            return null;
        }


    }
    public boolean addAmount(Long id , Double x){

        userR.addTAmount(id,x);

        return true;

    }


    public boolean subtractAmount(Long id , Double x){

        userR.subtractTAmount(id , x);

       return true;
    }


}