package edu.mum.cs544.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.dao.UserDao;
import edu.mum.cs544.domain.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User findOne(Long id) {
		return userDao.findOne(id);
	}

	public Long save(User user) {
		return userDao.save(user).getUserId();
	}

}
