package edu.mum.cs544.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import edu.mum.cs544.domain.Section;
//import edu.mum.cs544.domain.ToDoList;
//import edu.mum.cs544.service.SectionService;

@Controller
@RequestMapping("/section")
public class SectionController {

	// @Autowired
	// private SectionService sectionService;
	//

	@RequestMapping(method = RequestMethod.GET)
	public String Section(Model model) {
		// model.addAttribute("newToDoList", new ToDoList());
		return "section/section";
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String addSection(Model model){
		//model.addAttribute("toDoLists", toDoListService.findAll());
		return "section/section_add";
	}
}
