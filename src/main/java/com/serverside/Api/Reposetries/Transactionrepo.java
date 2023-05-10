package com.serverside.Api.Reposetries;

import com.serverside.Api.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Transactionrepo extends JpaRepository <Transaction , Long> {

    List<Transaction>  getTransactionsByReceiverId(int receiver_id);




//        @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.receiver_id = :receiverId")
//        Double getSumAmountByReceiverId(@Param("receiverId") int receiverId);


   @Query("SELECT t.amount, t.dateDeT,t.receiverName, t.senderName  FROM Transaction t WHERE t.receiverId = :receiverId")
        List<Object[]> getReceiverList(@Param("receiverId") int receiverId);

    @Query("SELECT t.amount, t.dateDeT,t.receiverName, t.senderName  FROM Transaction t WHERE t.senderId = :senderId")
    List<Object[]> getSenderList(@Param("senderId") int senderId);



}
