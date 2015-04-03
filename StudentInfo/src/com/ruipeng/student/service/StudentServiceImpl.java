package com.ruipeng.student.service;

import java.util.List;

import com.ruipeng.student.bean.Student;
import com.ruipeng.student.dao.StudentDao;
import com.ruipeng.student.factory.StudentFactory;

public class StudentServiceImpl implements StudentService {
	StudentDao studentDao = StudentFactory.getStudentFactory().getInstance(StudentDao.class);
		
	@Override
	public List<Student> selectAll() {
		// TODO Auto-generated method stub
		return studentDao.selectAll();
	}

	@Override
	public Student selectById(String str) {
		// TODO Auto-generated method stub
		return studentDao.selectById(str);
	}

	@Override
	public void insert(Student stu) {
		// TODO Auto-generated method stub
		studentDao.insert(stu);
	}

	@Override
	public void update(Student stu) {
		// TODO Auto-generated method stub
		studentDao.update(stu);
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		studentDao.deleteById(id);
	}

}
