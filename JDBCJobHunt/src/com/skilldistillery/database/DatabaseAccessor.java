package com.skilldistillery.database;


import java.util.List;

import com.skilldistillery.jobhunt.entities.Address;
import com.skilldistillery.jobhunt.entities.Applications;
import com.skilldistillery.jobhunt.entities.Company;
import com.skilldistillery.jobhunt.entities.Profile;
import com.skilldistillery.jobhunt.entities.User;

public interface DatabaseAccessor {

	public Company getCompanyById(int compId);
	public Company getCompanyByName(String name);
	public Address getAddressById(int addrId);
	public User getUserById(int uid);
	public User getUserByUsername(String name);
	public Profile getProfileById(int pid);
	public Profile getProfileByName(String fname, String lname);
	public List<Company> getApplicationsByProfileId(int pid);
	public Company addCompanyToDB(Company company);
	public Address addAddressToDB(Address addr);
}
