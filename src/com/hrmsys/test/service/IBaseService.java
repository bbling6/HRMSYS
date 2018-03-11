package com.hrmsys.test.service;


public interface IBaseService<T> {
	
	 String delete(Class<T> clazz, String ids);
	 
	 String Save(T o);
	 
	 
}
