package aps_220329;

import java.util.Scanner;

public class SWEA_2930_힙 {
	public static void main(String[] args) {
		// 키 값이 자식노드이 키 값보다 항상 크거나 같은 힙을 최대 힙
		// 부모노드의 키 값이 자식노드의 키값보다 항상 작거나 같은 힙을 '최소 힙'
		// 완전 이진 트리 : 노드 1번부터 n번까지 빈 자리가 없음(왼쪽까지 채워짐)
		// 최소, 최대 힙 자체가 완전 이진 트리라고!! => 그냥배열로 인덱스를 활용해 할 수 있음

		Scanner sc = new Scanner(System.in);
		// 최대 힙을 구현해보자!!!
		StringBuilder sb = new StringBuilder();
		int size;

		int testCase = sc.nextInt();

		for (int tc = 1; tc <= testCase; tc++) {
			sb.append("#" + tc + " ");
			// testCase별 heap 초기화
			int[] heap = new int[1000000];
			// 사이즈 초기화
			size = 0;
			// 명령어 개수
			int N = sc.nextInt();

			for (int i = 0; i < N; i++) {
				// 연산
				int operator = sc.nextInt();

				// 연산 1, 넣기
				if (operator == 1) {
					// 일단 넣고
					heap[++size] = sc.nextInt();
					// 넣은 인덱스 확인
					int now = size;

					// 1. 루트 노드를 만날 때 까지
					while (now / 2 != 0) {
						// 여기서부터 부모 노드 찾아가면서,
						int parentIdx = now / 2;
						// 자식 노드가 부모 노드보다 크다면
						if (heap[now] > heap[parentIdx]) {
							// 바꿔주고 : swap
							int temp = heap[parentIdx];
							heap[parentIdx] = heap[now];
							heap[now] = temp;
							// 이제 부모 노드를 자식으로 생각해서
							// 해당 노드의 부모보다 큰지 작은지 확인
							now = parentIdx;
						} else {
							// 2. 부모 노드가 자식보다 더 큰 경우엔 break
							break;
						}
					}
					// System.out.println(Arrays.toString(heap));
					// System.out.println("size : " + size);
				} // end if : 삽입 연산

				// 연산 2인 경우,
				else {
					// 일단 비어있는지 확인 (size != 0)
					if (size == 0) {
						// 비어있으면 stringbuilder에 append -1
						sb.append("-1 ");
					}
					// 비어있지 않으면
					else {
						// stringbuilder에 append heap[1]

						sb.append(heap[1] + " ");
						heap[1] = heap[size--];
						// 최댓값 비교를 위해, 원래 값을 0으로..
						heap[size + 1] = 0;

						// 여기서부터 규칙 적용인데
						int now = 1;
						// 자식의 최대값 인덱스
						int maxIdx = 0;
						// size보다 idx가 크면 안 되니까..

						while (true) {
							// heap[1] < 왼자(*2) 오른자(*2 + 1)
							if (heap[now * 2] > heap[now * 2 + 1]) {
								maxIdx = now * 2;
							} else {
								maxIdx = now * 2 + 1;
							}
//							System.out.println("now : " + now + " heap[now] " + heap[now] + " maxIdx : " + maxIdx
//									+ " heap[maxIdx] : " + heap[maxIdx]);
							// 중 큰 값과 swap
							if (heap[maxIdx] > heap[now]) {
								// swap
								int temp = heap[maxIdx];
								heap[maxIdx] = heap[now];
								heap[now] = temp;
								// 이제, 자식으로 가야하니
								now = maxIdx;

							}
							// 만약 현재 값이 자식의 최대값보다 크다면, 그만!
							else {
								break;
							}

						} // end while : 규칙 적용

					} // end if : 삭제 연산 중, 비어있지 않은 경우

				} // end else : , 삭제 연산

			} // end for : 1개의 testCase 종료
			sb.append("\n");

		} // end testCase
		System.out.println(sb);
	}
}
