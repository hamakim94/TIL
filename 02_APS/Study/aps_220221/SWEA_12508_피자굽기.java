package aps_220221;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_12508_피자굽기 {
	public static void main(String[] args) {
		// 인풋 받기
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			int ovenSize = sc.nextInt(); // 오븐의 크기
			int pizzaNum = sc.nextInt(); // 피자의 개수
			// 피자 배열 만들기
			// 인덱스 가지고 놀 거야, 마지막에 넣은 피자 인덱스를 가져보자

			// 알고보니 인덱스를 가지고 노는거였어!
			int[] pizza = new int[pizzaNum];
			for (int i = 0; i < pizzaNum; i++) {
				pizza[i] = sc.nextInt();
			}
			Queue<Integer> oven = new LinkedList<>();
			// 오븐에 피자 갯수만큼 넣기
			
			int nowIdx = 0;
			for (int i = 0 ; i < ovenSize; i++) {
				oven.add(i);
				nowIdx = i; // 마지막에 넣은 피자
			}
			int idx = 0;
			
			while(oven.size() != 1) {
				// 1. 오븐에서 하나 뽑기(인덱스)
				idx = oven.poll();
				// 2-1. 뽑은 인덱스의 피자 치즈가 0이 아니면, /2해서 넣어줌
				if (pizza[idx] != 0) {
					oven.add(idx);
					pizza[idx] /= 2;
				}
				// 2-2. 뽑은 인덱스의 피자 치즈가 0이라면
				else {
//			      2-2-1. 조건 필요, ++nowIdx 가 전체 피자 개수보다 작아야함
					if(nowIdx + 1 < pizzaNum) {
//				      피자는 이미 한 바퀴 돌예정이므로(차례대로 한바쿠 도니까)
						oven.add(++nowIdx);
						pizza[nowIdx] /= 2;
					}
				}
				
				
				//      oven에 pizza[newIdx] 
			} // end while : 1개 남을 때 까지 뽑아냈음
			System.out.println("#" + tc + " " + (oven.peek() + 1));
		} // end for : 반복 완료
	}

}
