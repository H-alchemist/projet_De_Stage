package com.serverside.Api.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sender_id")
    private int sender_id;


    @Column(name = "receiver_id")
    private int receiver_id;


    @Column(name = "amount")
    private double amount;


    @Column(name="Jwt")
    private  String jwt;


}
