package com.ruipeng.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.ruipeng.student.bean.Student;
import com.ruipeng.student.util.DaoUtils;

public class StudentDaoImpl implements StudentDao{
	@Override
	public List<Student> selectAll(){
		String sql = "SELECT * FROM student_info";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			List<Student> list = runner.query(sql, new BeanListHandler<Student>(Student.class));
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public Student selectById(String id) {
		String sql = "SELECT * FROM student_info WHERE id=?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanHandler<Student>(Student.class),id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void insert(Student stu) {
		String sql = "INSERT INTO student_info values(null,?,?,?)";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,stu.getName(),stu.getGender(),stu.getAge());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void update(Student stu) {
		String sql = "UPDATE student_info set name=?,gender=?,age=? where id=?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,stu.getName(),stu.getGender(),stu.getAge(),stu.getId());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void deleteById(String id) {
		String sql = "Delete from student_info WHERE id=?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			runner.update(sql,id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
//	public static void main(String[] args) {
//		new StudentDaoImpl().selectAll();
//		
//	}

}
