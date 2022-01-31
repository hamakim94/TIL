package back220126;

import java.util.Scanner;

public class back_10951_AplusB4 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
	
		
		while (true) {
			try {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(a + b);
			} catch(Exception e){
				break;
			}
			
		}
		sc.close();
	}
}
