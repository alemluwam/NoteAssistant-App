package edu.mum.cs544.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.cs544.domain.Note;
import edu.mum.cs544.domain.Section;
import edu.mum.cs544.domain.User;
import edu.mum.cs544.service.NoteService;
import edu.mum.cs544.service.SectionService;
import edu.mum.cs544.service.UserService;

/**
 * @author Siken MS Dongol
 *
 */
@Controller
@RequestMapping("/note")
public class NoteController {

	@Autowired
	private SectionService sectionService;

	@Autowired
	private NoteService noteService;

	@Autowired
	private UserService userService;

	@ModelAttribute("sections")
	public List<Section> getSections() {
		User user = userService.findOne(1L);
		return (user != null) ? sectionService.findByUserId(user.getUserId()) : null;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String Note(Model model, @ModelAttribute("sections") List<Section> sections) {
		List<Note> notes = new ArrayList<>();
		for (Section section : sections) {
			notes.addAll(section.getNotes());
		}
		model.addAttribute("notes", notes);
		return "note/note";
	}
	
	// Display Add -- Form
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addNote(Model model) {
		model.addAttribute("newNote", new Note());
		return "note/note_add";
	}

	// SAVE ADD -- NOTE
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveNote(@Valid @ModelAttribute("newNote") Note note, Model model, BindingResult result) {
		String view = "redirect:/note";
		if (result.hasErrors()) {
			view = "note_add";
		} else {
			noteService.save(note);
		}
		return view;
	}

	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public String NoteFind(Model model, @RequestParam("search") String search,
			@RequestParam("searchby") String searchby, @RequestParam("section") Long sectionId) {
		switch (searchby) {
		case "text":
			model.addAttribute("notes", noteService.findByContent(search, sectionId));
			break;
		case "title":
			model.addAttribute("notes", noteService.findByTitle(search, sectionId));
			break;
		case "link":
			model.addAttribute("notes", noteService.findByLink(search, sectionId));
			break;
		case "remark":
			model.addAttribute("notes", noteService.findByRemark(search, sectionId));
			break;

		}
		return "note/note_ajax";
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String Note(Model model, @RequestParam("sort") String sort, @RequestParam("order") String order) {

		boolean trueFalse = false;

		if ("asc".equals(order)) {
			trueFalse = true;
		}

		switch (sort) {
		case "title":
			model.addAttribute("notes", noteService.findAllByTitle(trueFalse));
			break;
		case "mdate":
			model.addAttribute("notes", noteService.findAllByModifiedDate(trueFalse));
			break;
		case "cdate":
			model.addAttribute("notes", noteService.findAllByCreatedDate(trueFalse));
			break;
		default:
			model.addAttribute("notes", noteService.findAll());
		}
		return "note/note_ajax";
	}

	// DELETE -- POST -- WORKING
	@RequestMapping(value = "/delete/{Id}", method = RequestMethod.POST)
	public String Delete2(Model model, @PathVariable("Id") Long id) {

		if (noteService.findById(id) != null) {
			noteService.delete(id);
		}

		// After delete Fetch data
		model.addAttribute("notes", noteService.findAll());
		return "note/note_ajax";
	}

	// UPDATE LOAD -- WORKING
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, Model model) {
		Note n = noteService.findById(id);
		
		model.addAttribute("newNote", n);
		model.addAttribute("id", n.getNoteId());
		return "note/note_add";
	}

	// UPDATE SAVE -- WORKING
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String editNote(@ModelAttribute("newNote") Note n, @PathVariable("id") Long id) {
		n.setNoteId(id);

		// Giving some error
		// Calendar calendar = Calendar.getInstance();
		// n.setModifiedDate(new
		// java.sql.Timestamp(calendar.getTime().getTime())); // change modified
		// date

		noteService.save(n);
		return "redirect:/note";
	}

	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) {
	 * SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 * dateFormat.setLenient(false); binder.registerCustomEditor(Date.class, new
	 * CustomDateEditor(dateFormat, true)); }
	 */
}
