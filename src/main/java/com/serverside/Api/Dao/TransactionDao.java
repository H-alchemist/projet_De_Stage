package com.serverside.Api.Dao;

import com.serverside.Api.Model.Transaction;


import com.serverside.Api.Reposetries.Transactionrepo;

import com.serverside.Api.Reposetries.UsersRepo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;


@Service
public class TransactionDao {


    @Autowired
    Transactionrepo transactionR;


    Timestamp instant;
    @Autowired
     UserDao userdao;
    CheckingData checkingData;

    String SECRET_KEY = "ll-99_@@";
    public Transaction add(Transaction t) {
        instant= Timestamp.from(Instant.now());
         String jwt=t.getJwt();
        Claims claims;


             claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(jwt)
                    .getBody();

            String userId = claims.getSubject();
        Date expiration = claims.getExpiration();


        int x=t.getReceiverId();

        System.out.println(x);

        System.out.println("kmkkmkmmkmk");

//         if( t.getReceiverId()==t.getSenderId()) {
//
//          return null;
//         }else {
             userdao.addAmount(t.getReceiverId(), t.getAmount());
             userdao.subtractAmount(t.getSenderId(), t.getAmount());

             t.setJwt("");
             t.setAmount(userdao.getOne(t.getReceiverId()).getAmount());
             t.setDateDeT(instant);
             t.setReceiverName(userdao.getOne(t.getReceiverId()).getFirst_name() + ""+userdao.getOne(t.getReceiverId()).getSecond_name());
             t.setSenderName(userdao.getOne(t.getSenderId()).getFirst_name() + ""+userdao.getOne(t.getSenderId()).getSecond_name());

             return transactionR.save(t);
//         }



    }



    public List<Transaction> getAll(){

        return transactionR.findAll();

    }


    public List<Object[]> getTR(int x){

        return transactionR.getReceiverList(x);

    }


    public List<Object[]> getTS(int x){

        return transactionR.getSenderList(x);

    }





}
