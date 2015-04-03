package com.ruipeng.student.service;

import java.util.List;

import com.ruipeng.student.bean.Student;

public interface StudentService {
	/**
	 * @description 查询
	 * @return List<Student>
	 */
	List<Student> selectAll();
	
	/**
	 * @description 根据ID查询
	 * @return Student
	 */
	Student selectById(String str);
	
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
	/**
	 * @description 关闭资源
	 */
}
