package aps_220222;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char a = '0';
		StringBuilder sb = new StringBuilder();
		String str = "";
		sb.append(a);
		System.out.println(sb);
		str += a;
		System.out.println(str);
		// 즉, char는 String과 연산하면 자동으로 string으로 바뀌네
		
		// 엔터를 입력받을떄마다 출력하라고 나왔는데요
		String st = sc.next();
		System.out.println(st.equals(""));
		
	}
}
