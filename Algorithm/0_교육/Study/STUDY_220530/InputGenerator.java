package STUDY_220530;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Iterator;

public class InputGenerator {
	// N : 지도의 한 변의 길이 4 <= N <= 50
	// set을 사용을 해서 중복을 줄이고, Math.random을 이용해서 좌표의 값을 넣기로 생각했다
	// M : 사람 수, 0 < M <= N*N
	// 사람들의 좌표 0<= 좌표 < N, 단 (0,0)에는 사람이 들어가지 않음
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int testCase = 50;
		sb.append(testCase).append('\n');
		for (int t = 0; t < testCase; t++) {
			int N = (int) (Math.random() * 47) + 4; // 4~50
			int M = (int) (Math.random() * N * N) + 1;
			// 0과 N-1 사이의 수들이 있고 이게 M개 있고, 겹치지 않아야 좌표가 생성된다.
			HashSet<String> avoidDuplicate = new HashSet<>(); // 중복 제거를 위한 HashSet
			int cnt = 0;// 총 M개의 사람 좌표 필요, M까지 가기 위한 변수
			while (cnt < M) {
				int r = (int) (Math.random() * N);
				int c = (int) (Math.random() * N);
				if (r == 0 && c == 0) // 0,0이면 안 돼
					continue;
				String coordinate = r + "/" + c; // 좌표와 열의 중복을 막기 위해 String으로 뭉치고 생각
				// 기존 좌표가 좌표가 들어있는 문자열을 포함하지 않으면
				if (!avoidDuplicate.contains(coordinate)) {
					cnt++; // 숫자를 증가시키고
					avoidDuplicate.add(coordinate); // 하나씩 출발
				}
			} // 총 M개 처리 완료
			int[][] arr = new int[N][N]; // 지도를 만들기 위한 배열
			Iterator<String> it = avoidDuplicate.iterator(); // HashSet 순회를 위한 iterator
			int index = 1; // 우선순위를 부여하는 숫자
			while (it.hasNext()) {
				String[] now = it.next().split("/"); // 문자열을 /를 기준으로 split해서 행과 열 좌표를 구한다
				int row = Integer.parseInt(now[0]);
				int col = Integer.parseInt(now[1]);
				arr[row][col] = index++;
			}
			// StringBuilder를 활용해서 문자열로 뽑기
			sb.append(N).append(' ');
			sb.append(M).append('\n');
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (j != N - 1)
						sb.append(arr[i][j]).append(' ');
					else {
						sb.append(arr[i][j]).append('\n');
					}
				}
			}
		}
		// 파일로 만들기
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter("E:\\sample_input.txt", true));
			fw.write(sb.toString());
			fw.flush();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
