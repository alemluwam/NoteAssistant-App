package edu.mum.cs544.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.mum.cs544.dao.ContactDao;
import edu.mum.cs544.domain.Contact;


@Service
public class ContactService2 {
	
	/*
	@Autowired
	private ContactDao contactDao;

	// Search
	
	public List<Contact> findByContactName(String contactName) {
		return contactDao.findByContactName(contactName);
	}

	public List<Contact> findByEmail(String email) {
		return contactDao.findByEmail(email);
	}

	public List<Contact> findByHomePhone(String homePhone) {
		return contactDao.findByHomePhone(homePhone);
	}

	public List<Contact> findByAddress(String address) {
		return contactDao.findByAddress(address);
	}

	public List<Contact> findByMobile(String mobile) {
		return contactDao.findByMobile(mobile);
	}

	// Sort

	public List<Contact> SortByContactNameAsc(String contactName) {
		return contactDao.findAllByOrderByContactNameAsc(contactName);
	}

	public List<Contact> SortByContactNameDesc(String contactName) {
		return contactDao.findAllByOrderByContactNameDesc(contactName);
	}

	public List<Contact> SortByAddressAsc(String address) {
		return contactDao.findAllByOrderByAddressAsc(address);
	}

	public List<Contact> SortByAddressDesc(String address) {
		return contactDao.findAllByOrderByAddressDesc(address);
	}

	public List<Contact> SortByEmailAsc(String email) {
		return contactDao.findAllByOrderByEmailAsc(email);
	}

	public List<Contact> SortByEmailDesc(String email) {
		return contactDao.findAllByOrderByEmailDesc(email);
	}

	public ContactDao getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	*/
	
}
