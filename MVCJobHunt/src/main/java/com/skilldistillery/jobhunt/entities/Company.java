package com.skilldistillery.jobhunt.entities;

public class Company {
	private int id;
	private String name;
	private int jobsAvailable;
	private Boolean appliedFor;
	private String dateApplied;
	private String dateUpdated;
	private Boolean response;
	private Address address;

	public Company() {
	}

	public Company(int id, String name, int jobsAvailable, Boolean appliedFor, String dateApplied, String dateUpdated,
			Boolean response, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.jobsAvailable = jobsAvailable;
		this.appliedFor = appliedFor;
		this.dateApplied = dateApplied;
		this.dateUpdated = dateUpdated;
		this.response = response;
		this.address = address;
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

	public Boolean getAppliedFor() {
		return appliedFor;
	}

	public void setAppliedFor(Boolean appliedFor) {
		this.appliedFor = appliedFor;
	}

	public String getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(String dateApplied) {
		this.dateApplied = dateApplied;
	}

	public String getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Boolean getResponse() {
		return response;
	}

	public void setResponse(Boolean response) {
		this.response = response;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", jobsAvailable=" + jobsAvailable + ", appliedFor="
				+ appliedFor + ", dateApplied=" + dateApplied + ", dateUpdated=" + dateUpdated + ", response="
				+ response + ", address=" + address + "]";
	}

}
