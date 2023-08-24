import java.util.Scanner;

public class BOJ_9663_Nqueen {
	static int N;
	static boolean flag;
	static int cnt;
	static int[][] arr;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		DFS(0);
		System.out.println(cnt);
	}
	private static void DFS(int level) {
		// base case
		if (level == N) {
			cnt++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (check(level, i, arr)) {
				arr[level][i] = 1;
				DFS(level + 1);
				arr[level][i] = 0;
			}
		}
	}
	// 11 ,12, 1시 방향 체크 하는 함수
	static int[] dr = { -1, -1, -1 };
	static int[] dc = { -1, 0, 1 };

	static boolean check(int r, int c, int[][] arr) {
		// 11시 체크
		boolean flag = true;

		for (int k = 1; k <= r; k++) {
			for (int i = 0; i < 3; i++) {
				int newR = r + dr[i] * k;
				int newC = c + dc[i] * k;
				if (newR < 0 || newR >= N || newC < 0 || newC >= N)
					continue;
				if (arr[newR][newC] == 1) {
					return false;
				}
			}
		}
		return flag;
	}
}
