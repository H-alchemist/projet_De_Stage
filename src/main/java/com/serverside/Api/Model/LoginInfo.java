package com.serverside.Api.Model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.ConstructorProperties;
import java.sql.Timestamp;

@Data
@NoArgsConstructor


public class LoginInfo {
    private  String email;

    private String password;




}

