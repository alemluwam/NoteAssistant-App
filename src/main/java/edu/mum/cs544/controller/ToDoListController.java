package edu.mum.cs544.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs544.domain.ToDoList;
import edu.mum.cs544.service.ToDoListService;

@Controller
@RequestMapping("/todolists")
public class ToDoListController {
	
	@Autowired
	private ToDoListService toDoListService;
	
	@RequestMapping(method= RequestMethod.GET)
	public String newToDoList(Model model){
		model.addAttribute("newToDoList", new ToDoList());
		return "todolist/addToDoList";
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public String saveToDoList(@ModelAttribute("newToDoList") ToDoList toDoList){
		toDoListService.save(toDoList);
		return "redirect:todolists/all";
	}

	@RequestMapping(value = "/all", method=RequestMethod.GET)
	public String getAllToDoLists(Model model){
		model.addAttribute("toDoLists", toDoListService.findAll());
		return "todolist/toDoLists";
	}
	
	@RequestMapping(value="/{toDoListId}", method=RequestMethod.GET)
	public String editToDoList(@PathVariable("toDoListId") Long id, Model model){
		model.addAttribute("newToDoList", toDoListService.findById(id));
		return "todolist/addToDoList";
	}
	
	@RequestMapping(value="/{toDoListId}", method=RequestMethod.POST)
	public String updateToDoList(@ModelAttribute("newToDoList") ToDoList toDoList){
		toDoListService.save(toDoList);
		return "redirect:/todolists/all";
	}
	
	/*@RequestMapping(value="/delete/{toDoListId}", method=RequestMethod.DELETE)
	public void delete(@PathVariable("toDoListId") Long id){
		System.out.println("delte method");
		if(toDoListService.findById(id) != null){
			toDoListService.delete(id);
		}
	}
	*/
	
	public ToDoListService getToDoListService() {
		return toDoListService;
	}

	public void setToDoListService(ToDoListService toDoListService) {
		this.toDoListService = toDoListService;
	}
	
	
}
