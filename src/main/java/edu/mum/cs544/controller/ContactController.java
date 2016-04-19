package edu.mum.cs544.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.cs544.domain.Contact;
import edu.mum.cs544.domain.User;
import edu.mum.cs544.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping(method = RequestMethod.GET)
	public String Contact(Model model) {

		model.addAttribute("contacts", contactService.findAll());
		return "contact/contact";
	}
	
	@RequestMapping(value="/find", method = RequestMethod.POST)
	public String ContactFind(Model model, @RequestParam("search") String search, @RequestParam("searchby") String searchby) {
		switch(searchby) {
		case "name":
			model.addAttribute("contacts", contactService.findByContactName(search));
			break;
		case "email":
			model.addAttribute("contacts", contactService.findByEmail(search));
			break;
		case "address":
			model.addAttribute("contacts", contactService.findByAddress(search));
			break;			
		case "phone":
			model.addAttribute("contacts", contactService.findByPhone(search));
			break;
		
		}
		return "contact/contact_find_ajax";
	}
	
	@RequestMapping(value="/list", method = RequestMethod.POST)
	public String Contact(Model model, @RequestParam("sort") String sort, @RequestParam("order") String order) {
		
		
			if("asc".equals(order)) {
				switch(sort) {
				case "id":
					model.addAttribute("contacts", contactService.findAllByContactId(true));
					break;
				case "name":
					model.addAttribute("contacts", contactService.findAllByName(true));
					break;
				case "address":
					model.addAttribute("contacts", contactService.findAllByAddress(true));
					break;
				case "mobile":
					model.addAttribute("contacts", contactService.findAllByMobile(true));
					break;
				case "email":
					model.addAttribute("contacts", contactService.findAllByEmail(true));
					break;
				default:
					model.addAttribute("contacts", contactService.findAll());
				}
			} else {
				switch(sort) {
				case "id":
					model.addAttribute("contacts", contactService.findAllByContactId(false));
					break;
				case "name":
					model.addAttribute("contacts", contactService.findAllByName(false));
					break;
				case "address":
					model.addAttribute("contacts", contactService.findAllByAddress(false));
					break;
				case "mobile":
					model.addAttribute("contacts", contactService.findAllByMobile(false));
					break;
				case "email":
					model.addAttribute("contacts", contactService.findAllByEmail(false));
					break;
				default:
					model.addAttribute("contacts", contactService.findAll());
				}
			}
			return "contact/contact_ajax";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addContact(Model model) {
		model.addAttribute("newContact", new Contact());
		return "contact/contact_add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String createContact(@ModelAttribute("newContact") Contact contact) {

		/* under test */
		User newUser = new User();
		newUser.setUserId(1L);
		newUser.setUserName("Siken");
		newUser.setPassword("test");
		contact.setUser(newUser);
		/* temporary solution */
		

		contactService.save(contact);
		return "redirect:/contact";
	}
	
	// UPDATE Load -----
	@RequestMapping(value="/{contactId}", method=RequestMethod.GET)
	public String editContact(@PathVariable("contactId") Long id, Model model){
		model.addAttribute("newContact", contactService.findById(id));
		return "contact/contact_add";
	}
	
	// UPDATE Save -----
	@RequestMapping(value="/{contactId}", method=RequestMethod.POST)
	public String updateContact(@ModelAttribute("newContact") Contact contact){
		contactService.save(contact);
		return "redirect:/contact";
	}
	
	
	// DELETE -----
	@RequestMapping(value="/delete/{Id}", method=RequestMethod.POST)
	public String Delete(Model model, @PathVariable("Id") Long id){
		
		if(contactService.findById(id) != null){
			contactService.delete(id);
		}
		
		// After delete Fetch data
		model.addAttribute("contacts", contactService.findAll());
		return "contact/contact_ajax";
	}
	
	
	public ContactService getContactService() {
		return contactService;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
}
