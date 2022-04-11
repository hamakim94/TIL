package aps_220411_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3289_서로소집합 {

	static int N, M; // 집합의 개수 , 연산의 수
	static int[] p; // 나의 근본을 찾아서

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			p = new int[N + 1];
			// makeSet
			for (int i = 0; i <= N; i++)
				p[i] = i;

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int operator = Integer.parseInt(st.nextToken());
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				
				if(operator == 0) {
					unionSet(left,right);
				} else {
					// 같이 들어있니?
					if(findSet(left) == findSet(right))
						sb.append(1);
					else
						sb.append(0);
				}
			} sb.append("\n");
			System.out.println(Arrays.toString(p));

		} // end tc
		System.out.println(sb);
	} // end main

	// 만들거 makeset
	// findSet

	public static int findSet(int idx) {
		if (p[idx] != idx) // 차근차근 올라가면서 루트 노드 접근하게 하기
			return p[idx] = findSet(p[idx]);
		return p[idx]; // 난 이 값이 필요하니까.
	}

	// unionSet
	public static void unionSet(int x, int y) {

		int px = findSet(x);
		int py = findSet(y);
		if (px != py)
			p[findSet(y)] = findSet(x);

	}

}
