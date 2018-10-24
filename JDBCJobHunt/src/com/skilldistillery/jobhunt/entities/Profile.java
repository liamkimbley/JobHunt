package com.skilldistillery.jobhunt.entities;

public class Profile {
	private int id;
	private String fname;
	private String lname;
	private Address address;
	private String coverLetter;
	private String resume;
	private User user;

	public Profile() {
	}

	public Profile(int id, String fname, String lname, Address address, String coverLetter, String resume, User user) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.coverLetter = coverLetter;
		this.resume = resume;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", fname=" + fname + ", lname=" + lname + ", coverLetter=" + coverLetter
				+ ", resume=" + resume + ", user=" + user + "]";
	}
}
