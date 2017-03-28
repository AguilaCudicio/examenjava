package com.example.models;

public class User {
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private Integer id;

	public void setName(String name) {
		this.nombre = name;
	}
	public String getName() {
		return nombre;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
