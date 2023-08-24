package back220125;

import java.util.Scanner;

public class back_2588_곱셈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int whole_a = sc.nextInt();
		int whole_b = sc.nextInt();
		int a = whole_b/100;
		int b = (whole_b%100)/10;
		int c = whole_b%10;	
		sc.close();

		
		System.out.println(whole_a * c);
		System.out.println(whole_a * b);
		System.out.println(whole_a * a);
		System.out.println(whole_a * whole_b);
	}
}
