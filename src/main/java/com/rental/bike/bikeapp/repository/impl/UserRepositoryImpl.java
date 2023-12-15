package com.rental.bike.bikeapp.repository.impl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rental.bike.bikeapp.modal.User;
import com.rental.bike.bikeapp.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
	private final JdbcTemplate jdbcTemplate;
	
	  @Autowired
	  public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
		  this.jdbcTemplate = jdbcTemplate;
	  }

	@Override
	public User findByUserNameAndPassword(String userName, String password) {
		
		 String sql = "SELECT * FROM users WHERE user_name = ? AND password = ?";
		 List<User> users = jdbcTemplate.query(sql, new Object[]{userName, password},
	        		new int[] { Types.VARCHAR, Types.VARCHAR }, userRowMapper());
	        		//jdbcTemplate.query(sql, userRowMapper());
		 return users.isEmpty() ? null : users.get(0);
	}

	private RowMapper<User> userRowMapper() {
        return (rs, rowNum) -> {
            User user = new User();
            user.setUserName(rs.getString("user_name"));
            user.setPassword(rs.getString("password"));
            return user;
        };
    }
	
}
