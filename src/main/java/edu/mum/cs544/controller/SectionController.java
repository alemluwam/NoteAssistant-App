package edu.mum.cs544.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs544.domain.Section;
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

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addSection(Model model) {
		model.addAttribute("newSection", new Section());
		return "section/section_add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String createSection(@ModelAttribute("newSection") Section section) {

		/* Saving user of id 1 */
		User newUser = new User();
		newUser.setUserId(1L);
		newUser.setUserName("Siken");
		section.setUser(newUser);

		sectionService.save(section);
		return "redirect:/section";
	}

	// UPDATE Load -----
	@RequestMapping(value = "/{sectionId}", method = RequestMethod.GET)
	public String editSection(@PathVariable("sectionId") Long id, Model model) {
		model.addAttribute("newSection", sectionService.findOne(id));
		return "section/section_add";
	}

	// UPDATE Save -----
	@RequestMapping(value = "/{sectionId}", method = RequestMethod.POST)
	public String updateSection(@ModelAttribute("newSection") Section section) {
		sectionService.save(section);
		return "redirect:/section";
	}

	public SectionService getSectionService() {
		return sectionService;
	}

	public void setSectionService(SectionService sectionService) {
		this.sectionService = sectionService;
	}

}
