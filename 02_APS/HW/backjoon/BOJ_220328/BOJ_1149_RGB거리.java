package BOJ_220328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 우선 입력 받아보자

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 문장의 수 N
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		// 입력 받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 그냥 탄력적으로, R, G, B(0,1,2)로 경우 나눠서
		// N번 for문 돌면서. 
		// R인 경우, G, B인 의 최소값을
		// G인 경우, R, B의 최소값을
		// B인 경우, R, G의 최소값을 더해주면서 식을 전개하고 싶다.
		
		// 뒤에서 계산 할거고, 이전것들의 최솟값만 더해주면 돼
		
		for(int i=1; i<N; i++) {
			arr[i][0] += Math.min(arr[i-1][1] , arr[i-1][2]);
			arr[i][1] += Math.min(arr[i-1][0] , arr[i-1][2]);
			arr[i][2] += Math.min(arr[i-1][0] , arr[i-1][1]);
		}
		
		System.out.println(Math.min(Math.min(arr[N-1][0], arr[N-1][1]), arr[N-1][2]));

	}

}
