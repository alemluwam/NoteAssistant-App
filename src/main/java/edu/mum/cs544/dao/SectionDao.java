package edu.mum.cs544.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.domain.Section;
import edu.mum.cs544.domain.User;

@Repository
public interface SectionDao extends JpaRepository<Section, Long> {

	List<Section> findByUser(User user);

	Section findBySectionName(String sectionName);

}
