package com.skilldistillery.jobhunt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Applications {

	@Column(name = "profile_id")
	private Profile prof;

	@Column(name = "company_id")
	private Company comp;

	public Applications() {
	}

	public Applications(Profile prof, Company comp) {
		super();
		this.prof = prof;
		this.comp = comp;
	}

	public Profile getProf() {
		return prof;
	}

	public void setProf(Profile prof) {
		this.prof = prof;
	}

	public Company getComp() {
		return comp;
	}

	public void setComp(Company comp) {
		this.comp = comp;
	}

	@Override
	public String toString() {
		return "Applications [prof=" + prof + ", comp=" + comp + "]";
	}

}
