package aps_220413;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_1251_하나로_크루스칼 {
	static int N; // 섬의 개수
//	static int [][] XY; // [0] X좌표모음, [1]Y좌표모음
	static int[] X, Y;
	static double E; // 세율
	static double ans; // 정답

	static int[] p; // 내 대표를 저장할 배열

	static class Edge implements Comparable<Edge> {
		int st, ed;
		double cost;

		public Edge(int st, int ed) {
			this.st = st;
			this.ed = ed;
			this.cost = distance(st, ed);
		}

		@Override
		public int compareTo(Edge o) {

			return (this.cost > o.cost) ? 1 : -1;
		}
	}

	static PriorityQueue<Edge> pq = new PriorityQueue<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			X = new int[N]; // x좌표모음
			Y = new int[N]; // y좌표모음
			p = new int[N]; // 대표

			ans = 0;
			pq.clear();
			for (int i = 0; i < N; i++) {
				X[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				Y[i] = sc.nextInt();
			}

			E = sc.nextDouble();

			// makeSet
			for (int i = 1; i < N; i++) {
				p[i] = i;
			}

			// 간선을 몽땅 만들어서 죄다 pq에 넣자.
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					pq.add(new Edge(i, j));
				}
			}
			// 크루스칼스, 갠선 N-1개 간선 뽑아야해
			for (int i = 0; i < N - 1; i++) {
				while (true) {
					Edge edge = pq.poll();
					int px = findSet(edge.st);
					int py = findSet(edge.ed);

					if (px != py)
						unionSet(px, py);
					ans += edge.cost;
					break;
				}
			}
			
			System.out.println("#" + tc + " "+ Math.round(ans));

		} // tc
	}

	static int findSet(int x) {
		if (p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];
	}

	static void unionSet(int x, int y) {
		p[y] = x;
	}

	static double distance(int idx1, int idx2) {
		// 두 개의 좌표를 이용해 가중치를 구함
		return (Math.pow(Math.abs(X[idx1] - X[idx2]), 2) + Math.pow(Math.abs(Y[idx1] - Y[idx2]), 2)) * E;
	}
}
