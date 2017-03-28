package com.example.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.models.User;
import com.example.models.UserDBTemplate;



@RestController
public class UserController {
	@RequestMapping("/usuarios")
	public  List<User> usuarios() {

		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		UserDBTemplate userTemplate = 
				(UserDBTemplate)context.getBean("userDBTemplate");

		List<User> users = userTemplate.listUsers();

		return users;

	}
}
