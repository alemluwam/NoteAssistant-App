package edu.mum.cs544.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/todo")
public class TodoController {

	@RequestMapping(method = RequestMethod.GET)
	public String Todo(Model model) {
		// model.addAttribute("newToDoList", new ToDoList());
		return "todo/todo";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addTodo(Model model) {
		// model.addAttribute("toDoLists", toDoListService.findAll());
		return "todo/todo_add";
	}
}
