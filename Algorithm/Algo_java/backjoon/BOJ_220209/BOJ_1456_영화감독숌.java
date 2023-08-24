package BOJ_220209;

import java.util.Scanner;


public class BOJ_1456_영화감독숌 {
	
	public static String myStr; // 문자열 담기
	public static int myLen; // 길이 담기
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		
		// cnt : 666인 경우에 +1 할 변수
		int cnt = 0;
		// 시작은 666, 
		int myNum = 666;
		
		while (true) {
			// 해당 666 : +1씩 계속 해서, 666 3개 나오는거 있으면 cnt변수 +1
			cnt += straightSix(myNum);
			// 만약 입력된 숫자와 cnt가 같다면 출력하고 끝!
			if (cnt == num) {
				System.out.println(myNum);
				break;
			}
			// 1씩 올라가며 순회하겠다
			myNum++;
		}
		
	}
	public static int straightSix(int input) {
		// String으로 만들기
		myStr = input + "";
		// 길이 받기
		myLen = myStr.length();
		//3개씩 돌면서, 다 6이면, 1 반환 아니면 0
		for(int i = 1; i< myLen -1; i++) {
			if (myStr.charAt(i-1) == '6' && myStr.charAt(i) == '6' && myStr.charAt(i+1) == '6') {
				return 1;
			}
		}// end for, i-1,i.i+1번째가 6인지 확인하기
		return 0;
	}
}
