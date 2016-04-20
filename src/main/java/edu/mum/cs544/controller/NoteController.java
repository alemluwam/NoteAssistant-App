package edu.mum.cs544.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.cs544.domain.Note;
import edu.mum.cs544.domain.Section;
import edu.mum.cs544.service.NoteService;

@Controller
@RequestMapping("/note")
public class NoteController {

	@Autowired
	private NoteService noteService;

	@RequestMapping(method = RequestMethod.GET)
	public String Note(Model model) {

		model.addAttribute("notes", noteService.findAll());
		return "note/note";
	}

	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public String NoteFind(Model model, @RequestParam("search") String search, @RequestParam("searchby") String searchby, @RequestParam("section") Long sectionId) {
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

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addNote(Model model) {
		model.addAttribute("newNote", new Note());
		return "note/note_add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String createNote(@ModelAttribute("newNote") Note note) {

		/* under test */
		Section newSection = new Section();
		
		newSection.setSectionId(1L);
		newSection.setSectionName("Section A");
		note.setSection(newSection);
		
		/* temporary solution */

		noteService.save(note);
		return "redirect:/note";
	}

	// UPDATE Load -----
	@RequestMapping(value = "/{noteId}", method = RequestMethod.GET)
	public String editNote(@PathVariable("noteId") Long id, Model model) {
		model.addAttribute("newNote", noteService.findById(id));
		return "note/note_add";
	}

	// UPDATE Save -----
	@RequestMapping(value = "/{noteId}", method = RequestMethod.POST)
	public String updateNote(@ModelAttribute("newNote") Note note) {
		noteService.save(note);
		return "redirect:/note";
	}

	// DELETE -----
	@RequestMapping(value = "/delete/{Id}", method = RequestMethod.POST)
	public String Delete(Model model, @PathVariable("Id") Long id) {

		if (noteService.findById(id) != null) {
			noteService.delete(id);
		}

		// After delete Fetch data
		model.addAttribute("notes", noteService.findAll());
		return "note/note_ajax";
	}

	public NoteService getNoteService() {
		return noteService;
	}

	public void setNoteService(NoteService noteService) {
		this.noteService = noteService;
	}
}
