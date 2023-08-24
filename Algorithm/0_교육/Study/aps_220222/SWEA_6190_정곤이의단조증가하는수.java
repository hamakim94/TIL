package aps_220222;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_6190_정곤이의단조증가하는수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력
		int[] arr;
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			Queue<String> increase = new LinkedList<String>();
			int n = sc.nextInt();
			arr = new int[n];
			// string 배열을 입력을 받았다
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			// 곱샘한걸 넣어주고
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					increase.add((arr[i] * arr[j]) + "");
				}
			}
			// System.out.println(increase.toString());
			// 단조증가 숫자들을 판단 후 넣어주는 큐
			Queue<Integer> incNum = new LinkedList<Integer>();

			while (!increase.isEmpty()) {
				// 하나씩 뽑아서, isIncre 함수에 넣어줘 : 단조증가면 그 int값을, 아니면 -1 반환
				int now = isIncre(increase.poll());
				incNum.add(now);
			}
			// 만약 다 단조증가가 아니면 -1 출력하도록 나옴
			int maxValue = -2;

			while (!incNum.isEmpty()) {
				int now2 = incNum.poll();
				if (now2 > maxValue) {
					maxValue = now2;
				}
			}

			System.out.println("#" + tc + " " + maxValue);

		}
	}

	// 단조증가 찾는 함수
	public static int isIncre(String str) {
		// 길이가 1이면 그냥 넣어주고
		if (str.length() == 1) {
			return Integer.parseInt(str);
		} else {
			// size -1 전까지 돌면서, i와 i+1의 크기 비교
			int size = str.length();
			for (int i = 0; i < size - 1; i++) {
				if (str.charAt(i + 1) - str.charAt(i) >= 0) {
					continue;
				}
				// 만약 컨티뉴가 안 됐으면, 단조증가가 아니므로
				return -1;
			}
			// 다 돌았는데도, 안 끝났으면, 단조증가
			return Integer.parseInt(str);
		}
	}
}
