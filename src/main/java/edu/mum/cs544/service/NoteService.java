package edu.mum.cs544.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.mum.cs544.dao.NoteDao;
import edu.mum.cs544.domain.Note;

@Service
public class NoteService {
	@Autowired
	private NoteDao noteDao;
	
	// Search
	public List<Note> findByTitle(String title){
		return noteDao.findByTitle(title);
		
	}
	
	public List<Note> findByContent(String content){
		return noteDao.findByContent(content);
		
	}
	public List<Note> getByLink(String link){
		return noteDao.findByLink(link);
		}
	
	//Sort
	
	public List<Note> SortByCreatedDateAsc(Date createdDate){
		return noteDao.findAllByOrderByCreatedDateAsc(createdDate);						 
	}
	public List<Note> SortByCreatedDateDesc(Date createdDate){
		return noteDao.findAllByOrderByCreatedDateDesc(createdDate);						 
	}
	public List<Note> SortByModifiedDateAsc(Date modifiedDate){
		return noteDao.findAllByOrderByModifiedDateAsc(modifiedDate);						 
	}
	public List<Note> SortByModifiedDateDesc(Date modifiedDate){
		return noteDao.findAllByOrderByModifiedDateDesc(modifiedDate);
	}
	public List<Note> sortByTitleAsc(String title){
			return noteDao.findAllByOrderByTitleAsc(title);						 
	}
	
}
