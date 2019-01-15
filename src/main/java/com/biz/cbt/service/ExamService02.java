package com.biz.cbt.service;

import java.util.List;
import java.util.Scanner;

import com.biz.cbt.vo.ExamVo;

public class ExamService02 {
	
	Scanner scan;
	ExamService examService;
	
	public ExamService02() {
		// TODO Auto-generated constructor stub
		
		scan = new Scanner(System.in);
		examService = new ExamService();
		
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
			if(select == 2) exStart();
			
			
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
			if(select == 1) exInsert();
			if(select == 2) exUpdate();
			if(select == 3) exDelete();
			
			
		}
	}

	public void exDelete() {
		
		
		
	}

	public void exUpdate() {
		
		
		
	}
	
	
	

	public ExamVo exInsert() {
		
		
		System.out.println("문제를 입력하세요");
		System.out.print(">>");
		String[] question = new String[4];
		
		for(int i = 0 ; i < 4 ; i++) {
			System.out.print((i+1) + " 번 문제 >> ");
			question[i] = scan.nextLine();
		}
		System.out.print(" 정답 >> ");
		String ans = scan.nextLine();
		
		ExamVo vo = new ExamVo();
		
		return vo;
		 
		
	}

	public void exStart() {
		
	}

}
