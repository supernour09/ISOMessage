package com.finhive.ISOreader.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finhive.ISOreader.Models.Privilege;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
	

}
