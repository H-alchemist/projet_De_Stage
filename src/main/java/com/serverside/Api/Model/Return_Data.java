package com.serverside.Api.Model;


import lombok.Data;

@Data
public class Return_Data {



    private Long id_code=0L;


    private String first_name;


    private String second_name;


    private double amount;


    private String email;



    private String jwt_date;

    public Return_Data(Long id_code, String first_name, String second_name, double amount, String email, String jwt_date) {
        this.id_code = id_code;
        this.first_name = first_name;
        this.second_name = second_name;
        this.amount = amount;
        this.email = email;

        this.jwt_date = jwt_date;
    }

    public Return_Data() {

    }
}
