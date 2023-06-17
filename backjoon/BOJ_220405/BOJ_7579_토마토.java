package BOJ_220405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7579_토마토 {

	static int[] dr = { -1, 0, 1, 0, 0, 0 };
	static int[] dc = { 0, -1, 0, 1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 자료 입력 받기
		// M : 상자의 가로칸수 :열
		int M = Integer.parseInt(st.nextToken());

		// N = 상자의 세로칸수. : 행
		int N = Integer.parseInt(st.nextToken());

		int H = Integer.parseInt(st.nextToken());

		// 입력받았음.

		int[][][] map = new int[N][M][H];
		Queue<int[]> que = new LinkedList<int[]>();

		// 입력받으면서.. que 만들어서. 시작점 만들기
		for (int h = 0; h < H; h++) {

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int now = Integer.parseInt(st.nextToken());
					map[i][j][h] = now;
					if (now == 1) {
						que.add(new int[] { i, j, h });
					}

				}
			} // 자료 입력 완료, 1인것(시작점의 좌표까지 탐색 완료
		}

		int days = 0;
		// 해당 dayscount가 하나씩 세주는거랑 같아 지는 시점이, 그 날이 지난거

		while (!que.isEmpty()) {
			int[] now = que.poll();
			// System.out.println(Arrays.toString(now));
			days = map[now[0]][now[1]][now[2]];

			for (int i = 0; i < 6; i++) {
				int newR = now[0] + dr[i];
				int newC = now[1] + dc[i];
				int newH = now[2] + dh[i];
				// 범위 안에 있고, 아직 안 갔으면
				if (newR >= 0 && newR < N && newC >= 0 && newC < M && newH >= 0 && newH < H
						&& map[newR][newC][newH] == 0) {
					// 체크
					map[newR][newC][newH] = days + 1;
					que.add(new int[] { newR, newC, newH });
				}
			}

		} // end BFS
			// 이제 확인.
		boolean flag = true;

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				// System.out.println(Arrays.toString(map[i]));
				for (int j = 0; j < M; j++) {
					if (map[i][j][h] == 0) {
						flag = false;
						// break;
					}
				}
			}
		}
		if (flag) {
			System.out.println(days - 1);
		} else {
			System.out.println(-1);
		}

	}
}
