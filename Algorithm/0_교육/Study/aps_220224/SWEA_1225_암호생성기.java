package aps_220224;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225_암호생성기 {
	public static void main(String[] args) {
		// 일단 이해가 잘 안 가

		// 입력 받기
		Scanner sc = new Scanner(System.in);
		for (int test = 1; test <= 10; test++) {
			int tc = sc.nextInt();
			// tc별로 새로 생성
			Queue<Integer> q = new LinkedList<Integer>();
			// 8개 입력 완료
			for (int i = 0; i < 8; i++) {
				q.add(sc.nextInt());
			}
			// [1,2,3,4,5] 씩만 감소하네 => 한 싸이클
			// 하나 뽑아서 1 감소시키고, 다시 넣고
			int cnt = 0;
			while (true) {
				cnt = (cnt % 5) + 1;
				// 현재 뽑은 값
				int now = q.poll();
				// 뒤에 넣어야 할 값
				int toAdd = now - cnt;
				// 하나 뽑고 뺐는데 0 이하면, 0으로 넣고 break
				if (now - cnt <= 0) {
					q.add(0);
					break;
				}
				q.add(toAdd);
			} // end while
			System.out.print("#" + tc + " ");
			for (int element : q) {
				System.out.print(element + " ");
			}
			System.out.println();

		}

	}
}
