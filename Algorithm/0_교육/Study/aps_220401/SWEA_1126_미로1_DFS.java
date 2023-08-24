package aps_220401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1126_미로1_DFS {

	// 탐색할 방향 : 우, 하, 좌, 상

	public static int[] dr = { 0, 1, 0, -1 };
	public static int[] dc = { 1, 0, -1, 0 };
	// 초기값 불가능!
	public static int ans;
	// 지도
	public static String[][] map;
	// 답 출력을 위한 스트링
	public static StringBuilder sb;

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
			DFS(1, 1);

			sb.append(ans).append("\n");

		}
		System.out.println(sb);
	} // end main

	public static void DFS(int r, int c) {
		map[r][c] = "1";
		// 가능할 조건 :
		if (r == 13 && c == 13) {
			ans = 1;
		}
		// 일단 갔다고 체크
		// 여기서 for문 돌면서, 0인 곳만 가도록!

		for (int i = 0; i < 4; i++) {
			int newR = r + dr[i];
			int newC = c + dc[i];
			// 비어 있으면!
			if (map[newR][newC].equals("0") || map[newR][newC].equals("3")) {
				//System.out.println(newR + " " + newC);
				DFS(newR, newC);
			}
		}

	}
}
