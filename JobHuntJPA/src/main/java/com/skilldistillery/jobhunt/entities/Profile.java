package com.skilldistillery.jobhunt.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "cover_letter")
	private String coverLetter;

	private String resume;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address addr;
	
//	end of fields


	public Profile() {
	}

	public Profile(int id, String firstName, String lastName, String coverLetter, String resume, User user,
			Address addr) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.coverLetter = coverLetter;
		this.resume = resume;
		this.user = user;
		this.addr = addr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", coverLetter="
				+ coverLetter + ", resume=" + resume + ", user=" + user + ", addr=" + addr + "]";
	}

}
