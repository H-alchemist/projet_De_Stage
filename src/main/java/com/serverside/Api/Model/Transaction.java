package com.serverside.Api.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private int id;

    @Column(name = "sender_id")
    private Long sender_id;


    @Column(name = "receiver_id")
    private Long receiver_id;


    @Column(name = "amount")
    private double amount;


    @Column(name="Jwt")
    private  String jwt;
}
