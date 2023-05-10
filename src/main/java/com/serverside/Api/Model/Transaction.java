package com.serverside.Api.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private int senderId;


    @Column(name = "receiverId")
    private int receiverId;


    @Column(name = "amount")
    private double amount;


    @Column(name="Jwt")
    private  String jwt;

    @Column(name="dateDeT")
    private Date dateDeT;


    @Column(name="receiverName")
    private String receiverName;

    @Column(name="senderName")
    private String senderName;


}
