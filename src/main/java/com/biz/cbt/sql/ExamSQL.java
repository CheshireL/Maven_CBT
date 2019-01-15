package com.biz.cbt.sql;

public class ExamSQL {
	
	public static final String SELECT_ALL =
			" select * from tbl_cbt ";
	
	public static final String FIND_BY_ID =
			" select * from tbl_cbt where id = #{id}";
	
	public static final String EXAM_INSERT = 
			" insert into tbl_cbt values(#{id}, #{cb_question}, #{cb_example1}, #{cb_example2}, #{cb_example3}, #{cb_example4}, #{cb_answer},)";
	
	public static final String EXAM_UPDATE = 
			" update tbl_cbt " + " set id = #{id} " + " set cb_question = #{cb_question} " + " set cb_ample1 = #{cb_ample1} " +
					 " set cb_example2 = #{cb_example2} " + " set cb_example3 = #{cb_example3} " + " set cb_example4 = #{cb_example4} " +
					 	" set cb_answer = #{cb_answer} ";
	
	public static final String EXAM_DELETE = 
			" delete from tbl_cbt where id = #{id}"; 

}
