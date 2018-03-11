package com.hrmsys.test.service;

import com.hrmsys.model.Department;

public interface UserService {

	
	/**
	 * 查询所有
	 * @param type
	 * @return
	 */
	public String getAll(String start, String limit);
	/**
	* 方法名：
	* 描     述：保存
	* 参数: dept
	* 创建人：sux
	* 创建时间:2011-2-18
	* @return msg
	 */
	public String save(Department dept);
	/**
	 * 删除
	 * @param ids 编号序列
	 * @return
	 */
	public String delete(Class clazz,String ids);
	/**
	 * 按条件查询
	 * @param condition
	 * @param conditionValue
	 * @return json
	 */
	public String getDeptByCondition(String condition, String conditionValue, String start, String limit);
	/**
	 * 按id查询
	 * @param deptId
	 * @return
	 */
	public String listById(String deptId);
	/**
	 * 查询数据转为FusionChart所需的XML格式 
	 * @return
	 */
	public String getReportDate();
	public String getAll();

}
