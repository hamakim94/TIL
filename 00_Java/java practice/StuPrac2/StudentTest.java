package StuPrac2;

import java.util.Scanner;

public class StudentTest {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StudentManager sm = new StudentManager();
		int sel = 0;
		do {
			System.out.println("번호를 입력하세요");
			System.out.println("1 : 학생 추가");
			System.out.println("2 : 학생 조회(이름)");
			System.out.println("3 : 전공 변경");
			System.out.println("0 : 종료");
			sel = sc.nextInt();
			// 학생 추가하기
			if (sel == 1) {
				System.out.println("학생의 이름을 입력하세요");
				String name = sc.next();
				System.out.println("나이를 입력하세요");
				int age = sc.nextInt();
				System.out.println("전공을 입력하세요");
				String major = sc.next();
				// 일단 클래스 객체 만들어서
				Student s = new Student();
				s.setName(name);
				s.setAge(age);
				s.setMajor(major);
				sm.addStudent(s);
			} else if (sel == 2) {
				System.out.println("이름을 입력하세요 : ");
				
				String name = sc.next();
				int idx = sm.getStudent(name);
				if (idx == -1) {
					System.out.println("그런사람 없습니다");
				} else {
					System.out.printf("이름 : %s \n", sm.arr[idx].getName());
					System.out.printf("나이 : %d \n" , sm.arr[idx].getAge());
					System.out.printf("전공 : %s \n", sm.arr[idx].getMajor());

				}
			} else if (sel == 3) {
				System.out.println("전공을 변경합니다");
				System.out.println("이름 입력 : ");
				String name = sc.next();
				System.out.println("전공 입력 : ");
				String major = sc.next();
				sm.changeMajor(name, major);
			}

		} while (sel != 0);
		System.out.println("프로그램을 종료합니다");
		sc.close();
	}

}

//틀린거, 자동 완성으로 다른 패키지의 같은 이름의 클래스 import -> 틀림
// 기본 접근 제한자가 default -> 다른 패키지에서 접근 불가능
