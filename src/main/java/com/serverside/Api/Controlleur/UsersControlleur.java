package com.serverside.Api.Controlleur;


import com.serverside.Api.Dao.UserDao;
import com.serverside.Api.Model.LoginInfo;
import com.serverside.Api.Model.Return_Data;
import com.serverside.Api.Model.Users_data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class UsersControlleur {


    @Autowired
    UserDao userdao;


    @PostMapping("/users/post")
    public ResponseEntity<?> addUser(@RequestBody Users_data u){

         try {
             return new ResponseEntity<Return_Data>(userdao.add(u), HttpStatus.OK);
         }catch (Exception e){
             return new ResponseEntity<String>( HttpStatus.BAD_REQUEST);
         }
    }
    @GetMapping("/users/getAll")
    public List<Users_data> getAllT(){


        return userdao.getAll();

    }


    @GetMapping("/users/getOne/{id}")
    public Users_data getOne(@PathVariable Long id){
       return userdao.getOne(id);
    }


//login
    @PostMapping("/users/postLoginInfo")
    public ResponseEntity<?> addUser(@RequestBody LoginInfo u){

             Return_Data r= userdao.getByEmail(u);

             if(r==null) {

                 return new ResponseEntity<String>( HttpStatus.BAD_REQUEST);

             }else{
                 return  new ResponseEntity<Return_Data>(r, HttpStatus.OK);
             }






    }

}
