package com.hrmsys.test.service;

import com.hrmsys.dao.impl.BaseDAO;
import com.hrmsys.test.dao.SuperBaseDaoImpl;

/*
 * 抽象类，实现了基础service接口。
 * 其他具体 的service类去继承它，并传入泛型参数，
 */
 
public abstract class AbstrctBaseService<T> implements IBaseService<T>{

	private SuperBaseDaoImpl superBaseDaoImpl;
	
	@Override
	public String Save(T o) {
		// TODO Auto-generated method stub
		superBaseDaoImpl.add(o);
		return "";
	}

	@Override
	public String delete(Class clazz, String ids) {
		// TODO Auto-generated method stub
		return null;
	}

}
