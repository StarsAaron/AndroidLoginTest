package com.ruipeng.student.service;

import com.ruipeng.student.bean.User;
import com.ruipeng.student.dao.UserDao;
import com.ruipeng.student.factory.StudentFactory;

public class UserServiceImpl implements UserService {

	@Override
	public String login(User user) {
		UserDao userDao = StudentFactory.getStudentFactory().getInstance(UserDao.class);
		return userDao.login(user);
	}

	@Override
	public String regist(User user) {
		UserDao userDao = StudentFactory.getStudentFactory().getInstance(UserDao.class);
		return userDao.regist(user);
	}

}
