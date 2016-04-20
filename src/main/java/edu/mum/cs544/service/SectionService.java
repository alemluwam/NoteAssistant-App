package edu.mum.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.dao.SectionDao;
import edu.mum.cs544.domain.Section;
import edu.mum.cs544.domain.User;

@Service
public class SectionService {
	
	@Autowired
	private SectionDao sectionDao;
	
	@Autowired
	private UserService userService;

	public void saveSection(Section s) {
		sectionDao.save(s);

	}

	public List<Section> findAll() {
		return sectionDao.findAll();
	}

	public List<Section> findByUserId(Long id) {
		User user = userService.findOne(id);
		return sectionDao.findByUser(user);
	}
	
	public Section findBySectionName(String sectionName){
		return sectionDao.findBySectionName(sectionName);
	}

	public Section findOne(Long id) {
		return sectionDao.findOne(id);
	}

}
