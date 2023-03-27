package com.serverside.Api.Reposetries;

import com.serverside.Api.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Transactionrepo extends JpaRepository <Transaction , Long> {


}
