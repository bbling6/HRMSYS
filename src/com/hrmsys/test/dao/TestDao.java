package com.hrmsys.test.dao;

import com.hrmsys.model.Department;

public interface TestDao {
	
	public boolean save(Department dept);
	
	public boolean delete(Class clazz,String ids);
	
	public String getAll(String start, String limit);

}
