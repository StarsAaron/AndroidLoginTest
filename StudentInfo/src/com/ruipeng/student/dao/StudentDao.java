package com.ruipeng.student.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ruipeng.student.bean.Student;
import com.ruipeng.student.util.ConnectionManager;

public interface StudentDao {
	
	/**
	 * @description 查询
	 */
	List<Student> selectAll();
	
	/**
	 * @description 根据ID查询
	 */
	Student selectById(String id);
	
	/**
	 * @description 插入
	 */
	void insert(Student stu);
	
	/**
	 * @description 修改
	 */
	void update(Student stu);
	
	/**
	 * @description 删除
	 */
	void deleteById(String id);
}
