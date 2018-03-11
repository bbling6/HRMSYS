package com.hrmsys.interceptor;

import java.util.Map;

import com.hrmsys.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Authority extends AbstractInterceptor{

	/**
	 * 拦截器-  没应用
	 */
	private static final long serialVersionUID = -6763613601007449517L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();  //获取session
		User user = (User) session.get("user");
		
		System.out.println("走过拦截器。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
		if(null != user){
			return invocation.invoke(); //继续执行后面的操作
		}
		return "login";//跳转到登录界面
	}

}
