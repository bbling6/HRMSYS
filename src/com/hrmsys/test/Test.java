package com.hrmsys.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrmsys.model.Department;
import com.hrmsys.test.service.TestService;

public class Test {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		TestService test = (TestService) context.getBean("TestService");
		
		Department dept = new Department("水火部","09","大王","");
		
//		test.save(dept);
		test.delete(Department.class, "08");
	}

}
