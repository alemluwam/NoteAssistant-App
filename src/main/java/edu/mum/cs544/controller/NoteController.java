package edu.mum.cs544.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/note")
public class NoteController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String Contact(Model model) {
		// model.addAttribute("newToDoList", new ToDoList());
		return "note/note";
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String addContact(Model model){
		//model.addAttribute("toDoLists", toDoListService.findAll());
		return "note/note_add";
	}
}
