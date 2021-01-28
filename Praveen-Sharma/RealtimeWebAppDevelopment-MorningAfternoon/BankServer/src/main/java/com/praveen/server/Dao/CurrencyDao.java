package com.praveen.server.Dao;

import com.praveen.server.Model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class CurrencyDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean duplicateCurrency(int serialNumber)
    {
        Integer result=this.jdbcTemplate.queryForObject("Select count(*) from currency where note_serial_number = "+serialNumber,Integer.class);
//        System.out.println(result);
        return result >0 ? true  : false ;
     }


    public void addCurrency(Currency currency)
    {
            final String add_new_note="insert into currency(note_amount,note_serial_number) values(? , ?)";
            KeyHolder keyHolder = new GeneratedKeyHolder();
            this.jdbcTemplate.update(connection -> {
                PreparedStatement stmt = connection.prepareStatement(add_new_note);
                stmt.setInt(1,currency.getAmount());
                stmt.setInt(2, currency.getSerialNumber());
                return stmt;
            }, keyHolder);
         }





}
