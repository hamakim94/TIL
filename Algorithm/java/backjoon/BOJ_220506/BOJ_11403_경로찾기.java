package BOJ_220506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11403_경로찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 인접행렬 사이즈
		int[][] arr = new int[N][N]; // arr 배열
		StringBuilder sb = new StringBuilder(); // 출력을 위한 stringBuilder
		// 입력받기
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int k = Integer.parseInt(st.nextToken());
				if (k == 1) { // 1이면, 해당 방향으로 연결 된거, 그냥 1 넣어
					arr[r][c] = k;
				} else { // 연결된게 아니라면, 큰 값을 넣어서 판단해야함.
					arr[r][c] = 987654321;
				}
			}
		}
		// floyd-warshall, 경유하면서
		for (int k = 0; k < N; k++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// 현재 내 가지고있는 값보다 경유해서 갔을 때 이득이라면
					if (arr[r][c] > arr[r][k] + arr[k][c]) {
						// 현재 내 값을 경유했을 떄 값으로 바꿔
						arr[r][c] = arr[r][k] + arr[k][c];
					}
				}
			}
		} // end for : 플로이드와셜
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 만약 아직도 초반에 설정해둔 최댓값
				if (arr[r][c] == 987654321) { 
					// 연결 안 됐다는 뜻
					sb.append(0).append(' ');
				} else {
					// 아닌 경우는 무적권 연결 돼있음.
					sb.append(1).append(' ');
				}
			}
			sb.append('\n');

		}
		System.out.println(sb);
	} // end main

}
