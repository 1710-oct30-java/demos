package com.revature.beans;

public class Users {

		private int users_id;
		private String username;
		private String password;
		private String first_name;
		private String last_name;
		private String email;
		private int user_role_id;
		public Users() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Users(int users_id, String username, String password, String first_name, String last_name, String email,
				int user_role_id) {
			super();
			this.users_id = users_id;
			this.username = username;
			this.password = password;
			this.first_name = first_name;
			this.last_name = last_name;
			this.email = email;
			this.user_role_id = user_role_id;
		}
		public int getUsers_id() {
			return users_id;
		}
		public void setUsers_id(int users_id) {
			this.users_id = users_id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getFirst_name() {
			return first_name;
		}
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		public String getLast_name() {
			return last_name;
		}
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getUser_role_id() {
			return user_role_id;
		}
		public void setUser_role_id(int user_role_id) {
			this.user_role_id = user_role_id;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
			result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + user_role_id;
			result = prime * result + ((username == null) ? 0 : username.hashCode());
			result = prime * result + users_id;
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
			Users other = (Users) obj;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (first_name == null) {
				if (other.first_name != null)
					return false;
			} else if (!first_name.equals(other.first_name))
				return false;
			if (last_name == null) {
				if (other.last_name != null)
					return false;
			} else if (!last_name.equals(other.last_name))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (user_role_id != other.user_role_id)
				return false;
			if (username == null) {
				if (other.username != null)
					return false;
			} else if (!username.equals(other.username))
				return false;
			if (users_id != other.users_id)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Users [users_id=" + users_id + ", username=" + username + ", password=" + password + ", first_name="
					+ first_name + ", last_name=" + last_name + ", email=" + email + ", user_role_id=" + user_role_id
					+ "]";
		}
		
		
}
