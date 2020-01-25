package com.finhive.ISOreader.Migrations;

import org.springframework.boot.CommandLineRunner;

import com.finhive.ISOreader.Models.User;
import com.finhive.ISOreader.Repository.UserRepository;

public class DbInit implements CommandLineRunner {

	private UserRepository userRepository;

	public DbInit(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User Admin = new User("admin@test.com", "1245678", "token", 1, 1);
		this.userRepository.save(Admin);
		

	}

}
