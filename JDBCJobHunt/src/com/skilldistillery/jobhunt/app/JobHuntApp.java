package com.skilldistillery.jobhunt.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.database.DatabaseAccessor;
import com.skilldistillery.database.DatabaseAccessorObject;
import com.skilldistillery.jobhunt.entities.Address;
import com.skilldistillery.jobhunt.entities.Company;
import com.skilldistillery.jobhunt.entities.Profile;
import com.skilldistillery.jobhunt.entities.User;

public class JobHuntApp {
	private DatabaseAccessor db = new DatabaseAccessorObject();
	private Scanner sc = new Scanner(System.in);
	private Company comp;
	private User user;
	private Profile prof;
	private Address addr;
	private List<Company> companies = new ArrayList<>();

	public static void main(String[] args) {
		JobHuntApp app = new JobHuntApp();
		app.launch();
	}
	
	private void launch() {
		test();
//		startUserInterface();
		sc.close();
	}
	
	private void test() {
		comp = db.getCompanyById(1);
		System.out.println(comp);
		prof = db.getProfileById(1);
		System.out.println(prof);
	}

	private void startUserInterface() {
		boolean flag = true;

		System.out.println("Welcome to The Job Hunt!");
		
		while(flag) {
			
		}
	}
}
