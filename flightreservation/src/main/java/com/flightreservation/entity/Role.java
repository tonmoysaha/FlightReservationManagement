package com.flightreservation.entity;

import java.util.Set;

import javax.persistence.ManyToMany;

public class Role extends AbstractEntity{

	private String roleName;
	
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
	
	
}
