package BOJ_220405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 며칠 지났는지
		int days = 0;

		// 자료 입력 받기
		// M : 상자의 가로칸수 :열
		int M = Integer.parseInt(st.nextToken());

		// N = 상자의 세로칸수. : 행
		int N = Integer.parseInt(st.nextToken());

		// 입력받았음.

		int[][] map = new int[N][M];
		Queue<int[]> que = new LinkedList<int[]>();

		// 입력받으면서.. que 만들어서. 시작점 만들기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int now = Integer.parseInt(st.nextToken());
				map[i][j] = now;
				if (now == 1) {
					que.add(new int[] { i, j });
				}

			}
		} // 자료 입력 완료, 1인것(시작점의 좌표까지 탐색 완료

		// 해당 dayscount가 하나씩 세주는거랑 같아 지는 시점이, 그 날이 지난거
		int daysCount = que.size();
		int cnt = 0; // cnt가 현재 날짜와 같으면, okok!

		while (!que.isEmpty()) {
			int[] now = que.poll();
			cnt++;
			for (int i = 0; i < 4; i++) {
				int newR = now[0] + dr[i];
				int newC = now[1] + dc[i];
				// 범위 안에 있고, 아직 안 갔으면
				if (newR >= 0 && newR < N && newC >= 0 && newC < M && map[newR][newC] == 0) {
					// 체크
					map[newR][newC] = 1;
					que.add(new int[] { newR, newC });
				}
			}
			// 여기서 셋을 때 앞으로 가야할 좌표들 까지 다 세줬으면
			if (!que.isEmpty() && cnt == daysCount) {
//				System.out.println("-----------------------------------");
//				for (int[] a : que) {
//					System.out.print(Arrays.toString(a) + " ");
//				}
//				System.out.println();
//
//				System.out.println("-----------------------------------");

//				for (int k = 0; k < N; k++) {
//					System.out.println(Arrays.toString(map[k]));
//				}
				// 하루 추가
				days++;
				//System.out.println(days);
				// 앞으로 세야할 갯수들을 정해주고
				daysCount = que.size();
				// System.out.println(daysCount);
				// cnt 초기화.
				cnt = 0;

			}

		} // end BFS
			// 이제 확인.
		boolean flag = true;

		for (int i = 0; i < N; i++) {
			//System.out.println(Arrays.toString(map[i]));
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					flag = false;
					// break;
				}
			}
		}
		if (flag) {
			System.out.println(days);
		} else {
			System.out.println(-1);
		}

	}
}
