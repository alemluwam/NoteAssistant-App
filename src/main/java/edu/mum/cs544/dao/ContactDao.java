package edu.mum.cs544.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import edu.mum.cs544.domain.Contact;

@Repository
public interface ContactDao extends JpaRepository<Contact, Long> {
	
	
	// For Searching
	@Query("SELECT c FROM Contact c WHERE c.contactName like ?1% ORDER BY c.contactName")
	List<Contact> findByContactname2(String contactName);
	
	// List<Contact> findByFirstnameLike(String contactName);
	@Query("SELECT c FROM Contact c WHERE c.email like ?1% ORDER BY c.email")
	List<Contact> findByEmailLike(String email);
	
	@Query("SELECT c FROM Contact c WHERE c.homePhone like ?1% or c.mobile like ?2% ORDER BY c.contactName")
	List<Contact> findByPhoneLike(String phone1, String phone2);
	
	@Query("SELECT c FROM Contact c WHERE c.address like %?1% ORDER BY c.address")
	List<Contact> findByAddressLike(String address);

	
	// For Sorting Part
	List<Contact> findAllByOrderByContactIdAsc();

	List<Contact> findAllByOrderByContactIdDesc();

	List<Contact> findAllByOrderByContactNameAsc();

	List<Contact> findAllByOrderByContactNameDesc();

	List<Contact> findAllByOrderByAddressAsc();

	List<Contact> findAllByOrderByAddressDesc();

	List<Contact> findAllByOrderByEmailAsc();

	List<Contact> findAllByOrderByEmailDesc();

	List<Contact> findAllByOrderByMobileAsc();

	List<Contact> findAllByOrderByMobileDesc();

}
