package com.skilldistillery.jobhunt.entities;

public class Applications {

	private Profile profile;
	private Company company;

	public Applications() {
	}

	public Applications(Profile profile, Company company) {
		super();
		this.profile = profile;
		this.company = company;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Applications [profile=" + profile + ", company=" + company + "]";
	}
}
