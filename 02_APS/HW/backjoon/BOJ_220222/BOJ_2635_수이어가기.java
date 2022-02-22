package BOJ_220222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_2635_수이어가기 {
	public static void main(String[] args) throws IOException {
		// Brute Force라고 생각하기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		// 수를 저장할 배열 생성
		ArrayList<Integer> arr;
		ArrayList<Integer> maxArr = new ArrayList<>(); // 최대 길이를 저장하는 배열 생성
		// 최대 count 저장할 변수
		int maxCnt = Integer.MIN_VALUE;
		// n과 같은 사이즈에서 1씩 빠지면서 돈다
		for (int i = n; i > 0; i--) {
			arr = new ArrayList<>();
			arr.add(n); // 기존 값 추가
			arr.add(i); // i 값 추가
			// while문을 돌 새 변수 선언
			int t = 0; 
			while (arr.get(t) - arr.get(t + 1) >= 0) {
				arr.add(arr.get(t) - arr.get(t + 1));
				t++;

			} //최대길이 찾고, 그 배열 저장하기
			if (arr.size() > maxCnt) {
				maxCnt = arr.size();
				maxArr = arr;
			}
		}
		// 출력
		sb.append(maxCnt).append("\n");
		for(int i=0; i<maxArr.size(); i++) {
			sb.append(maxArr.get(i)).append(" ");
		}
		System.out.println(sb);

	}
}
