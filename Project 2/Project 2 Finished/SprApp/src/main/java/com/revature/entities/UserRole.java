package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_roles")
public class UserRole {
	@Id
	@Column(name="user_role_id")
	private int roleId;
	@Column(name="role")
	private String role;
	public UserRole() {
		super();
	}
	public UserRole(int roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + roleId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (roleId != other.roleId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserRole [roleId=" + roleId + ", role=" + role + "]";
	}
	
	
}