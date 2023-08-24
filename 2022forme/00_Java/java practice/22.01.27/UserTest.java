package com.ssafy.hw10.step2;

import java.util.Scanner;

public class UserTest {
	public static void main(String[] args) {
		IUserManager um = UserManagerImpl.getinstance();
		Scanner sc = new Scanner(System.in);
		int sel;
		do {
			sel = sc.nextInt();
			System.out.println("-------------------------------------------------------");
			System.out.println("할 일을 숫자로 입력하세요!");
			System.out.println("1 : 유저 추가");
			System.out.println("2 : 전체 출력");
			System.out.println("3 : User만 출력");
			System.out.println("4 : VipUser만 출력");
			System.out.println("5 : 이름으로 찾기, 이름 추가 입력해야함");
			System.out.println("6 : 평균 시간 출력");
			System.out.println("7 : 파일 저장");
			System.out.println("0 : 프로그램 종료");
			System.out.println("-------------------------------------------------------");
			sel = sc.nextInt();
			// id 비번 이름 이메일 나이
			if (sel == 1) {
				System.out.println("일반 회원은 0, Vip회원은 1을 입력하세요");
				int num = sc.nextInt();
				if (num == 0) {
					System.out.println("id를 입력하세요");
					String user = sc.next();
					System.out.println("비밀번호를 입력하세요");
					String pw = sc.next();
					System.out.println("이름를 입력하세요");
					String name = sc.next();
					System.out.println("이메일를 입력하세요");
					String email = sc.next();
					System.out.println("나이를 입력하세요");
					int age = sc.nextInt();
					um.add(new User(user, pw, name, email, age));
				} else if (num == 1) {
					System.out.println("id를 입력하세요");
					String user = sc.next();
					System.out.println("비밀번호를 입력하세요");
					String pw = sc.next();
					System.out.println("이름를 입력하세요");
					String name = sc.next();
					System.out.println("이메일를 입력하세요");
					String email = sc.next();
					System.out.println("나이를 입력하세요");
					int age = sc.nextInt();
					System.out.println("등급을 입력하세요");
					String grade = sc.next();
					System.out.println("포인트를 입력하세요");
					int point = sc.nextInt();
//					private String grade;
//					private int point;
					um.add(new VipUser(user, pw, name, email, age, grade, point));
				}
			} else if (sel == 2) {
				System.out.println("-------------------------------------------------------");
				System.out.println("전체 출력");
				System.out.println();
				// 전체 um 속 배열 출력
				for (int i = 0; i < um.getList().size(); i++) {
					System.out.println(um.getList().get(i).toString());
				}
				System.out.println("-------------------------------------------------------");
			} else if (sel == 3) {
				System.out.println("User만 출력");
				System.out.println();

				// 전체를 출력하기 위해, while문을 돈다
				for (int i = 0; i < um.getUsers().size(); i++) {
					System.out.println(um.getUsers().get(i).toString());
				}
				System.out.println("-------------------------------------------------------");
			} else if (sel == 4) {
				System.out.println("-------------------------------------------------------");
				System.out.println("VipUser만 출력");
				System.out.println();

				for (int i = 0; i < um.getVipUsers().size(); i++) {
					System.out.println(um.getVipUsers().get(i).toString());
				}
				System.out.println("-------------------------------------------------------");

			} else if (sel == 5) {
				System.out.println("-------------------------------------------------------");
				System.out.println("이름을 입력하세요 : ");
				String name = sc.next();

				System.out.printf("%s의 이름을 포함하는 것들만 출력(SearchByName)", name);
				System.out.println();

				try {
					for (int i = 0; i < um.getList().size(); i++) {
						System.out.println(um.searchByName(name).get(i).toString());
					}
				} catch (NameNotFoundException e) {
					e.printStackTrace();
					;
				}
			} else if (sel == 6) {
				System.out.println("-------------------------------------------------------");
				System.out.println("평균 나이 출력");
				System.out.println();
				System.out.println(um.getAgeAvg());

			} else if (sel == 7) {
				System.out.println("-------------------------------------------------------");
				System.out.println("파일을 저장합니다");
				um.saveData();

			} else if (sel == 0) {
				System.out.println("-------------------------------------------------------");
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				System.out.println("-------------------------------------------------------");
			}
		} while (sel != 0);
	}
}

//		
//		User u1 = new User("kk", "123", "철수", "c@chul.com", 30);
//		User u2 = new User("tt", "234", "양희", "y@chul.com", 35);
//		User u3 = new User("ss", "345", "팡팡", "p@chul.com", 40);
//		VipUser vu1 = new VipUser("kk", "123", "빕철", "vc@chul.com", 30, "A", 32);
//		VipUser vu2 = new VipUser("kk", "123", "빕수", "vs@chul.com", 35, "B", 35);
//		VipUser vu3 = new VipUser("kk", "123", "빕해해", "vh@chul.com", 41, "C", 40);
//
//		um.add(u1);
//		um.add(u2);
//		um.add(u3);
//		um.add(vu1);
//		um.add(vu2);
//		um.add(vu3);
