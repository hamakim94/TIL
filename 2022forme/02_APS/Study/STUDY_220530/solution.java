package STUDY_220530;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// testCase 개수 구하기
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(br.readLine()); // 출력을 위함
			int N = Integer.parseInt(st.nextToken());// N 배열 크기
			int M = Integer.parseInt(st.nextToken());// M 나라 개수
			int[][] map = new int[N][N]; // 지도
			int[][] coordinate = new int[M + 1][2]; // 앞으로 가야할 좌표
			int ans = 0; // 정답
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0) // 1, 2, 3, 4, 5, 등 순서대로 나오므로
						coordinate[map[i][j]] = new int[] { i, j };
				}
			} // end for : 입력 완료(지도, 가야할 행,열 좌표)
			for (int i = 0; i < M; i++) {
				int[] now = coordinate[i]; // 현재 위치
				int[] next = coordinate[i + 1]; // 다음에 가야할 위치
				int absRow = Math.abs(next[0] - now[0]); // x좌표 차이
				int absCol = Math.abs(next[1] - now[1]); // y좌표 차이
				// 지도안에서 가는 경우, 지도 밖으로 가는 경우 중 작은 값 찾기
				int distRow = Math.min(absRow, N - absRow);
				int distCol = Math.min(absCol, N - absCol);
				ans += distRow;
				ans += distCol;
			}
			// 출력
			if (t == testCase)
				sb.append("#" + t + " " + ans);
			else
				sb.append("#" + t + " " + ans + "\n");

		}
		System.out.println(sb);
//		output 만드는 코드
//		try {
//			BufferedWriter fw = new BufferedWriter(new FileWriter(
//					"E:\\sample_output.txt", true));
//			fw.write(sb.toString());
//			fw.flush();
//			fw.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}
}
