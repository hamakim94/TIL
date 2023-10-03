package BOJ_220410;

import java.util.Scanner;

public class BOJ_1463_1로만들기 {
	static int n; // 숫자 저장
	static int minVal; // 최솟값 저장
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		minVal = Integer.MAX_VALUE;
		DFS(0, n);
		System.out.println(minVal);
	}

	private static void DFS(int cnt, int num) {
		//가지치기, cnt가 minVal보다 크면 그만해
		if(cnt > minVal)
			return;
		// 
		// base case
		if (num == 1) {
			minVal = Math.min(minVal, cnt);
			return;
		}
		// 3으로 나누어 떨어지는 경우엔 3으로 나눠보고
		if (num % 3 == 0)
			DFS(cnt + 1, num / 3);

		// 다시 나와서 2로 나누어 떨어지는지 확인하고
		if (num % 2 == 0)
			DFS(cnt + 1, num / 2);
		// 그냥 1 빼보고.
		DFS(cnt + 1, num - 1);

	}
}
