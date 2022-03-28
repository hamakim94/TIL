package BOJ_220328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리_DFS {

	public static int N;
	public static int[][] arr;
	// 최솟값 얻을 변수
	public static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 우선 입력 받아보자

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		min = Integer.MAX_VALUE;
		// 문장의 수 N
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		// 입력 받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(0, 0, 0);
		System.out.println(min);

		// 반복문 여러번 돌아야 하는데, 재귀 이용
		// 0,1,2 중 하나 뽑는데, 전거랑 달라야해..

	}

	public static void DFS(int L, int idx, int sum) {
		// N의 수, 배열에 마지막에 오면, 합과 최솟값을 비교한다
		if (L == N) {
			if (sum < min) {
				min = sum;
			}
			return;
		}

		// 시작하는 경우는, 0인 idx값을 빼주면 안 되기 때문에 따로 빼줬다

		else {
			// for문을 돌면서, 0, 1, 2 를 돈다, 근데 여기서 이전 상태를 저장하고싶은데..
			
			// 가지치기 : 만약 sum이 min보다 큰 경우는 더 갈 필요가 없지.
			if(sum > min) 
				return;
			
			for (int i = 0; i < 3; i++) {
				// L이 0인 경우엔, 이전 값도 0이란 idx를 주기 때문에 skip
				if (L > 0) {
					if (i == idx) {
						continue;
					}
				}
				// sum이라는 변수에 i번째 값 더해주고.
				sum += arr[L][i];		
				// System.out.println("L : " + L + " i : " + i + " sum : " + sum + " min " + min);
				// 해당 i번째 값을 다음에 돌면 안 되는데....
				DFS(L + 1, i, sum);
				// 함수를 돌고 난 후 그 값을 뺴주고 불렀던 곳에 값을 던져준다.
				sum -= arr[L][i];
			}
		}

	}
}
