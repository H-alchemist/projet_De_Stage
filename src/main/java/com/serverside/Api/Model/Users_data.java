package com.serverside.Api.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Entity
@Table(name="Users_data")
@Data
public class Users_data {

    @Id
    @Column(name = "id_code" )
    private Long id_code=0L;

    @Column(name="first_name")
    private String first_name;

    @Column(name="second_name")
    private String second_name;

    @Column(name="amount")
    private double amount;

    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "password")
    private String password;

    @Column(name = "login_date")
    private Timestamp jwt_date;

    public Users_data(Long id_code, String first_name, String second_name, double amount, String email, String password,Timestamp jwt_date) {
        this.id_code = id_code;
        this.first_name = first_name;
        this.second_name = second_name;
        this.amount = amount;
        this.email = email;
        this.password = password;
        this.jwt_date = jwt_date;
    }

    public Users_data() {

    }
}
