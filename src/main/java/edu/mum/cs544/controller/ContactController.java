package edu.mum.cs544.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {

	@RequestMapping("/contact")
	public String home(){
		return "contact";
	}
	
	@RequestMapping("/contact/add")
	public String addContact(){
		return "contact_add";
	}
}
