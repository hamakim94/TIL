package BOJ_220505;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리 {
	// 문제 형태를 보아하니
	// 8*8 이 주어지면, 일단 모두 같은지 체크
	// 모두 같으면 그냥 숫자 하나가 돼!
	// 만약 다른게 하나라도 존재해 => 괄호 열어~
	// 4*4(왼위) 4*4(오위) 4*4(왼아래) 4*4(오위) 나눠
	// 다른게 하나라도 존재해~
	// 괄호 열어~
	// 2*2(왼위) 2*2(오위) 2*2(왼아래) 2*2(오위) 나눠 => 2*2가 가장 작은 단위,
	// 다 같아? 그냥 그 숫자 써!
	// 2*2까지 갔는데 다른게 하나라도 존재해?
	// 괄호 열고 그냥 써

	static char[][] arr;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 자료의 크기,

		arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		} // end for : 배열 입력 완료
		quadTree(0, 0, N);
		System.out.println(sb);
	}

	// 재귀를 써야할 듯 싶다
	static void quadTree(int row, int col, int size) {
		// 현재 내 시작행, 시작열, 사이즈를 가지고 for문 돌며, 다 같은지 체크
		boolean check = true;
		for (int r = row; r < row + size; r++) {
			for (int c = col; c < col + size; c++) {
				if (arr[row][col] != arr[r][c]) {
					// 시작점이랑 달라? 끝내고 나와
					check = false;
					break;
				}
			}
		}
		// 다 돌았는데, 여전히 true라면 sb에 그냥 더해주고.
		if (check) {
			sb.append(arr[row][col]);
			return;
		}
		// 아닌 경우
		else {
			// size가 2이면(base case) 그냥 sb에 괄호열고 4개 넣어줌 - 왼위, 우위, 왼아, 오아 순
			if (size == 2) {
				sb.append('(');
				for (int r = row; r < row + size; r++) {
					for (int c = col; c < col + size; c++) {
						sb.append(arr[r][c]);
					}
				}
				sb.append(')');
				// 끝내줘, 2칸이니까
				return;
				// size가 2가 아니면!!!
			} else {
				// 괄호 열고, 4번 재귀 더 돌으렴
				sb.append('(');
				quadTree(row, col, size / 2);
				quadTree(row, col + size / 2, size / 2);
				quadTree(row + size / 2, col, size / 2);
				quadTree(row + size / 2, col + size / 2, size / 2);
				sb.append(')');
			}

		}

	}

}
