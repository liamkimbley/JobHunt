package com.skilldistillery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.jobhunt.entities.Address;
import com.skilldistillery.jobhunt.entities.Applications;
import com.skilldistillery.jobhunt.entities.Company;
import com.skilldistillery.jobhunt.entities.Profile;
import com.skilldistillery.jobhunt.entities.User;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private User user = null;
	private Company comp = null;
	private Address addr = null;
	private Profile prof = null;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private List<Company> companies = new ArrayList<>();
	private static final String url = "jdbc:mysql://localhost:3306/jobhuntdb?useSSL=false";
	private static final String dbUser = "jobuser";
	private static final String dbPass = "jobuser";
	private static final String getCompany = "SELECT id, name, jobs_available, applied, response FROM company WHERE id = ?";
	private static final String getUser = "SELECT id, username, password FROM user WHERE id = ?";
	private static final String getProfile = "SELECT id, first_name, last_name, FROM profile WHERE id = ?";
	private static final String getAddress = "SELECT id, street, street2, city, state, country FROM address WHERE id = ?";

	@Override
	public Company getCompanyById(int compId) {
		ResultSet rs = null;

		try {
			conn = getDBConnection();
			stmt = conn.prepareStatement(getCompany);
			stmt.setInt(1, compId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				comp = new Company();
				comp.setId(compId);
				comp.setName(rs.getString(2));
				comp.setJobsAvailable(rs.getInt(3));
				comp.setAppliedFor(rs.getBoolean(4));
				comp.setResponse(rs.getBoolean(5));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return comp;

	}

	@Override
	public Company getCompanyByName(String name) {
		return null;

	}

	@Override
	public Address getAddressById(int addrId) {
		ResultSet rs = null;

		try {
			conn = getDBConnection();
			stmt = conn.prepareStatement(getAddress);
			stmt.setInt(1, addrId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				addr = new Address();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return addr;

	}

	@Override
	public User getUserById(int uid) {
		ResultSet rs = null;

		try {
			conn = getDBConnection();
			stmt = conn.prepareStatement(getUser);
			stmt.setInt(1, uid);
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(uid);
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;

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
	public List<Applications> getApplicationsByProfileId(int pid) {
		return null;

	}

	@Override
	public Company addCompanyToDB(Company company) {
		return null;

	}

	private Connection getDBConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			conn = DriverManager.getConnection(url, dbUser, dbPass);
			return conn;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return conn;
	}
}
