package aps_220221;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_12505_회전 {
	public static void main(String[] args) {
		
		//입력
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int tc = 1; tc <=testCase; tc++) {
			Queue<Integer> que = new LinkedList<Integer>();
			int size = sc.nextInt();
			int m = sc.nextInt();
			for(int i=0; i<size; i++) {
				que.add(sc.nextInt());
			}
			// 사실, 크기별로 돈 건 의미가 없어, 그래서 나머지만큼만 돌면 돼
			int total = m % size;
			// swap 느낌 비슷하게, 최근껄 뺴주고, 나중에 넣어준다
			for(int t = 0; t<total; t++) {
				int left = que.poll();
				que.add(left);
				
			}
			System.out.println("#" + tc + " " + que.peek());
			
		}
	}
}
