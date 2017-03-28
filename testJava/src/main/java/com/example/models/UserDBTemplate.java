package com.example.models;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDBTemplate implements UserDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void create(String name, String surname, String email, String password) {
		String SQL = "insert into User (name, surname, email, password) values (?,?,?,?)";
		jdbcTemplateObject.update( SQL, name, surname, email, password);
		return;
	}
	
	
	public User getUser(Integer id) {
		String SQL = "select * from User where id = ?";
		User user = jdbcTemplateObject.queryForObject(SQL, 
				new Object[]{id}, new UserMapper());

		return user;
	}
	public List<User> listUsers() {
		String SQL = "select * from User";
		List <User> users = jdbcTemplateObject.query(SQL, new UserMapper());
		return users;
	}
	public void delete(Integer id) {
		String SQL = "delete from User where id = ?";
		jdbcTemplateObject.update(SQL, id);
		return;
	}

}
