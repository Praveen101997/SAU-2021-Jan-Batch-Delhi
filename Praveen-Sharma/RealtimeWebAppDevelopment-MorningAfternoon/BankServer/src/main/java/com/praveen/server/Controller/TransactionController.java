package com.praveen.server.Controller;


import com.praveen.server.Model.Transaction;
import com.praveen.server.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


class TransactionPostRequest{
    Transaction transaction;
    int amount;
    TransactionPostRequest(Transaction transaction,int amount)
    {
        this.transaction=transaction;
        this.amount=amount;
    }
}



@RestController
@RequestMapping("/trans")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/getTransByT/{type}")
    @CrossOrigin("*")
    public ResponseEntity<List<Transaction>> getTransactionsByType(@PathVariable("type") int type)
    {
        return  new ResponseEntity<>(transactionService.getTransactionByType(type), HttpStatus.OK);
    }

    @GetMapping("/getTransByN/{accountNo}")
    @CrossOrigin("*")
    public ResponseEntity<List<Transaction>> getTransactionByAccount(@PathVariable("accountNo") int accountNumber){
        return new ResponseEntity<>(transactionService.getTransactionByAccount(accountNumber),HttpStatus.OK);
    }


    @PostMapping("/addTrans")
    @CrossOrigin("*")
    public ResponseEntity<Integer> addTransaction(@RequestBody TransactionPostRequest transactionPostRequest)
    {
        return new ResponseEntity<>(this.transactionService.addNewTransaction(transactionPostRequest.transaction, transactionPostRequest.amount),HttpStatus.OK);
    }
}
