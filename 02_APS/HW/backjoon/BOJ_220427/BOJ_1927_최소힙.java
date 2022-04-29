package BOJ_220427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1927_최소힙 {

	static long[] heap; // 0부터 시작하는 힙
	static int curr = 0; // 현재 인덱스를 나타냄

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		heap = new long[100001];
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			// 3가지 경우
			if (input > 0) {
				heap[++curr] = input; // 일단 넣고
				int n = curr; // 현재 인덱스 보면서
				while (n != 1 && heap[n] < heap[n / 2]) { // 부모보다 작으면 swap
					// swap
					swap(n, n / 2);
					n /= 2;
				}

			} else {
				if (curr == 0) { // 배열이 빈 경우
					sb.append(0).append("\n");
				} else {
					// 맨 위에 있는거 출력
					sb.append(heap[1]).append("\n");
					// 맨 끝에꺼 맨 앞에 두고 아래비교비교
					heap[1] = heap[curr];
					curr--; // 하나 뺐으니 현재 위치 - 1
					int n = 1;
					while (true) {
						int minidx = 0;
						if(n*2 > curr) break; // 만약 자손이 현재 갖고 있는 값보다 크면 못해
						// 둘중 더 작은 값 찾기
						if (heap[2 * n] < heap[2 * n + 1])
							minidx = 2 * n;
						else
							minidx = 2 * n + 1;
						// 부모가 자식보다 크면!
						if (heap[n] > heap[minidx]) {
							swap(n, minidx);
							n = minidx;
						} else {
							break;
						}
					}
				}

			}
		} // end for
		System.out.println(sb);

	} // end main

	static void swap(int i, int j) {
		long temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
}
