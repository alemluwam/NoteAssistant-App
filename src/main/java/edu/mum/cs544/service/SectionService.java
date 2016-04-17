package edu.mum.cs544.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.dao.SectionDao;
import edu.mum.cs544.domain.Section;
@Service
public class SectionService {
@Autowired
private SectionDao sectionDao;
	public void saveSection(Section s) {
		sectionDao.save(s);
		
	}

}
