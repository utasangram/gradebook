package com.learnsec;

public class User {

	private String id;
	private String name;
	private String username;
	private String password;
	
	//constructor for a new User with specified parameters
	User(String id,String name,String username,String password) {
		this.setId(id);
		this.name = name;
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public boolean validateCredentials(String username, String password) {
		boolean verified = false;
		if(username.equals("javier") && password.equals("abcd")) {
			verified = true;
		}
		return verified;
	}
	
}
