package aps_220412;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SWEA_1251_하나로실패 {
	static long N; // 섬의 개수
	static long[][] islands;
	static double E; // 세수
	static List<long[]> edges; // 간선들 모아놓을 것
	static long[] forComb, p; // 조합을 위한 배열, 부모 노드
	static boolean[] visited;
	static long ans; // 최소값

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			visited = new boolean[(int)N];
			islands = new long[(int)N][2]; // [ [0,0] [0,100] [400 0] [400 100] ]

			for (int j = 0; j < N; j++)
				islands[j][0] = sc.nextLong(); // r좌표
			for (int j = 0; j < N; j++)
				islands[j][1] = sc.nextLong(); // c좌표
			ans = 0;
			E = sc.nextDouble();
			edges = new ArrayList<>();
			forComb = new long[2];
			// 이제 조합을 짜면서, 간선 구해야해

			comb(0, 0);
			// 크기 순 조합 완료
			Collections.sort(edges, new Comparator<long[]>() {

				@Override
				public int compare(long[] o1, long[] o2) {
					// TODO Auto-generated method stub
					return (int) (o1[2] - o2[2]);
				}
			});
			// makeSet
			p = new long[(int)N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}
			//
			int cnt = 0;
			int idx = 0;
			while (true) {
				long[] now = edges.get(idx);
				long pFirst = findSet((int) now[0]);
				long pSecond = findSet((int) now[1]);
				if (pFirst != pSecond) {
					unionSet((int) pFirst, (int) pSecond);
					ans += now[2];
					cnt++;
					idx++;
					if (cnt == N - 1)
						break;
				}
				idx++;
			}
			
			System.out.println(Math.round(ans*E));

		} // end testCase

	} // end main
		// findSet

	static long findSet(long idx) {
		if (p[(int)idx] != idx)
			p[(int)idx] = findSet(p[(int)idx]);
		return p[(int)idx];
	}

	// unionSet
	static void unionSet(long l, long r) {
		int pl = (int) findSet(l);
		int pr = (int) findSet(r);
		p[pr] = pl;
	}

	// 두 점 거리 구하기 : 인풋 : 인덱스들 0, 1 등
	static long calcDist(int idx1, int idx2) {
		long sum = 0;
		sum += (islands[idx1][0] - islands[idx2][0]) * (islands[idx1][0] - islands[idx2][0]);
		sum += (islands[idx1][1] - islands[idx2][1]) * (islands[idx1][1] - islands[idx2][1]);
		return sum;
	}

	// 조합 구해서 만들기
	static void comb(int L, int start) {
		if (L == 2) {
			//System.out.println(Arrays.toString(forComb));
			long[] arr = { forComb[0], forComb[1], calcDist((int)forComb[0], (int)forComb[1]) };
			edges.add(arr);
			return;
		}

		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				forComb[L] = i;
				visited[i] = true;
				comb(L + 1, i);
				visited[i] = false;
			}
		}

	}

}
