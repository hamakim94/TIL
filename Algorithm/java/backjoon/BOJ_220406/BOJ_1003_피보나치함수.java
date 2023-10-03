package BOJ_220406;

import java.util.Scanner;

public class BOJ_1003_피보나치함수 {
	

	
	public static void main(String[] args) {
		// 40개 만들고 , [0의 개수, 1의 개수]
		int[][] fibo = new int[41][];
		// 초기값 넣어주고
		fibo[0] = new int[] {1,0};
		fibo[1] = new int[] {0,1};
		// 최대가 40이니까, 미리 배열 만들어놔
		for(int i=2; i<=40; i++) {
			fibo[i] = new int[] {0,0};
			fibo[i][0] = fibo[i-1][0] + fibo[i-2][0];
			fibo[i][1] = fibo[i-1][1] + fibo[i-2][1];
		}
		//입력받고
		Scanner sc = new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			// 숫자 입력
			int now = sc.nextInt();
			// 해당 fibo 배열의 원소의 0번째 원소, 1번째 원소 접근!
			sb.append(fibo[now][0]).append(" ").append(fibo[now][1]).append("\n");
		} // end testCase
		System.out.println(sb);
	}
	
}
