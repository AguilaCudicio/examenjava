package com.example.models;


import java.util.List;
import javax.sql.DataSource;

public interface UserDAO {

	public void setDataSource(DataSource ds);


	public void create(String name, String surname, String email, String password);


   public User getUser(Integer id);
   

   public List<User> listUsers();
   

   public void delete(Integer id);
   
}