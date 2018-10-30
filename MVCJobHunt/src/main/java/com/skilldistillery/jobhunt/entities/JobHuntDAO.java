package com.skilldistillery.jobhunt.entities;

import java.util.List;

public interface JobHuntDAO {
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
	public Address updateAddress(Address addr);
	public Company updateCompany(Company comp);
	public User updateUser(User user);
	public Profile updateProfile(Profile prof);
	public boolean deleteAddress(int addrId);
	public boolean deleteUser(int userId);
	public boolean deleteProfile(int profId);
	public boolean deleteCompany(int compId);

}
