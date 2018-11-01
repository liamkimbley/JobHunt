package com.skilldistillery.jobhunt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.jobhunt.entities.JobHuntDAO;

@Controller
public class JobController {

	@Autowired
	private JobHuntDAO dao;
	
	@RequestMapping(path = "ping.do", method = RequestMethod.GET)
	public String getInfo() {
		return "job";
	}
}
