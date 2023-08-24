package BOJ_220213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2751_수정렬하기2시간초과 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력 받기 : 총 수 n
		int n = Integer.parseInt(br.readLine());
		// 입력을 넣을 배열 : arr
		ArrayList<Integer> arr = new ArrayList<>();
		// 배열 값 넣기. + 바로 최댓값. 최솟값 찾기(음수인 경우도 있어서)
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		br.close();

		Collections.sort(arr);
		for (int value : arr) {
			sb.append(value).append("\n");
		}
		System.out.println(sb);
	}

}
