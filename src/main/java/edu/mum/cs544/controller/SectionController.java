package edu.mum.cs544.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SectionController {

	@RequestMapping("/section")
	public String home(){
		return "section";
	}
	
	@RequestMapping("/section/add")
	public String addSection(){
		return "section_add";
	}
}
