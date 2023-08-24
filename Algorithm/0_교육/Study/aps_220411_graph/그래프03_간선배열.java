package aps_220411_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 그래프03_간선배열 {

	static class Edge {
		int st;
		int ed;

		public Edge(int st, int ed) {
			super();
			this.st = st;
			this.ed = ed;
		}

		@Override
		public String toString() {
			return "Edge [st=" + st + ", ed=" + ed + "]";
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// V = 6이 들어올건데, 0~6번까지의 정점을 주겠음. 그러면 V+1개
		int V = sc.nextInt(); // 정점의 시작 번호는 무엇인지, 총 몇개인지 문제를 잘 보자
		int E = sc.nextInt();

		Edge[] edges = new Edge[E];

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			// 유향 저장
			edges[i] = new Edge(st, ed);
			// 무향이라면
			System.out.println(edges[i]);

		}

	}
}
