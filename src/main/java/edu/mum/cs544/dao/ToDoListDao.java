package edu.mum.cs544.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.domain.Note;
import edu.mum.cs544.domain.ToDoList;

@Repository
public interface ToDoListDao extends JpaRepository<ToDoList, Long> {

	List<ToDoList> findByTitle(String title);

	List<ToDoList> findByDescription(String description);

	List<Note> findAllByOrderByCreatedDateAsc(Date createdDate);

	List<Note> findAllByOrderByCreatedDateDesc(Date createdDate);

	List<Note> findAllByOrderByModifiedDateAsc(Date modifiedDate);

	List<Note> findAllByOrderByModifiedDateDesc(Date modifiedDate);

	List<Note> findAllByOrderByTitleAsc(String title);

}
