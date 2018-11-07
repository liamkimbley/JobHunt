package com.skilldistillery.jobhunt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String street;
	private String street2;
	private String city;
	private String state;
	private String country;
	private int zip;
	
//	end of fields


	public Address() {
	}

	public Address(int id, String street, String street2, String city, String state, String country, int zip) {
		super();
		this.id = id;
		this.street = street;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", street2=" + street2 + ", city=" + city + ", state="
				+ state + ", country=" + country + ", zip=" + zip + "]";
	}

}
