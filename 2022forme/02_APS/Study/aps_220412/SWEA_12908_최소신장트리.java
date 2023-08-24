package aps_220412;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SWEA_12908_최소신장트리 {
	// 프루스칼 - is the 갠선
	// left, right , value받는 배열을 만들고
	// is the comparable/comparator로 오름차순
	// 갠선 모임들에에서 반복문을 돌면서
	// left,right에 각각 findSet
	// 같니? -> 하지마
	// 다르니 -> 합치고 누적합에 더해
	// N-1개의 간선이 선택될 때 까지 돌리면 된다.

	static int V, E;// V+1개의 노드, E개의 갠선
	static int[] p; // 부모 저장
	static int[][] edges; // 갠선 저장
	static int ans; // 정답
	static int cnt; // V-1개까지가!

	public static void main(String[] args) {
		// 0번부터 V번노드까지있는거야~
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// 출력을 위함
			sb.append("#").append(tc).append(" ");

			V = sc.nextInt();
			E = sc.nextInt();
			p = new int[V + 1];

			// makeSet
			for (int i = 0; i <= V; i++)
				p[i] = i;

			edges = new int[E][3];

			for (int i = 0; i < E; i++) {
				edges[i][0] = sc.nextInt();
				edges[i][1] = sc.nextInt();
				edges[i][2] = sc.nextInt(); // 가중치

			} // 입력 완료

			Arrays.sort(edges, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[2] - o2[2];
				}
			});
			int idx = 0; // while문을 돌 idx
			cnt = 0; // 선택된 간선의 개수
			ans = 0; // 갑들 더할 변수

			while (true) {
				int pLeft = findSet(edges[idx][0]);
				int pRight = findSet(edges[idx][1]);
				int value = edges[idx][2];
				// left right의 부모가 다른 경우만 합치고 수 더해
				if (pLeft != pRight) {
					ans += value;
					unionSet(pLeft, pRight);
					cnt++;
					idx++;
					if(cnt == V) // 노드 V+1개, 간선 V개면 끝!
						break;
				} else {
					idx++;
				}
			} // 끝
			sb.append(ans).append("\n");

		} // end testCase
		System.out.println(sb);
	}

	// 필요한 함수 2개
	// findSet,unionSet
	static int findSet(int idx) {
		if (p[idx] != idx)
			p[idx] = findSet(p[idx]);
		return p[idx];
	}

	// unionSet
	static void unionSet(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		p[py] = px;
	}

}
