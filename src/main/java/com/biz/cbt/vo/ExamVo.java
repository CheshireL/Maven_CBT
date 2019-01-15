package com.biz.cbt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamVo {
	
	private String id;
	private String cb_que;
	private String cb_ans;
	private String cb_ex1;
	private String cb_ex2;
	private String cb_ex3;
	private String cb_ex4;
	
}