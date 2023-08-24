package BOJ_220216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244_스위치켜고끄기 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] arr = new int[n + 1]; // 인덱스로 바로 받기 위해서
		arr[0] = 3; // 혹시 여성, 좌우탐색 할 때 오류가 날 수 있으므로
		// 입력
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int num = Integer.parseInt(br.readLine()); // 케이스 수;
		// 또 입력받을 내용
		int a;
		int b;
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			// arr을 바꿔주는 함수
			arr = change(arr, a, b);
		}
		// 뽑기
		for (int i = 1; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}

		}

	}

	// 배열을 받고, 남성,여성을 판별하는 a, 인덱스 위치를 받는 b
	public static int[] change(int[] array, int a, int b) {
		// while문을 돌려서, index 범위를 확인하기 위한 idx
		int idx;

		// 남성
		if (a == 1) {
			idx = 1;
			// 만약 b*idx가 3의 배수고,
			while (idx * b <= array.length - 1) {
				// 바꿔주고, idx ++
				array[b * idx] = array[b * idx] == 0 ? 1 : 0;
				idx++;
			}
		} else {

			idx = 1;
			// 일단 거기 채워
			array[b] = array[b] == 0 ? 1 : 0;

			while (b - idx >= 1 && b + idx <= array.length - 1 && array[b - idx] == array[b + idx]) {
				// 만약 범위 안에 있고, b-idx, b+idx 값이 같다면, 바로 바꿔!

				array[b - idx] = array[b - idx] == 0 ? 1 : 0;
				array[b + idx] = array[b + idx] == 0 ? 1 : 0;
				idx++; // 다음 범위 확인
			}

		}

		return array; // 해당 배열 반환
	}
}
