package com.biz.cbt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

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
	Scanner sc;
	List<ExamVo> eList;
	int score;
	
	public ExamService() {
		
		eList = new ArrayList();
		sc = new Scanner(System.in);
		
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

	
	public void selectAll(){
		
		SqlSession session=this.sqlSessionFactory.openSession();
		ExamDao eDao=session.getMapper(ExamDao.class);
		
		eList = eDao.selectAll();
		
		for(ExamVo vo : eList) {
			String[] exa = {vo.getCb_ex1(), vo.getCb_ex2(), vo.getCb_ex3(), vo.getCb_ex4()};
			Collections.shuffle(Arrays.asList(exa));
			System.out.println(vo.getId() + vo.getCb_que());
			System.out.println("=========================================================");
			System.out.print("1번" + exa[0] + "\t");
			System.out.print("2번" + exa[1] + "\t");
			System.out.print("3번" + exa[2] + "\t");
			System.out.print("4번" + exa[3] + "\n");
			System.out.println("---------------------------------------------------------");
			
			System.out.print("정답?? >>");
			int ans = Integer.valueOf(sc.nextLine());
			if(exa[ans-1].equals(vo.getCb_ans())) {
				System.out.println("정답입니다!!");
				score += 5;
			} else {
				System.out.println("오답입니다..");
				System.out.println("계속하시려면 아무키를 입력해주세요, 그만두시려면 0번을 입력해주세요");
				String strM = sc.nextLine();
				if(strM.equals("0")) break;
			}
							
		}
		System.out.println("점수 score :" + score);
		score =0;
		
		
		
	}
	

	
	public int insertExam() {
		
		SqlSession session=this.sqlSessionFactory.openSession();
		ExamDao eDao=session.getMapper(ExamDao.class);
		
		ExamService02 ex = new ExamService02();
		
		ExamVo vo = ex.exInsert();
		System.out.println(vo);
		int intNum=eDao.insert(vo);
		
		if(intNum >0) {
			System.out.println("입력 완료");
		}else System.out.println("오류");
		session.commit();
		session.close();
		
		return intNum;
	}
	
	public void updateExam() {
		
		SqlSession session=this.sqlSessionFactory.openSession();
		ExamDao eDao=session.getMapper(ExamDao.class);
		
		ExamService02 ex = new ExamService02();
		ExamVo vo = ex.exInsert();
		int ret = eDao.update(vo);
		
		session.commit();
		session.close();
	}
	
	public void deleteExam() {
		
		SqlSession session=this.sqlSessionFactory.openSession();
		ExamDao eDao=session.getMapper(ExamDao.class);
		
		System.out.print("id를 입력하시오>>");
		String strNum = sc.nextLine();
		int intNum = Integer.valueOf(strNum);
		int ret = eDao.delete(intNum);
		session.commit();
		session.close();
	}
	
}
