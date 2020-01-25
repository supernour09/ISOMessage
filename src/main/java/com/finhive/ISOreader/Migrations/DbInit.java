package com.finhive.ISOreader.Migrations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.finhive.ISOreader.Models.User;
import com.finhive.ISOreader.Repository.*;


@Service
public class DbInit implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
  
    @Autowired
    private RoleRepository roleRepository;
  
    @Autowired
    private PrivilegeRepository privilegeRepository;

	public DbInit(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		//TODO complete this https://www.baeldung.com/role-and-privilege-for-spring-security-registration
		User Admin = new User("admin@test.com", "1245678", "token", 1, 1);
		this.userRepository.save(Admin);
	}

}
