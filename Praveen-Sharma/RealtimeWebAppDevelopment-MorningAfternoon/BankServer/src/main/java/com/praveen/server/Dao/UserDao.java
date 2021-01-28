package com.praveen.server.Dao;

import com.praveen.server.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {


    @Autowired
    JdbcTemplate jdbcTemplate;

    public String addUser(User user)
    {
        System.out.println(user.toString());
        if(getByAccountNumber(user.getAccountNumber())==null) {
            final String add_new_user = "insert into users(username,account_number) values(? , ?)";
            KeyHolder keyHolder = new GeneratedKeyHolder();
            this.jdbcTemplate.update(connection -> {
                PreparedStatement stmt = connection.prepareStatement(add_new_user);
                stmt.setString(1, user.getUserName());
                stmt.setInt(2, user.getAccountNumber());
                return stmt;
            }, keyHolder);
            return "User can now access account";
        }
        return "User Data already present in database";
    }

    public User getByAccountNumber(int accountNumber)
    {
        final String get_by_account_number = "select username,account_number from users where account_number = ?";
        try{
            return this.jdbcTemplate.queryForObject(get_by_account_number, this::mapRowToUser, accountNumber);
        }
        catch (Exception e)
        {
            return null;
        }
    }


    private User mapRowToUser(ResultSet resultSet, int rowNumber) throws SQLException {
        User user= new User();
        user.setUserName(resultSet.getString("username"));
        user.setAccountNumber(resultSet.getInt("account_number"));
        return  user;
    }
}
