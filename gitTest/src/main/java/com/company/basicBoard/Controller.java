package com.company.basicBoard;


import org.springframework.web.bind.annotation.GetMapping;


@org.springframework.stereotype.Controller
public class Controller {
	@GetMapping(value ="/test")
	public String home() {
		return "Test";
	}
}
