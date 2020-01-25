package com.finhive.ISOreader.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.finhive.ISOreader.Models.*;
import com.finhive.ISOreader.Repository.UserRepository;



@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("index")
	@ResponseStatus(code = HttpStatus.OK)
	public List<User> Index(){
		return this.userRepository.findAll();
	}
	
	@PostMapping("store")
	@ResponseStatus(code = HttpStatus.OK)
	public User Store(@RequestBody User user){
		return this.userRepository.save(user);
	}
	
	
}
