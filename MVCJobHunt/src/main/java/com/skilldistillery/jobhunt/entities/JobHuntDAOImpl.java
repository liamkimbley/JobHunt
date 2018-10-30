package com.skilldistillery.jobhunt.entities;

import java.util.List;

public class JobHuntDAOImpl implements JobHuntDAO {
	private static final String url = "jdbc:mysql://localhost:3306/jobhuntdb?useSSL=false";
	private static final String dbUser = "jobuser";
	private static final String dbPass = "jobuser";

	@Override
	public Company getCompanyById(int compId) {
		return null;

	}

	@Override
	public Company getCompanyByName(String name) {
		return null;

	}

	@Override
	public Address getAddressById(int addrId) {
		return null;

	}

	@Override
	public User getUserById(int uid) {
		return null;

	}

	@Override
	public User getUserByUsername(String name) {
		return null;

	}

	@Override
	public Profile getProfileById(int pid) {
		return null;

	}

	@Override
	public Profile getProfileByName(String fname, String lname) {
		return null;

	}

	@Override
	public List<Company> getApplicationsByProfileId(int pid) {
		return null;

	}

	@Override
	public Company addCompanyToDB(Company company) {
		return null;

	}

	@Override
	public Address addAddressToDB(Address addr) {
		return null;

	}

	@Override
	public Address updateAddress(Address addr) {
		return null;

	}

	@Override
	public Company updateCompany(Company comp) {
		return null;

	}

	@Override
	public User updateUser(User user) {
		return null;

	}

	@Override
	public Profile updateProfile(Profile prof) {
		return null;

	}

	@Override
	public boolean deleteAddress(int addrId) {
		return false;

	}

	@Override
	public boolean deleteUser(int userId) {
		return false;

	}

	@Override
	public boolean deleteProfile(int profId) {
		return false;

	}

	@Override
	public boolean deleteCompany(int compId) {
		return false;

	}

}
