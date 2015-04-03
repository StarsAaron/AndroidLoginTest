package com.ruipeng.student.dao;

import com.ruipeng.student.bean.User;

public interface UserDao {

	/**
	 * @用户登录
	 */
	String login(User user);
	/**
	 * @用户注册
	 */
	String regist(User user);
}
