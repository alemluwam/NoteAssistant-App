package edu.mum.cs544.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs544.domain.Tag;
@Repository
public interface TagDao extends JpaRepository<Tag, Long>{

}
