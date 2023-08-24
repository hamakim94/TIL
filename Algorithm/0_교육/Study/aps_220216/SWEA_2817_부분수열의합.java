package aps_220216;

import java.util.Scanner;

public class SWEA_2817_부분수열의합 {

	// 어떻게 해야할 지 몰라서, 다 정적(static)으로 선언
	public static int[] arr; // 입력을 받을 배열
	public static boolean[] sel; // 선택, 선택하지 않아
	public static int N; // 자료의 개수
	public static int K; // 최종 합
	public static int sum; // 중간에 더해줄 값
	public static int cnt; // 최종 수를 더해줌

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();

		// 입력 완료
		for (int tc = 1; tc <= testCase; tc++) {
			cnt = 0; // 이게 다시 쓰이므로
			N = sc.nextInt();// 이렇게 선언을 다시 하면 static하게 쓰임
			K = sc.nextInt(); 

			arr = new int[N]; // 사이즈에 맞게 재선언!
			sel = new boolean[N];
			// 입력받기
			for (int i = 0; i < N; i++) { 
				arr[i] = sc.nextInt();
			}
			// 들어가렴
			sumOfSequence(0);
			// 뽑으렴
			System.out.println("#" + tc + " " + cnt);

		}
	}

	public static void sumOfSequence(int idx) {
		// base
		// 입력값인 idx가 길이다! 그러면~
		if (idx == arr.length) {
			sum = 0; // static 변수 초기화해주고
			for (int i = 0; i < arr.length; i++) {
				if (sel[i]) { // sel[i]가 true라면
					sum += arr[i]; // 더해줭
				}
			} // 다 더했고, 그 결과가 K라면
			if (sum == K) {
				// 1 더해줭
				cnt += 1;
			}
			return; // 끝!
		} // end if,

		// recursion
		
		sel[idx] = true; // 일단 들어가!
		sumOfSequence(idx + 1); // 다음거 진행! 다 나왔니? 
		sel[idx] = false; // // 이번엔 false로 들어가!
		sumOfSequence(idx + 1); // 같은거 다시해!

	}

}
