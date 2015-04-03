package com.ruipeng.student.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ruipeng.student.bean.Student;
import com.ruipeng.student.bean.User;
import com.ruipeng.student.util.DaoUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public String login(User user) {
		String u_name = user.getName();
		String u_password = user.getPassword();
		User my = null;
		
		String SQL = "select * from user where name=? and password=?";
		QueryRunner queryRunner = new QueryRunner(DaoUtils.getSource());
		try {
			my = queryRunner.query(SQL, new BeanHandler<User>(User.class),u_name,u_password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(my!=null){
			return "success";
		}else{
			return "failed";
		}
		
	}

	@Override
	public String regist(User user) {
		// TODO Auto-generated method stub
		String u_name = user.getName();
		String u_password = user.getPassword();
		User my = null;
		
		String SQL = "select * from user where name=?";
		String SQL2 = "insert into user values(null,?,?)";
		QueryRunner queryRunner = new QueryRunner(DaoUtils.getSource());
		try {
			my = queryRunner.query(SQL, new BeanHandler<User>(User.class),u_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(my == null){
			try {
				queryRunner.update(SQL2,u_name,u_password);
				return "success";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "failed";
			}
		}else{
			return "exited";
		}
		
	}

}
