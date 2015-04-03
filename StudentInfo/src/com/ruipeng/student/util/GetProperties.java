package com.ruipeng.student.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GetProperties {
	private Properties properties ;
	private FileInputStream fileInputStream ;
	
	public GetProperties(){
		try {
			properties = new Properties();
			properties.load(new FileReader(GetProperties.class.getClassLoader().getResource("Db_infor.properties").getPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getconfig(String key){
		if(properties.contains(key)){
			String value = properties.getProperty(key);
			return value;
		}else{
			System.out.print("key为空！！！");
			return null;
		}
	}
}
