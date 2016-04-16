package edu.mum.cs544.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.mum.cs544.domain.Contact;

@Repository
public interface ContactDao extends JpaRepository<Contact, Long>{

	List<Contact> findByContactName(String contactName);

	List<Contact> findByEmail(String email);

	List<Contact> findByHomePhone(String homePhone);

	List<Contact> findByAddress(String address);

	List<Contact> findByMobile(String mobile);

	List<Contact> findAllByOrderByContactNameAsc(String contactName);

	List<Contact> findAllByOrderByContactNameDesc(String contactName);

	List<Contact> findAllByOrderByAddressAsc(String address);

	List<Contact> findAllByOrderByAddressDesc(String address);

	List<Contact> findAllByOrderByEmailAsc(String email);

	List<Contact> findAllByOrderByEmailDesc(String email);

	
}
