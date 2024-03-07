package com.company.basicBoard;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@org.springframework.stereotype.Controller
public class Controller {
	@GetMapping(value ="/test")
	public String home() {		
		return "Test";
	}

	@GetMapping(value ="/test2")
	public String test2() {
		return "";
	}
	
}
