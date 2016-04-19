package edu.mum.cs544.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.domain.Note;

@Repository
public interface NoteDao extends JpaRepository<Note, Long> {

	List<Note> findByTitle(String title);

	List<Note> findByContent(String content);

	List<Note> findByLink(String link);

	List<Note> findAllByOrderByCreatedDateAsc(Date createdDate);

	List<Note> findAllByOrderByCreatedDateDesc(Date createdDate);

	List<Note> findAllByOrderByModifiedDateAsc(Date modifiedDate);

	List<Note> findAllByOrderByModifiedDateDesc(Date modifiedDate);

	List<Note> findAllByOrderByTitleAsc(String title);

}
