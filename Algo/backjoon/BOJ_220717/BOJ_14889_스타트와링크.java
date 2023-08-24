package BOJ_220717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {
	// 1. 전체의 인원을 반으로 나누는 경우의 수를 구한다
	// 2. 뽑은 팀에서, 2개씩 뽑아서 점수를 누적한다
	// 2-1. 나머지 팀에서 점수를 2개씩 뽑아 점수를 누적한다
	// 3.두 점수의 차이의 절댓값의 최소값을 구한다.
	static int N, ans;
	static int[][] nums;
	static boolean[] visited, visitedSmall;
	static int[] start, link, tempStart, tempLink;

	public static void main(String[] args) throws NumberFormatException, IOException {
		ans = Integer.MAX_VALUE;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		start = new int[N / 2];
		link = new int[N / 2];
		nums = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end for : 배열 입력 완료
		comb(0);
		System.out.println(ans);
	}

	public static void comb(int level) {
		if (level == N / 2) {
			countDiff();
			return;
		}
		for (int i = 0; i < N; i++) {

			if (!visited[i]) {
				start[level] = i;
				if (level > 0 && start[level] < start[level - 1])
					continue;
				visited[i] = true;
				comb(level + 1);
				visited[i] = false;
			}

		}
	}
	public static void countDiff() {
		int teamStart = 0;
		int teamLink = 0;
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(visited[i] == true && visited[j] == true) {
					teamStart += (nums[i][j] + nums[j][i]);
				}
				if(visited[i] == false && visited[j] == false) {
					teamLink += (nums[i][j] + nums[j][i]);
				}
			}
		}
		ans = Math.min(Math.abs(teamStart - teamLink), ans);
	}
}
