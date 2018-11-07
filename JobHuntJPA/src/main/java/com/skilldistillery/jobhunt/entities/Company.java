package com.skilldistillery.jobhunt.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@Column(name = "jobs_available")
	private int jobsAvailable;

	@Column(name = "date_applied")
	private LocalDate dateApplied;

	@UpdateTimestamp
	@Column(name = "date_updated")
	private LocalDate dateUpdated;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address addr;

	private Boolean response;
	
//	end of fields

	public Company() {
	}

	public Company(int id, String name, int jobsAvailable, LocalDate dateApplied, LocalDate dateUpdated, Address addr,
			Boolean response) {
		super();
		this.id = id;
		this.name = name;
		this.jobsAvailable = jobsAvailable;
		this.dateApplied = dateApplied;
		this.dateUpdated = dateUpdated;
		this.addr = addr;
		this.response = response;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getJobsAvailable() {
		return jobsAvailable;
	}

	public void setJobsAvailable(int jobsAvailable) {
		this.jobsAvailable = jobsAvailable;
	}

	public LocalDate getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(LocalDate dateApplied) {
		this.dateApplied = dateApplied;
	}

	public LocalDate getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(LocalDate dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public Boolean getResponse() {
		return response;
	}

	public void setResponse(Boolean response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", jobsAvailable=" + jobsAvailable + ", dateApplied="
				+ dateApplied + ", dateUpdated=" + dateUpdated + ", addr=" + addr + ", response=" + response + "]";
	}

}
