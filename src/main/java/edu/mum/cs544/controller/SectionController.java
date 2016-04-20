package edu.mum.cs544.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs544.domain.User;
import edu.mum.cs544.service.SectionService;
import edu.mum.cs544.service.UserService;

@Controller
@RequestMapping("/section")
public class SectionController {

	 @Autowired
	 private SectionService sectionService;
	 @Autowired
	 private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String Section(Model model) {
		User user = userService.findOne(1L);
		model.addAttribute("sections", sectionService.findByUserId(user.getUserId()));
		return "section/section";
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String addSection(Model model){
		//model.addAttribute("toDoLists", toDoListService.findAll());
		return "section/section_add";
	}
	
	//Luwam

	
	
	
}
