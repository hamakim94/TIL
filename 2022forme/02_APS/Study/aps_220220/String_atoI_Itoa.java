package aps_202220;

import java.util.ArrayList;

public class String_atoI_Itoa {
	public static void main(String[] args) {
		// ItoA : 정수를 문자열로 만드는 방법
		System.out.println(AtoI("3321"));
		System.out.println(ItoA(1234));
		// AtoI : 문자열을 정수로 만드는 방법.

	}
	
	public static String ItoA(int a) {
		// 10으로 계속 나눠서
//		1234
//		123  4
//		12   3
//		1   2
//		0   1
		int ans = 0;
		String str = "";
		ArrayList<String> arr = new ArrayList<>();
		
		while (a != 0) {
			arr.add(a%10 + "");
			a = a / 10;
		}
		for(int i= arr.size()-1; i>=0; i--) {
			str += arr.get(i);
		}
		return str;
	}

	public static int AtoI(String a) {
		// 입력이 만약 "1234"로 들어온다면.
		char[] arr = a.toCharArray();
		// 일단 내 생각대로
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {	
			if (i == arr.length-1) {
				ans +=(arr[i] - '0');
				break;
			}
			ans += (arr[i] - '0') ;
			ans *= 10;
		}
		return ans;
		
//		for (char ch : arr) {	
//			if( ch >= '0' && ch <= '9') {
//				now = ch - '0';
//			}else {
//				break;
//			}
//			ans = 10*ans + now;
//		}

	}
}
