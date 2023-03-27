package com.serverside.Api.Dao;

import com.serverside.Api.Model.Transaction;


import com.serverside.Api.Reposetries.Transactionrepo;

import com.serverside.Api.Reposetries.UsersRepo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;


@Service
public class TransactionDao {


    @Autowired
    Transactionrepo transactionR;



    @Autowired
     UserDao userdao;
    CheckingData checkingData;

    String SECRET_KEY = "ll-99_##";
    public Transaction add(Transaction t) {

         String jwt=t.getJwt();
        Claims claims;


             claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(jwt)
                    .getBody();

            String userId = claims.getSubject();
        Date expiration = claims.getExpiration();

        System.out.println(userId);
        System.out.println(t.getReceiver_id());
        System.out.println(t.getSender_id());

         if( t.getReceiver_id().equals(t.getSender_id())) {

          return null;
         }else {
             userdao.addAmount(t.getReceiver_id(), t.getAmount());
             userdao.subtractAmount(t.getSender_id(), t.getAmount());

             t.setJwt("");
             return transactionR.save(t);
         }



    }


//    public Boolean validateJwt(String jwt ,Long id ){
//        System.out.println("check");
//        Claims claims = Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(jwt)
//                .getBody();
//
//            String userId = claims.getSubject();
//        Date expiration = claims.getExpiration();
//
//
//        System.out.println("check 1");
//        Date now = new Date();
//        Date currentT = new Date(now.getTime());
//
//
//
//    }

    public List<Transaction> getAll(){

        return transactionR.findAll();

    }







}
