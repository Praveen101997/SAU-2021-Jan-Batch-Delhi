package com.praveen.server.Dao;

import com.praveen.server.Rowmapper.RowtoTransaction;
import com.praveen.server.Model.Currency;
import com.praveen.server.Model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class TransactionDao {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CurrencyDao currencyDao;

    public int addNewTransaction(Transaction transaction,int amount)
    {
        boolean legalTransaction=false;
        if(!currencyDao.duplicateCurrency(transaction.getCurrencySerial()))
        {
            legalTransaction=true;
            currencyDao.addCurrency(new Currency(transaction.getCurrencySerial(),amount));
        }
        final String add_new_transaction = "Insert into transactions(account_number,note_serial_number,legal) values (?,?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        boolean finalLegalTransaction = legalTransaction;
        this.jdbcTemplate.update(connection -> {
            PreparedStatement stmt = connection.prepareStatement(add_new_transaction,new String[]{"transaction_number"});
            stmt.setInt(1,transaction.getAccountNumber());
            stmt.setInt(2, transaction.getCurrencySerial());
            stmt.setBoolean(3, finalLegalTransaction);
            return stmt;
        }, keyHolder);
        return keyHolder.getKey().intValue();

    }

    public List<Transaction> getTransactionByAccountNumber(int accountNumber)
    {
        final String get_transaction="select * from transactions where account_number= "+accountNumber;
        return this.jdbcTemplate.query(get_transaction,new RowtoTransaction());
    }

    public List<Transaction> getTransactions(int type)
    {
        String get_transaction = "";
        if (type==0){
            get_transaction="select * from transactions";
        }else if (type==1){
            get_transaction="select * from transactions where legal = true";
        }else{
            get_transaction="select * from transactions where legal = false";
        }
        return  this.jdbcTemplate.query(get_transaction,new RowtoTransaction());
    }

}
