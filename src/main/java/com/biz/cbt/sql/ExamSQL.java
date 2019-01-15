package com.biz.cbt.sql;

public class ExamSQL {
	
	public static final String SELECT_ALL =
			" select * from tbl_cbt ";
	
	public static final String FIND_BY_ID =
			" select * from tbl_cbt where id = #{id}";
	
	public static final String EXAM_INSERT = 
			" insert into tbl_cbt values(#{id}, #{cb_que}, #{cb_ex1}, #{cb_ex2}, #{cb_ex3}, #{cb_ex4}, #{cb_ans})";
	
	public static final String EXAM_UPDATE = 
			" update tbl_cbt " + " set cb_que = #{cb_que}, " + " cb_ex1 = #{cb_ex1}, " +
					 " cb_ex2 = #{cb_ex2}, " + " cb_ex3 = #{cb_ex3}, " + " cb_ex4 = #{cb_ex4}, " +
					 	" cb_ans = #{cb_ans} " + " where id = #{id} ";
	
	public static final String EXAM_DELETE = 
			" delete from tbl_cbt where id = #{id}"; 

}
