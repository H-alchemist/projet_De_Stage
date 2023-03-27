package com.serverside.Api.Dao;



import java.time.Instant;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Date;


import java.util.Random;
import java.util.concurrent.TimeUnit;


public class CheckingData {



    JWT jwt;


    public Long generateId_code(){
        Random random = new Random();

        // generate a random number with 8 digits
        Long randomNum = random.nextLong(900000000) + 100000000;

        return randomNum;
    }


    public  String hashString(String u){
        String NewPassw = "";
        try {

            String passwWall = u + "wall";

            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] bytes = md.digest(passwWall.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString(bytes[i] & 0xff));
            }
            NewPassw = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return NewPassw;

    }

    public Timestamp getTime(){
        Timestamp instant= Timestamp.from(Instant.now());


        return  instant;
    }

    String SECRET_KEY = "ll-99_##";

    private static final int expirationTime = 60;
    public  String JWebGenerate(Long i) {

        Date now = new Date();
        Date expiration = new Date(now.getTime() + TimeUnit.MINUTES.toMillis(expirationTime));


         String u =i.toString();
        return  Jwts.builder()
                .setSubject(u)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();

    }

//    public Boolean validateJwt(String jwt ,Long id ){
//        System.out.println("check");
//            Claims claims = Jwts.parser()
//                    .setSigningKey(SECRET_KEY)
//                    .parseClaimsJws(jwt)
//                    .getBody();
//
////            String userId = claims.getSubject();
//            Date expiration = claims.getExpiration();
//
//
//        System.out.println("check 1");
//        Date now = new Date();
//        Date currentT = new Date(now.getTime());
//
//
//            int res = expiration.compareTo(currentT);
//            if (res > 0) {
//                return true;
//            } else {
//                return false;
//            }
//
//    }




}
