package BOJ_220216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2477_참외밭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st;
		// 6 길이의 배열
		// 홀수번째의 최댓값, 짝수번째의 최댓값을 입력을 받으며 구한다
		// 심지어 인덱스도 저장

		int[] arr = new int[6];
		int maxIdxOdd = Integer.MIN_VALUE;
		int maxIdxEven = Integer.MIN_VALUE;
		int maxOdd = Integer.MIN_VALUE;
		int maxEven = Integer.MIN_VALUE;
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			// 두 번쨰 입력만 받을거야
			st.nextToken();
			arr[i] = Integer.parseInt(st.nextToken());
			// 가로,세로의 최대값은  ㄱ자 모양에 따라 인접할 수 밖에 없음
			if (i % 2 == 0) {
				if (maxEven < arr[i]) {
					maxEven = arr[i];
					maxIdxEven = i;
				}
			} else {
				if (maxOdd< arr[i]) {
					maxOdd = arr[i];
					maxIdxOdd = i;
				}
			}
		} // end for : 입력과 짝수, 홀수번째 최대값 인덱스 받음
		
		// 3칸씩만 앞으로 가면, 작은 사각형 값이 나와
		int minIdxEven = (maxIdxEven + 3)%6;
		int minIdxOdd = (maxIdxOdd + 3)%6;
		
		System.out.println( k*(arr[maxIdxEven]*arr[maxIdxOdd] - arr[minIdxEven]*arr[minIdxOdd]));
	}
}
