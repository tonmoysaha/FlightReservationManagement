package com.flightreservation.entity;

import java.util.Set;

import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

public class Role extends AbstractEntity implements GrantedAuthority{

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

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return roleName;
	}
	
	
	
	
}
