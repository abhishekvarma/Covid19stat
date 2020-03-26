package com.covid19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.covid19.services.Covid19Service;

@Controller
public class Covid19BaseController {
	
	@Autowired
	Covid19Service service;
	
	@GetMapping("/")
	public String Covid19Base(Model model) {
		//System.out.println(service.getMainData());
		model.addAttribute("allStats", service.getMainData());
		model.addAttribute("totalConformed", service.getTotalConformed(service.getMainData()));
		return "covid19landing";
	}
}
