package com.praveen.server.Rowmapper;

import com.praveen.server.Model.Transaction;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowtoTransaction implements RowMapper<Transaction> {

    @Override
    public Transaction mapRow(ResultSet resultSet, int i) throws SQLException {
        System.out.println(resultSet.toString());
        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(resultSet.getInt("transaction_number"));

        transaction.setAccountNumber(resultSet.getInt("account_number"));
        transaction.setCurrencySerial(resultSet.getInt("note_serial_number"));
        transaction.setLegal(resultSet.getBoolean("legal"));
        return transaction;
    }
}
