package day3;

public class ExDate {
	
	// 멤버 변수선언
	int year;
	int month;
	int day;
	
	// 최종 생성자 
	ExDate(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	// 
	ExDate(){
		this(2021, 4, 01);
	}
	
	
		
	

	void showDate() {
		System.out.printf("%d년 %d월 %02d일\n", year, month, day);
	}
}
		

