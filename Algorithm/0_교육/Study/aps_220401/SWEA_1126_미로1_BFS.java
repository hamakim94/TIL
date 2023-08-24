package aps_220401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1126_미로1_BFS {

	// 탐색할 방향 : 우, 하, 좌, 상

	public static int[] dr = { 0, 1, 0, -1 };
	public static int[] dc = { 1, 0, -1, 0 };
	// 초기값 불가능!
	public static int ans;
	// 지도
	public static String[][] map;
	// 답 출력을 위한 스트링
	public static StringBuilder sb;
	// 현재 지점을 받기 위한 배열 선언
	public static int[] now;

	public static void main(String[] args) throws NumberFormatException, IOException {

		sb = new StringBuilder();
		// 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 0; tc < 10; tc++) {
			// 출력을 위한 test
			sb.append("#").append(Integer.parseInt(br.readLine())).append(" ");

			// 입력받을 map
			map = new String[16][16];
			// 지도 입력
			for (int i = 0; i < 16; i++) {
				map[i] = br.readLine().split("");
			}
			// 답 초기화
			ans = 0;

			Queue<int[]> que = new LinkedList<>();
			int[] start = { 1, 1 };
			map[start[0]][start[1]] = "1";
			que.add(start);

			// que 가 비어있지 않을 때 까지!
			while (!que.isEmpty()) {
				// pop해서 현재꺼 가져오기
				now = que.poll();
				if (now[0] == 13 && now[1] == 13) {
					ans = 1;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int newR = now[0] + dr[i];
					int newC = now[1] + dc[i];

					if (map[newR][newC].equals("0") || map[newR][newC].equals("3")) {
						int[] arr = new int[2];
						arr[0] = newR;
						arr[1] = newC;
						// 현재꺼 갔다고 표시!
						map[newR][newC] = "1";
						que.add(arr);
					}
				}
			} // end while

			sb.append(ans).append("\n");

		}
		System.out.println(sb);
	}// end main
}
