package com.serverside.Api.Controlleur;


import com.serverside.Api.Dao.TransactionDao;
import com.serverside.Api.Model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class TransactionControlleur {


    @Autowired
    TransactionDao transactionDao;


    @PostMapping("/transaction/post")
    public ResponseEntity<Transaction> addT(@RequestBody Transaction transaction) {



            return new ResponseEntity<Transaction>(transactionDao.add(transaction), HttpStatus.OK);


    }




}
