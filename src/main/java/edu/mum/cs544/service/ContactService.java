package edu.mum.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.dao.ContactDao;
import edu.mum.cs544.domain.Contact;

@Service
public class ContactService {

	@Autowired
	private ContactDao contactDao;

	/* All Contacts */
	public List<Contact> findAll() {
		return contactDao.findAll();
	}

	/* All Contacts | Sorted by ID */
	public List<Contact> findAllByContactId(boolean sort) {
		if (sort) {
			return contactDao.findAllByOrderByContactIdAsc();
		} else {
			return contactDao.findAllByOrderByContactIdDesc();
		}
	}

	/* All Contacts | Sorted by Name */
	public List<Contact> findAllByName(boolean sort) {
		if (sort) {
			return contactDao.findAllByOrderByContactNameAsc();
		} else {
			return contactDao.findAllByOrderByContactNameDesc();
		}
	}

	/* All Contacts | Sorted by Address */
	public List<Contact> findAllByAddress(boolean sort) {
		if (sort) {
			return contactDao.findAllByOrderByAddressAsc();
		} else {
			return contactDao.findAllByOrderByAddressDesc();
		}
	}

	/* All Contacts | Sorted by Mobile */
	public List<Contact> findAllByMobile(boolean sort) {
		if (sort) {
			return contactDao.findAllByOrderByMobileAsc();
		} else {
			return contactDao.findAllByOrderByMobileDesc();
		}
	}

	/* All Contacts | Sorted by Email */
	public List<Contact> findAllByEmail(boolean sort) {
		if (sort) {
			return contactDao.findAllByOrderByEmailAsc();
		} else {
			return contactDao.findAllByOrderByEmailDesc();
		}
	}

	/* Find Contact by Name */
	public List<Contact> findByContactName(String contactName) {
		return contactDao.findByContactname2(contactName);
	}

	/* Find Contact by Email */
	public List<Contact> findByEmail(String email) {
		return contactDao.findByEmailLike(email);
	}

	/* Find Contact by HomePhone */
	public List<Contact> findByPhone(String phone) {
		return contactDao.findByPhoneLike(phone, phone);
	}

	/* Find Contact by Address */
	public List<Contact> findByAddress(String address) {
		return contactDao.findByAddressLike(address);
	}
	
	public Contact findById(Long id) {
		return contactDao.findOne(id);
	}

	public void delete(Long id) {
		contactDao.delete(id);
	}
	
	/* SAVE */
	public Long save(Contact contact) {
		return contactDao.save(contact).getContactId();
	}
}
