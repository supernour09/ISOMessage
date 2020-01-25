package com.finhive.ISOreader.Models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Privilege {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String name;

	@ManyToMany(mappedBy = "privileges")
	private Collection<Role> roles;

	public Privilege(){
		
	}

	public Privilege(String name) {
		super();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
