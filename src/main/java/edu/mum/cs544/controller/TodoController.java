package edu.mum.cs544.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs544.domain.Section;
import edu.mum.cs544.domain.ToDoList;
import edu.mum.cs544.domain.User;
import edu.mum.cs544.service.SectionService;
import edu.mum.cs544.service.ToDoListService;
import edu.mum.cs544.service.UserService;

/**
 * @author Luwam
 *
 */
@Controller
@RequestMapping("/todo")
public class TodoController {
	@Autowired
	private SectionService sectionService;
	@Autowired
	private ToDoListService toDoListService;
	@Autowired
	private UserService userService;

	@ModelAttribute("sections")
	public List<Section> getSections() {
		User user = userService.findOne(1L);
		return (user != null) ? sectionService.findByUserId(user.getUserId()) : null;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String Todo(Model model, @ModelAttribute("sections") List<Section> sections) {
		List<ToDoList> toDoLists = new ArrayList<>();
		for (Section section : sections) {
			toDoLists.addAll(section.getToDoLists());
		}
		model.addAttribute("toDoLists", toDoLists);
		return "todo/todo";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addTodo(Model model) {
		model.addAttribute("newToDoList", new ToDoList());
		return "todo/todo_add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveTodo(@Valid @ModelAttribute("newToDoList") ToDoList toDoList, Model model, BindingResult result) {
		String view = "redirect:/todo";
		if (result.hasErrors()) {
			view = "todo_add";
		} else {
			toDoListService.save(toDoList);
		}
		return view;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String searchTodo(Model model, HttpServletRequest request) {
		String searchCriteria = request.getParameter("search");
		String searchCategory = request.getParameter("searchby");

		if (searchCriteria == null) {
			return "redirect:/todo";
		}

		User user = userService.findOne(1L);
		List<Section> sections = sectionService.findByUserId(user.getUserId());
		List<ToDoList> toDoLists = new ArrayList<>();
		switch (searchCategory) {
		case "title":
			for (Section section : sections) {
				for (ToDoList toDoList : section.getToDoLists()) {
					if (toDoList.getTitle().toLowerCase().contains(searchCriteria.toLowerCase())) {
						toDoLists.add(toDoList);
					}
				}
			}
			model.addAttribute("toDoLists", toDoLists);
			break;
		case "description":
			for (Section section : sections) {
				for (ToDoList toDoList : section.getToDoLists()) {
					if (toDoList.getDescription().toLowerCase().contains(searchCriteria.toLowerCase())) {
						toDoLists.add(toDoList);
					}
				}
			}
			model.addAttribute("toDoLists", toDoLists);
			break;
		}
		return "todo/todo";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		if (toDoListService.findById(id) != null) {
			toDoListService.delete(id);
		}
		return "redirect:/todo";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, Model model) {
		ToDoList t = toDoListService.findById(id);
		System.out.println(t == null ? "It's null" : "It's not null");
		System.out.println("Get To Do List Id: " + t.getToDoListId());
		model.addAttribute("newToDoList", t);
		model.addAttribute("id", t.getToDoListId());
		return "todo/todo_add";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String editToDoList(@ModelAttribute("newToDoList") ToDoList t, @PathVariable("id") Long id) {
		t.setToDoListId(id);
		toDoListService.save(t);
		return "redirect:/todo";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
