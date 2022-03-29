package aps_220329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1232_사칙연산 {

	public static int[] left, right;
	public static String[] heap;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 실수 연산 : float
		// 최종 결과값이 정수가 떨어지지 않으면 정수부만 출력! -> 결과 /1

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		// 이제 함수
		int testCase = 10;
		for (int tc = 1; tc <= testCase; tc++) {
			sb.append("#" + tc + " ");
			int N = Integer.parseInt(br.readLine());

			heap = new String[1001];
			left = new int[1001];
			right = new int[1001];

			for (int i = 0; i < N; i++) {
				String[] now = br.readLine().split(" ");
				// 중간 노드인경우
				if (now.length == 4) {
					int idx = Integer.parseInt(now[0]);
					heap[idx] = now[1];
					left[idx] = Integer.parseInt(now[2]);
					right[idx] = Integer.parseInt(now[3]);
				} 
				// 말단 노드인 경우
				else {
					int idx = Integer.parseInt(now[0]);
					heap[idx] = now[1];
				}

			} // end for: 배열 입력 완료
			
			sb.append((int) LRV(1)).append("\n");

		} // end test Case
		System.out.println(sb);
	} // end main

	public static double LRV(int idx) {
		// 이게 자식이 무적권 있어!
		if (left[idx] != 0) {
			// 왼쪽 끝까지 계산해서 l값 채워
			double l = LRV(left[idx]);
			String now = heap[idx];
			// 오른쪽 계산해서 r값 채워
			double r = LRV(right[idx]);
//			System.out.println("AFTER : l : " + l + " r : " + r);

			double result = 0;
			if (now.equals("+")) {
				// 여기서 리턴을 어디로 받아야할지 모르겠습니다.

				result = l + r;
			} else if (now.equals("-")) {
				result = l - r;
			} else if ((now.equals("*"))) {
				result = l * r;
			} else if (now.equals("/")) {
				result = l / r;
			}
			return result;
		}
		// 자식이 없는 경우엔 그 값을 리턴하겠다!
		return Double.parseDouble(heap[idx]);
	}
}
