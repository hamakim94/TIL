package aps_220405;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_7733_치즈도둑 {

	static int[][] cheese; // 치즈의 맛
	static boolean[][] visited; // 방문을 기록하기 위한 배열

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		// testCase 수
		int testCase = sc.nextInt();

		for (int tc = 1; tc <= testCase; tc++) {
			// N*N 배열
			int N = sc.nextInt();
			cheese = new int[N][N];
			
			int maxCount = -1;
			// 입력 받기 & 최대값 찾아서, for문 범위 정하기
			int maxCheese = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cheese[i][j] = sc.nextInt();
					maxCheese = Math.max(cheese[i][j], maxCheese);
				}
			}
			
			// 이제 1부터 maxCheese값 까지 배열을 돌면서, 치즈 개수 세주기
			for (int day = 0; day <= maxCheese; day++) {
				// 날이 지날수록 치즈 1개씩 까인다고 생각했어요
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						cheese[i][j]--;
					}
				}
//				System.out.println("------ day : " + day + "--------------" );
//				for(int [] k :cheese) {
//					System.out.println(Arrays.toString(k));
//				}
				// 매번 방문 초기화!
				visited = new boolean[N][N];
				// 치즈 days 치즈 개수!
				int cnt = 0;
				// 이제 여기서 또 배열을 돌면서, 치즈가 있으면,
				// 덩어리를 세주기 위해 BFS를 돌겠어요!
				Queue<int[]> que = new LinkedList<int[]>();

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						
						if (cheese[i][j] > 0 && !visited[i][j]) {
							cnt++; // 치즈 하나 추가요
							visited[i][j] = true;
							que.add(new int[] { i, j });

							while (!que.isEmpty()) {
								int[] now = que.poll();

								for (int idx = 0; idx < 4; idx++) {
									int newR = now[0] + dr[idx];
									int newC = now[1] + dc[idx];

									if (newR >= 0 && newR < N && newC >= 0 && newC < N && cheese[newR][newC] > 0
											&& visited[newR][newC] == false) {
										visited[newR][newC] = true;
										que.add(new int[] {newR,newC});
									}

								}

							} // end while : end BFS
						} // end if : 치즈 있는 경우 BFS 돌면서 cnt 끝.
					}
				} // end for : 치즈를 순회하며 cnt 새주기
				// 카운트가 끝나면 치즈맥스랑 놀기
				maxCount = Math.max(cnt, maxCount);

			} // end for : 1일부터 최대날짜까지 끝!
			sb.append("#").append(tc).append(" ").append(maxCount).append("\n");

		} // end testCase
		System.out.println(sb);

	}// end main
}
