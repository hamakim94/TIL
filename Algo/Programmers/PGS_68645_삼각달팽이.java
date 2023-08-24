package PGS_220513;

public class PGS_68645_삼각달팽이 {

	static int[] dr = { 1, 0, -1 };
	static int[] dc = { 0, 1, -1 };

	class Solution {
		// 하, 우, 좌상

		public int[] solution(int n) {
			int[][] arr = new int[n][]; // 숫자넣을배열
			int totalSize = n * (n + 1) / 2; // 전체 사이즈, 등비수열 합
			for (int i = 1; i < n + 1; i++) {
				arr[i - 1] = new int[i]; // 1, 2, 3, 4개씩 넣어줌
			}

			int cnt = 0; // arr[i][j] 에 cnt를 넣을거
			int idx = 0; // dr, dc의 idx
			int row = 0; // 현재 보고 있는 행
			int col = 0; // 현재 보고 있는 열
			arr[row][col] = ++cnt; // (0,0)에 1 더해서 처리
			// 전체 사이즈 다 돌동안
			while (cnt != totalSize) {
				row += dr[idx]; // 다음 행
				col += dc[idx]; // 다음 열
				// 아래로 내려가는 경우
				if (idx == 0) {
					// row == n 조건 : 처음에는 방문처리 안 돼있음, 내가 가려는 곳이 범위 밖이면
					if (row == n || arr[row][col] > 0) {
						idx = (++idx) % 3; // 하->우
						row = row - 1 + dr[idx]; // 이미 범위 넘었으므로, 하나 빼서 원래자리로,
						col = col + dc[idx]; // 오른쪽으로 가기 시작하자
						arr[row][col] = ++cnt; // 새로운 좌표에 cnt++ 넣어줘
					} else {
						arr[row][col] = ++cnt; // 아니면 그냥 잘 들어가구
					}
				} else if (idx == 1) {
					// col == n 조건 : 처음엔 방문처리 안 돼있어서, 가장 긴 가장자리 처리 해주게됨
					if (col == n || arr[row][col] > 0) {
						idx = (++idx) % 3;
						row = row + dr[idx];
						col = col - 1 + dc[idx]; // 원래자리로 돌아와서 좌상 좌표 가렴
						arr[row][col] = ++cnt;
					} else {
						arr[row][col] = ++cnt;
					}
				} else { // 좌상일 때
					if (arr[row][col] > 0) { // 여긴 무조건 방문처리 돼있음, 가장 왼쪽 위는 시작됨
						idx = (++idx) % 3; // 다음 idx 보렴, 2 -> 0, 다시 하로
						row = row + 1 + dr[idx]; // 여긴 방문처리 했던 곳 까지 왔으니까, 대각선 아래로 가야함
						col = col + 1 + dc[idx]; // 마찬가지
						arr[row][col] = ++cnt; // 갈 곳 더해주기
					} else {
						arr[row][col] = ++cnt;
					}
				}
			} // end while
				// 전체 개수만큼 만들고
			int[] answer = new int[totalSize];
			int num = 0;
			for (int i = 0; i < n; i++) { // 0, 1, 2, 3
				for (int j = 0; j <= i; j++) { // 0, 0~1, 0~2, 0~3
					answer[num++] = arr[i][j];
				}
			}
			return answer;
		}
	}
}
