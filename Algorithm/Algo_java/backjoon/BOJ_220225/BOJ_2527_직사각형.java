package BOJ_220225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_2527_직사각형 {
	public static void main(String[] args) throws IOException {
		// 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test = 0; test < 4; test++) {
			String[] squares = br.readLine().split(" ");
			// 좌표 입력받기
			int sq1Row1 = Integer.parseInt(squares[0]);
			int sq1Col1 = Integer.parseInt(squares[1]);
			int sq1Row2 = Integer.parseInt(squares[2]);
			int sq1Col2 = Integer.parseInt(squares[3]);
			int sq2Row1 = Integer.parseInt(squares[4]);
			int sq2Col1 = Integer.parseInt(squares[5]);
			int sq2Row2 = Integer.parseInt(squares[6]);
			int sq2Col2 = Integer.parseInt(squares[7]);
			
			// 겹친 행, 열의 좌표를 담을 집합
			HashSet<Integer> setRows = new HashSet<>();
			HashSet<Integer> setCols = new HashSet<>();
			// 행열을 한 번에 처리하면, 크기가 너무 커져서 행,열 따로 생각함
			int[] rows = new int[50001];
			int[] cols = new int[50001];
			
			// 1번 사각형 행의 좌표에 1 넣어줌
			for(int i = sq1Row1; i <= sq1Row2; i++) {
				rows[i] = 1;
			}
			// 2번 사각형 행을 돌면서, 이미 들어가 있다면, 그 좌표를 집합에 넣어
			for(int i=sq2Row1; i<=sq2Row2; i++) {
				if (rows[i] == 1) {
					setRows.add(i);
				}
			}
			// 1번 사각형 열의 좌표에 1 넣어줌
			for(int i = sq1Col1; i <= sq1Col2; i++) {
				cols[i] = 1;
			}
			// 2번 사각형 열을 돌면서, 이미 들어가 있다면, 그 좌표를 집합에 넣어
			for(int i=sq2Col1; i<=sq2Col2; i++) {
				if (cols[i] == 1) {
					setCols.add(i);
				}
			}
			// 만약 겹친 행 좌표, 열 좌표의 길이가 모두 2 이상이면 직사각형이고
			// 하나는 1인데, 나머지가 2 이상이면 선분
			// 만약 둘 다 1이면 그냥 점
			// 그 외는 안 겹침
			if(setRows.size() >= 2 && setCols.size() >= 2) {
				System.out.println("a");
			} else if(setRows.size() == 1 && setCols.size() >= 2) {
				System.out.println("b");
			} else if (setRows.size() >= 2 && setCols.size() == 1) {
				System.out.println("b");
			} else if (setRows.size() == 1 && setCols.size() == 1) {
				System.out.println("c");
			} else {
				System.out.println("d");
			}
		}
	}
}
