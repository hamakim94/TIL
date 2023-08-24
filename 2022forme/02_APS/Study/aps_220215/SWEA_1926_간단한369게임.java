package aps_220215;

import java.util.Scanner;

public class SWEA_1926_간단한369게임 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.print(play369(i) + " ");
		}
	}

	// 메또드를 만들자, 정수를 입력받으면
	public static String play369(int num) {
		// 문자열로 변환
		String temp = String.valueOf(num);
		// 최종 답
		String ans = "";
		// 문자열의 길이만큼 돌며 3,6,9 가 있으면, ans에 "-"를 누적해서 더해준다
		for (int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) == '3' || temp.charAt(i) == '6' || temp.charAt(i) == '9') {
				ans += "-";
			}
		}
		// 만약 ""과 같으면, 그냥 문자열 반환
		if (ans.equals("")) {
			return temp;
		} // -가 추가되면 그거 반환
		return ans;
	}
}
