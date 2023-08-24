package com.ssafy.hw10.step2;

public class VipUser extends User{
	private String grade;
	private int point;

	VipUser(){
		
	}
	VipUser(String id, String password, String name, String email, int age, String grade, int point){
		super(id, password, name, email, age);
		this.grade = grade;
		this.point = point;
	}
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return super.toString() +", grade = " + grade +  ", point=" + point ;
	}
	
}
