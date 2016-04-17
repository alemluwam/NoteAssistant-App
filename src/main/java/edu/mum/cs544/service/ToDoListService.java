package edu.mum.cs544.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.dao.ToDoListDao;
import edu.mum.cs544.domain.Note;
import edu.mum.cs544.domain.ToDoList;

@Service
public class ToDoListService {
	
	@Autowired
	private ToDoListDao toDoListDao;
	
	//Search
	public List <ToDoList> findByTitle(String title){
		return toDoListDao.findByTitle(title);
	}
	
	public List <ToDoList> findByDescription(String description){
		return toDoListDao.findByDescription(description);
	}
	
	//Sort
	
		public List<Note> SortByCreatedDateAsc(Date createdDate){
			return toDoListDao.findAllByOrderByCreatedDateAsc(createdDate);						 
		}
		public List<Note> SortByCreatedDateDesc(Date createdDate){
			return toDoListDao.findAllByOrderByCreatedDateDesc(createdDate);						 
		}
		public List<Note> SortByModifiedDateAsc(Date modifiedDate){
			return toDoListDao.findAllByOrderByModifiedDateAsc(modifiedDate);						 
		}
		public List<Note> SortByModifiedDateDesc(Date modifiedDate){
			return toDoListDao.findAllByOrderByModifiedDateDesc(modifiedDate);
		}
		public List<Note> sortByTitleAsc(String title){
				return toDoListDao.findAllByOrderByTitleAsc(title);						 
		}

		public Long save(ToDoList toDoList) {
			return toDoListDao.save(toDoList).getToDoListId();
			
		}

		public List<ToDoList> findAll() {
			return toDoListDao.findAll();
		}

		public ToDoList findById(Long id) {
			return toDoListDao.findOne(id);
		}

		public void delete(Long id) {
			toDoListDao.delete(id);
		}

}
