package edu.mum.cs544.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.domain.Section;

@Repository
public interface SectionDao extends JpaRepository<Section, Long> {

}
