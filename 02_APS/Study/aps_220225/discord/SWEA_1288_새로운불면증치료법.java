package discord;

import java.util.HashSet;
import java.util.Scanner;

public class SWEA_1288_새로운불면증치료법 {
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			// 0~9부터 넣을 hashSet;
			HashSet<Character> makeTen = new HashSet<>();
			// 문자열로 받음
			String now = sc.next();
			// 매번 더해줘야할 숫자
			int toAdd = Integer.parseInt(now);
			// set에 size가 10이 되기 전 까지
			while (makeTen.size() < 10) {
				for (int i = 0; i < now.length(); i++) {
					// 해당 문자열을 돌면서 set에 넣어준다
					makeTen.add(now.charAt(i));
				}
				// now 갱신 : 문자를 숫자로 만들고, 더해야할 수를 더해준 다음 문자로 만듦
				now = (Integer.parseInt(now) + toAdd) + "";

			} // end Count
				// 딱 now까지 넣으면 하나 더 들어가므로;
			now = (Integer.parseInt(now) - toAdd) + "";
			System.out.println("#" + tc + " " + now);

		} // end testCase
	}
}
