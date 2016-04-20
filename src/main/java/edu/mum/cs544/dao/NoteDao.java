package edu.mum.cs544.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.domain.Note;

@Repository
public interface NoteDao extends JpaRepository<Note, Long> {

	// For Searching
	/* giving some problems 
	@Query("SELECT n FROM Note n WHERE n.section.sectionId = ?2 and n.title LIKE CONCAT(?1, '%') ORDER BY n.title")
	List<Note> findByTitle(String title, Long sectionid);

	@Query("SELECT n FROM Note n WHERE n.section.sectionId = ?2 and n.content LIKE CONCAT('%', ?1, '%') ORDER BY n.createdDate")
	List<Note> findByContent(String content, Long sectionid);

	@Query("SELECT n FROM Note n WHERE n.section.sectionId = ?2 and n.link LIKE CONCAT('%', ?1, '%') ORDER BY n.createdDate")
	List<Note> findByLink(String link, Long sectionid);

	@Query("SELECT n FROM Note n WHERE n.section.sectionId = ?2 and n.remark LIKE CONCAT('%', ?1, '%') ORDER BY n.createdDate")
	List<Note> findByRemark(String remark, Long sectionid);
	*/
	
	//select a from Author as a join a.Book as ab where ab.AuthorId like '%"hello"%';
	
	@Query("SELECT n FROM Note n WHERE n.section.sectionId = ?2 and n.title LIKE ?1% ORDER BY n.title")
	List<Note> findByTitle(String title, Long sectionId);

	@Query("SELECT n FROM Note n WHERE n.section.sectionId = ?2 and n.content LIKE %?1% ORDER BY n.createdDate")
	List<Note> findByContent(String content, Long sectionId);

	@Query("SELECT n FROM Note n WHERE n.section.sectionId = ?2 and n.link LIKE CONCAT('%', ?1, '%') ORDER BY n.createdDate")
	List<Note> findByLink(String link, Long sectionId);

	@Query("SELECT n FROM Note n WHERE n.section.sectionId = ?2 and n.remark LIKE CONCAT('%', ?1, '%') ORDER BY n.createdDate")
	List<Note> findByRemark(String remark, Long sectionId);

	
	// For Sorting Part
	List<Note> findAllByOrderByCreatedDateAsc();
	List<Note> findAllByOrderByCreatedDateDesc();

	List<Note> findAllByOrderByModifiedDateAsc();
	List<Note> findAllByOrderByModifiedDateDesc();

	List<Note> findAllByOrderByTitleAsc();
	List<Note> findAllByOrderByTitleDesc();

}
