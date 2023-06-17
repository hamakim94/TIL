package backjoon_220202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_1018_체스판다시칠하기 {
	// 답인 배열들
	static boolean[][] arr;
	// 최소값 구하기
	static int min = 64;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 행수
		int r = Integer.parseInt(st.nextToken());
		// 열수
		int c = Integer.parseInt(st.nextToken());

		// r x c 행렬 생성 : W일 때 true, 아니면 B
		arr = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				if (str.charAt(j) == 'W') {
					arr[i][j] = true;
				} else {
					arr[i][j] = false;
				}
				// System.out.print( arr[i][j] + " ");
			}
			// System.out.println();
		}
		// 일단 만들어 졌어.
		// 그럼 이제 새로운 행 수, 새로운 열 수를 돌면서, 틀린거 찾기를 하자

		int n_row = r - 7;
		int n_col = c - 7;

		for (int i = 0; i < n_row; i++) {
			for (int j = 0; j < n_col; j++) {
				find(i, j);
			}
		}
		System.out.println(min);

	}

	public static void find(int i, int j) {
		int count = 0;
		int max_x = i + 8;
		int max_y = j + 8;
		// 일단 하나를 잡아. 첫 번째 값
		boolean TF = arr[i][j];
		for (int x = i; x < max_x; x++) {
			for (int y = j; y < max_y; y++) {
				// 만약 0,0번째가 TF랑 같지 않으면
				// count 라는 변수에 1을 추가하자
				if (arr[x][y] != TF) {
					count++;
				}
				// 다음에 비교할건 또 TF 바꿔줘야 하니까
				TF = !(TF); 
			}
			// 다음 줄에 있는거 또한 TF 바꿔줘야 하니까
			TF = !(TF);
		}
		// 여기서, 첫 째가 B인 것과, W인 경우의 최솟값을 출력해쥼
		count = Math.min(count, 64 - count);
		// 이걸 static 변수인 min과 비교해서 작으면 min값에 넣고, 이 함수를 반복문을 돌며 반복한다.
		min = Math.min(count, min);
	}

}
