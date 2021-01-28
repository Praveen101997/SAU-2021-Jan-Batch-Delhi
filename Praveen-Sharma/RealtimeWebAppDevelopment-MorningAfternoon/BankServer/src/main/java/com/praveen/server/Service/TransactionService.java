package com.praveen.server.Service;

import com.praveen.server.Dao.TransactionDao;
import com.praveen.server.Model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TransactionService {

    @Autowired
    TransactionDao transactionDao;

    public int addNewTransaction(Transaction transaction, int amount)
    {
        return this.transactionDao.addNewTransaction(transaction,amount);
    }

    public List<Transaction> getTransactionByAccount(int accountNumber)
    {
        return transactionDao.getTransactionByAccountNumber(accountNumber);
    }

    public List<Transaction> getTransactionByType(int type)
    {
        return transactionDao.getTransactions(type);
    }

}
