package com.okorkut.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	private static final Logger logger = LogManager.getLogger(MainController.class);

	@GetMapping("/")
	public String home(HttpServletRequest request){
		logger.info("home method started.");
		request.setAttribute("mode", "MODE_HOME");
		
		logger.info("home method complated.");
		return "index";
	}
}
