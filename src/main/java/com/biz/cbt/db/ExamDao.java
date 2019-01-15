package com.biz.cbt.db;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.biz.cbt.sql.ExamSQL;
import com.biz.cbt.vo.ExamVo;


public interface ExamDao {
	
	@Select(ExamSQL.SELECT_ALL)
	public List<ExamVo> selectAll();
	
	@Select(ExamSQL.FIND_BY_ID)
	public ExamVo findByID(long ex_ID);
	
	@Insert(ExamSQL.EXAM_INSERT)
	public int insert(ExamVo vo);
	@Update(ExamSQL.EXAM_UPDATE)
	public int update(ExamVo vo);
	@Delete(ExamSQL.EXAM_DELETE)
	public int delete(long ex);


}
