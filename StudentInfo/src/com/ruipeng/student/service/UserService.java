package com.ruipeng.student.service;

import com.ruipeng.student.bean.User;

public interface UserService {
	/**
	 * @用户登录
	 */
	String login(User user);
	/**
	 * @用户注册
	 */
	String regist(User user);
}
