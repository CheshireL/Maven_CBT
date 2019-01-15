package com.biz.cbt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.biz.cbt.db.ExamDao;
import com.biz.cbt.db.ExamDataSourceFactory;
import com.biz.cbt.vo.ExamVo;

public class ExamService {
	
	SqlSessionFactory sqlSessionFactory;
	
	public ExamService() {
		
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="myBTs";
		String password="1234";
		
		Properties props=new Properties();
		
		props.put("DRIVER", driver);
		props.put("URL", url);
		props.put("USER", user);
		props.put("PASSWORD", password);
		
		ExamDataSourceFactory cbtDS=new ExamDataSourceFactory();
		
		cbtDS.setProperties(props);
		
		DataSource dataSource=cbtDS.getDataSource();
		
		TransactionFactory transactionFactory=new JdbcTransactionFactory();
		
		Environment env=new Environment("ExamEnv", transactionFactory, dataSource);
		
		Configuration config=new Configuration(env);
		config.addMapper(ExamDao.class);
				
		this.sqlSessionFactory=new SqlSessionFactoryBuilder().build(config); 
		
		
	}

	
	public List<ExamVo> selectAll(){
		
		SqlSession session=this.sqlSessionFactory.openSession();
		ExamDao eDao=session.getMapper(ExamDao.class);
		
		List<ExamVo> examList=new ArrayList();
		
		examList=eDao.selectAll();
		
		return examList;
	}
	
	public ExamVo findById(long ex_ID) {
		
		SqlSession session=this.sqlSessionFactory.openSession();
		ExamDao eDao=session.getMapper(ExamDao.class);
		
		ExamVo vo = eDao.findByID(ex_ID);
		
		return vo;
		
	}
	
	public int insertExam(ExamVo vo) {
		
		SqlSession session=this.sqlSessionFactory.openSession();
		ExamDao eDao=session.getMapper(ExamDao.class);
		
		int ret = eDao.insert(vo);
		session.commit();
		session.close();
		return ret;
	}
	
	public int updateExam(ExamVo vo) {
		
		SqlSession session=this.sqlSessionFactory.openSession();
		ExamDao eDao=session.getMapper(ExamDao.class);
		
		int ret = eDao.update(vo);
		session.commit();
		session.close();
		return ret;
	}
	
	public int deleteExam(long ex) {
		
		SqlSession session=this.sqlSessionFactory.openSession();
		ExamDao eDao=session.getMapper(ExamDao.class);
		
		int ret = eDao.delete(ex);
		session.commit();
		session.close();
		return ret;
	}
	
}
