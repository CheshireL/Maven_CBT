package com.biz.cbt.service;

import java.util.Scanner;

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
			System.out.println(" 1. 문제등록 2. 문제풀이 0. 종료");
			System.out.println("------------------------------------------------------");
			int select = Integer.valueOf(scan.nextLine());
			
			if(select == 0) {
				System.out.println("문제풀이를 종료합니다.");
				break;
			}
			if(select == 1) exModify();
			if(select == 2) exStart();
			
			
		}
		
	}

	private void exModify() {
		// TODO Auto-generated method stub
		while(true) {
			
			
			
		}
	}

	private void exStart() {
		// TODO Auto-generated method stub
		
	}

}
