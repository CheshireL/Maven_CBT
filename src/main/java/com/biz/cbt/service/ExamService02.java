package com.biz.cbt.service;

import java.util.List;
import java.util.Scanner;

import com.biz.cbt.vo.ExamVo;

public class ExamService02 {
	
	Scanner scan;
	ExamService eS;
	public ExamService02() {
		// TODO Auto-generated constructor stub
		
		scan = new Scanner(System.in);
		eS = new ExamService();
		
	}
	
	public void exMenu() {
		while(true) {
			System.out.println("======================================================");
			System.out.println("	정보처리 기사 실기문제	");
			System.out.println("======================================================");
			System.out.println(" 1. 문제입력 2. 문제풀이 0. 종료");
			System.out.println("------------------------------------------------------");
			int select = Integer.valueOf(scan.nextLine());
			
			if(select == 0) {
				System.out.println("시스템을 종료합니다.");
				break;
			}
			if(select == 1) exModify();
			if(select == 2) eS.selectAll();
			
			
		}
		
	}

	public void exModify() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("======================================================");
			System.out.println("1. 문제등록 2. 문제수정 3. 문제삭제 0. 종료");
			System.out.println("------------------------------------------------------");
			int select = Integer.valueOf(scan.nextLine());
			
			if(select == 0) {
				System.out.println("문제입력을 종료합니다.");
				break;
			}
			if(select == 1) eS.insertExam();
			if(select == 2) eS.updateExam();
			if(select == 3) eS.deleteExam();
			
			
			
			
		}
	}

		

	public ExamVo exInsert() {
		
		
		System.out.println("문제를 입력하세요 ");

		System.out.println(" 번호입력 >>");
		String id = scan.nextLine();
		
		System.out.println(" 문제입력 >>");
		String question = scan.nextLine();
		
		System.out.println("1번 문항 입력 >>");
		String ex01 = scan.nextLine();
		System.out.println("2번 문항 입력 >>");
		String ex02 = scan.nextLine();
		System.out.println("3번 문항 입력 >>");
		String ex03 = scan.nextLine();
		System.out.println("4번 문항 입력 >>");
		String ex04 = scan.nextLine();
		
		System.out.print(" 정답 >> ");
		String ans = scan.nextLine();
		
		ExamVo vo = new ExamVo();
		
		vo.setId(id);
		vo.setCb_que(question);
		vo.setCb_ex1(ex01);
		vo.setCb_ex2(ex02);
		vo.setCb_ex3(ex03);
		vo.setCb_ex4(ex04);
		vo.setCb_ans(ans);
		
		return vo;
		 
		
	}

	public void exStart() {
		
		
	}

}
