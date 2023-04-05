package com.serverside.Api.Dao;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;



public class JWT {
     String SECRET_KEY = "ll-99_##";


    public  String JWebGenerate(String u) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() );


        return  Jwts.builder()
                .setSubject(u)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();

    }


}