package com.example;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.junit.After;
import org.junit.Assert;

import com.example.models.User;
import com.example.models.UserDAO;
import com.example.models.UserDBTemplate;

public class UserDaoTest {
	private EmbeddedDatabase db;
    UserDAO userDao;

    @Before
    public void setUp() {
    	db = new EmbeddedDatabaseBuilder()
    		.setType(EmbeddedDatabaseType.H2)
    		.addScript("create-db.sql")
    		.addScript("insert-data.sql")
    		.build();
    }

    @Test
    public void testFindByname() {
    	UserDBTemplate template = new UserDBTemplate();
    	template.setDataSource(db);

    	User user = template.getUser(1);

    	Assert.assertNotNull(user);
    	Assert.assertEquals(1, user.getId().intValue());
    	Assert.assertEquals("Janet", user.getName());
    	Assert.assertEquals("Valdez", user.getApellido());
    	Assert.assertEquals("password1234", user.getPassword());
    	Assert.assertEquals("gia@gmail.com", user.getEmail());
    	
    }
    
    @Test
    public void listUser() {
    	UserDBTemplate template = new UserDBTemplate();
    	template.setDataSource(db);
    	
    	int sizedatabase = template.listUsers().size();
    	
    	Assert.assertEquals(sizedatabase,4);
    	
    }
    
    @Test
    public void deleteUser() {
    	UserDBTemplate template = new UserDBTemplate();
    	template.setDataSource(db);
    	
    	int sizeinit = template.listUsers().size();
    	template.delete(1);
    	int sizefinal = template.listUsers().size();
    	
    	Assert.assertEquals(sizeinit-1,sizefinal);
    	Assert.assertEquals(3,sizefinal);
    	
    }
    
    @Test
    public void createUser() {
    	UserDBTemplate template = new UserDBTemplate();
    	template.setDataSource(db);
    	
    	int sizeinit = template.listUsers().size();
    	template.create("Dante", "Gomez", "d@mail", "pass123456");
    	int sizefinal = template.listUsers().size();
    	
    	Assert.assertEquals(sizeinit+1,sizefinal);
    	Assert.assertEquals(5,sizefinal);
    	
    	User user = template.getUser(5);
    	Assert.assertNotNull(user);
    	Assert.assertEquals("Dante", user.getName());
    	
    }

    @After
    public void tearDown() {
        db.shutdown();
    }
}
