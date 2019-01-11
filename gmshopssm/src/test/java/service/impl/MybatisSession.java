package service.impl;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSession {
	
	 static SqlSessionFactory sf=null;
	 static ThreadLocal<SqlSession> threadLocal = new ThreadLocal();
	static{
		try {
			//1、获取mybatis映射文件		
			 Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			//2、得到SessionFactory
			 sf = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	public static  SqlSession getSqlSession(){
		SqlSession sqlSession = threadLocal.get();
		if(sqlSession==null){
			//3、得到session
			sqlSession = sf.openSession();
			threadLocal.set(sqlSession);
		}
		return sqlSession;
			
	}
	public static  void  closeSqlSession(){
		SqlSession sqlSession = threadLocal.get();
		if(sqlSession!=null){
			threadLocal.set(null);
			sqlSession.close();
		}
		
			
	}
	

}