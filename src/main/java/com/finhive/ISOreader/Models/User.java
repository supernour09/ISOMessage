package com.finhive.ISOreader.Models;

import javax.persistence.*;




@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private long roleId;

    @Column(nullable = false)
    private int status;

    
	public User(String email, String password, String token, long roleId,int status) {
		super();
		this.email = email;
		this.password = password;
		this.token = token;
		this.roleId = roleId;
		this.status=status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getId() {
		return id;
	}


}
