package aps_220411_graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 그래프04_크루스칼 {

	static int[] p;

	public static void main(String[] args) {

		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // 정점의 갯수인데 0부터 들어온다
		int E = sc.nextInt(); // 간선의 개수

		// 간선 배열을 이용해서 저장을 해야해
		int[][] edges = new int[E][3];

		for (int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt(); // [0] 시작점
			edges[i][1] = sc.nextInt(); // [1] 끝점
			edges[i][2] = sc.nextInt(); // [2] 가중치
		} // 입력 끝

		// 간선을 가중치로 오름차순 정렬을 해야해..
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2]; // 오름차순
			}
		});

		p = new int[V];
		for (int i = 0; i < V; i++) {
			makeSet(i);
		}
		int ans = 0;

		// mst 만들기

		// 간선을 N-1개 선택하면 break;
		// Union을 손대면 어떨까
		int pick = 0;
		for (int i = 0; i < E; i++) {
			int px = findSet(edges[i][0]);
			int py = findSet(edges[i][1]);

			if (px != py) {
				union(px, py);
				ans += edges[i][2];
			}

		}

		System.out.println(ans);

	}

	static int findSet(int x) {
		// if(x == p[x]) return x;
		// return p[x] = findSet(p[x]); // 오른쪽을 하고 나오기 떄문에 press compressio 가능
		if (p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];

		// 결국 부모는 ,가장 나중에 나온 값을 받고 싶으니까!
	}

	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}

	static void makeSet(int x) {
		p[x] = x;
	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "4 6 51\r\n" + "5 3 18\r\n" + "5 4 40\r\n";
}
