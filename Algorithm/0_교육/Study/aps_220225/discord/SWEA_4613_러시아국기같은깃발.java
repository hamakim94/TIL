package discord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4613_러시아국기같은깃발 {
	public static void main(String[] args) throws IOException {

		// 우선 입력받자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCase; tc++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);

			char[][] map = new char[N][M];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			// 최솟값을 구할 변수 
			int minValue = Integer.MAX_VALUE;
			// N*M에. 행에 범위제한을 둬서, 바꿔야 할 것들을 알려줘야하는데..
			for (int i = 0; i <= N - 3; i++) {
				for (int j = i + 1; j <= N - 2; j++) {
					// 바꿔야 할 개수를 셀 cnt
					int cnt = 0;
					// 열을 돌 변수 : k
					// 0부터 i행까지 개수 셀 변수 w
					for(int w=0; w<=i; w++) {
						for(int k=0; k<M; k++) {
							if (map[w][k] != 'W') {
								cnt += 1;
							}
						}
					}
					// i+1행부터 자신까지 j까지 셀 변수 b
					for(int b=i+1; b<=j; b++) {
						for(int k=0; k<M; k++) {
							if (map[b][k] != 'B') {
								cnt += 1;
							}
						}
					}
					// j+1행부터 자신부터 셀 변수 r
					for(int r=j+1; r<=N-1; r++) {
						for(int k=0; k<M; k++) {
							if (map[r][k] != 'R') {
								cnt += 1;
							}
						}
					} // 카운팅 완료
					// 최솟값 비교
					minValue = Math.min(minValue, cnt);

				}
			} // end for : 전체 개수 세기 완료
			System.out.println("#" + tc + " " + minValue);
		} // end testCase

	}
}
