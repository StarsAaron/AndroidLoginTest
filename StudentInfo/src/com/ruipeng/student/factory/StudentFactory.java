package com.ruipeng.student.factory;

import java.io.FileReader;
import java.util.Properties;

public class StudentFactory {
	private static StudentFactory studentFactory = new StudentFactory();
	private static Properties prop = null;

	static{
		try {
			prop = new Properties();
			prop.load(new FileReader(StudentFactory.class.getClassLoader().getResource("Db_infor.properties").getPath()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private StudentFactory() {
	}

	public static StudentFactory getStudentFactory() {
		return studentFactory;
	}

	public <T> T getInstance(Class<T> name) {
		String inteClassName = name.getSimpleName();
		String supClassName = prop.getProperty(inteClassName);
		try {
			return (T)Class.forName(supClassName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}

}
