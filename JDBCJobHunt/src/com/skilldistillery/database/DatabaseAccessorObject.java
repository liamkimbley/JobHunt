package com.skilldistillery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.jobhunt.entities.Address;
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
	private static final String getCompanyByName = "SELECT id, name, jobs_available, applied, response FROM company WHERE name = ?";
	private static final String getUser = "SELECT id, username, password FROM user WHERE id = ?";
	private static final String getUserByName = "SELECT id, username, password FROM user WHERE username = ?";
	private static final String getProfile = "SELECT id, first_name, last_name FROM profile WHERE id = ?";
	private static final String getProfileByName = "SELECT id, first_name, last_name, FROM profile WHERE first_name = ? AND last_name = ?";
	private static final String getAddress = "SELECT id, street, street2, city, state, country FROM address WHERE id = ?";
	private static final String getApplications = "SELECT id, name, jobs_available, applied, response FROM company JOIN Applications ON applications.company_id = comapny.id WHERE applications.profile_id = ?";
	private static final String addAddressToDB = "INSERT into address (street, city, state, country) VALUES (?,?,?,?)";
	private static final String addCompanyToDB = "INSERT into company (name) VALUES (?)";

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
		ResultSet rs = null;

		try {
			conn = getDBConnection();
			stmt = conn.prepareStatement(getCompanyByName);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			if (rs.next()) {
				comp = new Company();
				comp.setId(rs.getInt(1));
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
	public Address getAddressById(int addrId) {
		ResultSet rs = null;

		try {
			conn = getDBConnection();
			stmt = conn.prepareStatement(getAddress);
			stmt.setInt(1, addrId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				addr = new Address();
				addr.setStreet(rs.getString(2));
				if (rs.getString(3) != null) {
					addr.setStreet2(rs.getString(3));
				}
				addr.setCity(rs.getString(4));
				addr.setState(rs.getString(5));
				addr.setCountry(rs.getString(6));
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
		ResultSet rs = null;

		try {
			conn = getDBConnection();
			stmt = conn.prepareStatement(getUserByName);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
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
	public Profile getProfileById(int pid) {
		ResultSet rs = null;

		try {
			conn = getDBConnection();
			stmt = conn.prepareStatement(getProfile);
			stmt.setInt(1, pid);
			rs = stmt.executeQuery();
			if (rs.next()) {
				prof = new Profile();
				prof.setId(pid);
				prof.setFname(rs.getString(2));
				prof.setLname(rs.getString(3));
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
		return prof;

	}

	@Override
	public Profile getProfileByName(String fname, String lname) {
		ResultSet rs = null;

		try {
			conn = getDBConnection();
			stmt = conn.prepareStatement(getProfileByName);
			stmt.setString(1, fname);
			stmt.setString(2, lname);
			rs = stmt.executeQuery();
			if (rs.next()) {
				prof = new Profile();
				prof.setId(rs.getInt(1));
				prof.setFname(rs.getString(2));
				prof.setLname(rs.getString(3));
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
		return prof;

	}

	@Override
	public List<Company> getApplicationsByProfileId(int pid) {
		ResultSet rs = null;

		try {
			conn = getDBConnection();
			stmt = conn.prepareStatement(getApplications);
			stmt.setInt(1, pid);
			rs = stmt.executeQuery();
			while (rs.next()) {
				comp = new Company();
				comp.setId(rs.getInt(1));
				comp.setName(rs.getString(2));
				comp.setJobsAvailable(rs.getInt(3));
				comp.setAppliedFor(rs.getBoolean(4));
				comp.setResponse(rs.getBoolean(5));
				companies.add(comp);
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
		return companies;
	}

	@Override
	public Company addCompanyToDB(Company company) {
		int compID;
		int updateCount = 0;
		ResultSet rs = null;

		try {
			conn = getDBConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(addCompanyToDB, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, comp.getName());
			updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				rs = stmt.getGeneratedKeys();
				compID = rs.getInt(1);
				comp.setId(compID);
			} else {
				comp = null;
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.err.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error inserting actor: " + comp);
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
	public Address addAddressToDB(Address addr) {
		int addrID;
		int updateCount = 0;
		ResultSet rs = null;

		try {
			conn = getDBConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(addAddressToDB, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, addr.getStreet());
			stmt.setString(2, addr.getCity());
			stmt.setString(3, addr.getState());
			stmt.setString(4, addr.getCountry());
			updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				rs = stmt.getGeneratedKeys();
				addrID = rs.getInt(1);
				addr.setId(addrID);
			} else {
				addr = null;
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.err.println("Error trying to rollback");
				}
			}
			throw new RuntimeException("Error inserting actor: " + addr);
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
