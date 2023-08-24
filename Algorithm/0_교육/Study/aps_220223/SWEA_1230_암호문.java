package aps_220223;

import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_1230_암호문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		LinkedList<Integer> linkedList; 

		for (int tc = 1; tc <= 10; tc++) {
			linkedList = new LinkedList<>();
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			// 일단 링크드리스트에 다 넣어!
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				linkedList.add(sc.nextInt());
			}
			// 명령문을 셀 것
			int numOfStatement = sc.nextInt();
			

			// while문을 돌면서
			for(int state=0; state<numOfStatement; state++) {
				String input = sc.next();
				if (input.equals("I")) {
					// 넣어야 할 위치
					int now = sc.nextInt();
					// 반복문 돌 개수
					int k = sc.nextInt();
					// 바로 다음 위치이므로
					for (int i = now ; i < now + k ; i++) {
						linkedList.add(i, sc.nextInt());
					}
					
				} else if (input.equals("D")) {
					// 현재 위치
					int now = sc.nextInt();
					// 반복문 돌 개수
					int k = sc.nextInt();
					// 제거만 해주자
					for (int i = 0; i < k; i++) {
						linkedList.remove(now );
					}
					
				} else if (input.equals("A")) {
					int k = sc.nextInt();
					for (int i = 0; i < k; i++) {
						linkedList.add(sc.nextInt());
					}
					
				}
				
			} // end while : 문제수만큼 뽑음
			for (int i = 0; i < 10; i++) {
				sb.append(linkedList.get(i)).append(" ");
			}
			System.out.println(sb);
		}// end test Case

	}
}
