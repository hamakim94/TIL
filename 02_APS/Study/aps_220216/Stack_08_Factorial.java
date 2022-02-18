package aps_220216;

public class Stack_08_Factorial {
	public static void main(String[] args) {
		System.out.println(factorial(5));
	}
	public static int factorial(int num) {
		if(num == 1) {
			return 1;
		}
		return num * factorial(num - 1);
		
	}
}
