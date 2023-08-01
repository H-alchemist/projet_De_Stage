package com.serverside.Api.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "images")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Images {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    @Column(name = "User_id")
    int User_id;


    @Column(name = "image")
    String image;




}
