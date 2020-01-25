package com.finhive.ISOreader.Models;

import javax.persistence.*;

@Entity
public class UserRole{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String permissionName;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false)
    private long roleId;
    

	public UserRole(String permissionName, Boolean status, long roleId) {
		super();
		this.permissionName = permissionName;
		this.status = status;
		this.roleId = roleId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
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
