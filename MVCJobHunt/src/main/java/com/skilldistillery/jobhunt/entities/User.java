package com.skilldistillery.jobhunt.entities;

public class User {

	private int id;
	private String password;
	private String username;
	private Profile profile;
	
	public User() {
	}
	
	public User(int id, String password, String username, Profile profile) {
		super();
		this.id = id;
		this.password = password;
		this.username = username;
		this.profile = profile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", username=" + username + "]";
	}
	
	
}

