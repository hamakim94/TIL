package StuPrac;

import java.util.Scanner;

public class StudentTest {
	// 전체 학생 수를 count하기 위한 변수, index로 접근하기 때문에(배열)
	static int cnt = 0;
	static Student[] arr = new Student[100];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 선택을 위한 정수형 변수
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
				Student stu = new Student();
				stu.name = name;
				stu.age = age;
				stu.major = major;
				arr[cnt++] = stu;
			} else if (sel == 2) {
				// 학생 조회
				System.out.println("학생의 입력을 입력하세요");
				String name = sc.next();
				int num = getStudent(name);
				if (num == -1) {
					System.out.println("조회된 학생은 없습니다");
				} else {
					System.out.printf("조회한 학생의 이름 : %s \n", arr[num].name );
					System.out.printf("조회한 학생의 나이 : %d \n", arr[num].age );
					System.out.printf("조회한 학생의 전공 : %s \n", arr[num].major);	
				}

			} else if (sel == 3){
				System.out.println("전공을 변경합니다");
				System.out.println("이름");
				String name = sc.next();
				System.out.println("전공");
				String major = sc.next();
				changeMajor(name, major);
			}

		} while (sel != 0);
		System.out.println("프로그램을 종료합니다.");
		sc.close();
	}

	// 여기 static, 정적인 이유, main함수 자체가 public static void!!!!!
	static int getStudent(String name) {
		int idx = -1;
		for (int i = 0; i < cnt; i++) {
			// 매우 중요, String 또한 하나의 배열, 따라서 equals method 사용해야해!!
			if (name.equals(arr[i].name))
				idx = i;
		}
		return idx;

	}
	
	static void changeMajor(String name, String major) {
		int num = getStudent(name);
		if (num == -1) {
			System.out.println("그런 학생 없어요");
		} else {
			arr[num].major = major;
		}
	}
}

// 틀린거 : 객체의 값을 비교할 땐, equals method 사용
// 		   public static main : 결국 정적 블록, 따라서 static 함수만 불러올 수 있다.
//         조회를 할 땐, 임시로 상태를 이상하게 만들어서(-1), 그 값을 변경하도록, 만약 -1이면 없다고 할 수 있음
//         한 번에 입력받을 생각보단, 지금은 next, next()를 여러번 하는걸 직접 명시해주면 된다.
