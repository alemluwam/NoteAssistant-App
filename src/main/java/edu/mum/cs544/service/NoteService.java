package edu.mum.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.dao.NoteDao;
import edu.mum.cs544.domain.Note;

@Service
public class NoteService {

	@Autowired
	private NoteDao noteDao;

	/* All Notes */
	public List<Note> findAll() {
		return noteDao.findAllByOrderByModifiedDateDesc();
	}

	/* All Notes | Sorted by CreatedDate */
	public List<Note> findAllByCreatedDate(boolean sort) {
		if (sort) {
			return noteDao.findAllByOrderByCreatedDateAsc();
		} else {
			return noteDao.findAllByOrderByCreatedDateDesc();
		}
	}

	/* All Notes | Sorted by ModifiedDate */
	public List<Note> findAllByModifiedDate(boolean sort) {
		if (sort) {
			return noteDao.findAllByOrderByModifiedDateAsc();
		} else {
			return noteDao.findAllByOrderByModifiedDateDesc();
		}
	}

	/* All Notes | Sorted by Title */
	public List<Note> findAllByTitle(boolean sort) {
		if (sort) {
			return noteDao.findAllByOrderByTitleAsc();
		} else {
			return noteDao.findAllByOrderByTitleDesc();
		}
	}

	/* Find Note by Title */
	public List<Note> findByTitle(String title, Long sectionId) {
		return noteDao.findByTitle(title, sectionId);
	}

	/* Find Note by Content */
	public List<Note> findByContent(String content, Long sectionId) {
		return noteDao.findByContent(content, sectionId);
	}

	/* Find Note by Link */
	public List<Note> findByLink(String link, Long sectionId) {
		return noteDao.findByLink(link, sectionId);
	}

	/* Find Note by Remark */
	public List<Note> findByRemark(String remark, Long sectionId) {
		return noteDao.findByRemark(remark, sectionId);
	}
	
	public Note findById(Long id) {
		return noteDao.findOne(id);
	}

	public void delete(Long id) {
		noteDao.delete(id);
	}
	
	/* SAVE */
	public Long save(Note note) {
		return noteDao.save(note).getNoteId();
	}

}
