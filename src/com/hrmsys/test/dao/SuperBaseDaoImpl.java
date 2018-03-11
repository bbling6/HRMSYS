package com.hrmsys.test.dao;

	import java.io.Serializable;
	import java.util.List;

	import javax.annotation.Resource;


	import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
	import org.hibernate.Query;
import org.hibernate.Session;
	import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

/*
 * 这是基础DAO类，其他Dao的继承它或引用它。
 * */

public class SuperBaseDaoImpl  {
	   
		
	    private SessionFactory sessionFactory;

		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		
	    public Session getMySession() {  
	        return this.sessionFactory.openSession(); 
	    } 
		
		//保存对象
		public void add(Object obj) {
			System.out.println(".......");
			Session session = null; 
	        Transaction tx = null;
	        try{
	            session = this.getMySession();
	            tx = session.beginTransaction();
	            session.save(obj);
	            tx.commit();
	        }catch(Exception ex){
	        	
	            System.out.println("保存对象出现错误！");
	            ex.printStackTrace();
	            if(tx != null){
	                tx.rollback();
	            }
	        }finally{
	            if(session != null){
	                session.close();
	            }
	        }
			
		}

		//统一查询
		public List excuteQuery(String hql, Object[] parameters) {
			
			Query query=(Query) this.sessionFactory.getCurrentSession().createQuery(hql);
			
			//注入？值
			if(parameters!=null && parameters.length>0){
				for(int i=0;i<parameters.length;i++){
					query.setParameter(i, parameters[i]);
				}
			}
			System.out.println("list 里面的是"+query.list().size());
			return query.list();
		}

		//分页
		public List excuteQueryByPage(String hql, Object[] parameters, int pageNow,
				int PageSize) {
			Query query=(Query) this.sessionFactory.getCurrentSession().createQuery(hql);
			
			//注入？值
			if(parameters!=null && parameters.length>0){
				for(int i=0;i<parameters.length;i++){
					query.setParameter(i, parameters[i]);
				}
			}
			
			//体现出分页的不同
			return query.setFirstResult((pageNow-1)*PageSize).setMaxResults(PageSize).list();
		
		}

		//统一的删除，修改等操作
		public List excuteUpdate(String hql, Object[] parameters) {
			// TODO Auto-generated method stub
			return null;
		}

		
		//查找对象
		public Object findById(Class clazz, Serializable id) {
			// TODO Auto-generated method stub
			
			return this.sessionFactory.getCurrentSession().get(clazz, id);
		}
		
		//查找出唯一的对象
		public Object uniqueQuery(String hql, Object[] parameters) {
			
			Query query=(Query) this.sessionFactory.getCurrentSession().createQuery(hql);
			
			//注入？值
			if(parameters!=null && parameters.length>0){
				for(int i=0;i<parameters.length;i++){
					query.setParameter(i, parameters[i]);
				}
			}
			return query.uniqueResult();
		}

		//返回总行数
		public int queryRowCount(String hql, Object[] parameters) {
			
			Object obj=this.uniqueQuery(hql, parameters);
			int RowCount=Integer.parseInt(obj.toString());
			
			return RowCount;
		}
		
		//删除一个对象
		public void delById(Class clazz, Serializable id) {
			// TODO Auto-generated method stub

			 this.sessionFactory.getCurrentSession().delete(this.findById(clazz, id));
		}
		
		public void update(Object object) {
			
			this.sessionFactory.getCurrentSession().update(object);
			
		}
	}


