package day3;

public class Dog {
	// 기본 멤버 변수 선언
	String name;
	int age;
	
	// 최종: 이름, 나이 2가지를 입력받는 경우
	Dog(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	// 이름만 입력받는 경우 생성자
	Dog(String name){
		this(name, 0);
	}
	
	// 나이만 입력받는 경우 생성자
	Dog(int age){
		this("이름모름", age);
	}
	
	// 아무것도 입력받지 않을 떄
	Dog(){
		this("이름모름", 0);
	}
	
	//info method : "강아지의 이름은 %s이고 나이는 %d입니다."
	void info() {
		System.out.printf("강아지의 이름은 %s이고 나이는 %d입니다.\n", name, age);
	}
	
	
	

	
}
