package com.hrmsys.test.dao;

import com.hrmsys.model.Department;

/**
 * 一个testDao。
 * */

public class TestDaoImpl implements TestDao{

	public SuperBaseDaoImpl superBaseDaoImpl;
	
	public void setSuperBaseDaoImpl(SuperBaseDaoImpl superBaseDaoImpl) {
		this.superBaseDaoImpl = superBaseDaoImpl;
	}

	@Override
	public boolean delete(Class clazz,String ids) {
		// TODO Auto-generated method stub
		try{
			String[] deptIds = ids.split(",");
		
			for(int i=0;i<deptIds.length;i++){
				superBaseDaoImpl.delById(clazz, deptIds[i]);
				
			}
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public String getAll(String start, String limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Department dept) {
		// TODO Auto-generated method stub
		
		try{
			superBaseDaoImpl.add(dept);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
		
	}

}
