package aps_220413;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra_우선순위큐 {

	static class Node implements Comparable<Node> {

		int v, weight;

		public Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}

	}

	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static List<Node>[] adjList; // 인접 리스트
	static int[] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt(); // 0번부터..!
		E = sc.nextInt();

		adjList = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();

		}

		dist = new int[V];
		Arrays.fill(dist, INF);

		// 간선 입력
		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();
			adjList[st].add(new Node(ed, w)); // 인접 리스트 넣기 // 유향
		}

		dijkstra(0);

		System.out.println(Arrays.toString(dist));

	}

	static void dijkstra(int st) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(st, 0));
		// 박문철이
		boolean[] visited = new boolean[V];

		// 시작 노드까지의 거리는 0;
		dist[st] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll(); // 하나 꺼내.
			// 짜피 최소힙이니까, 최소값 출력할 필요가 없어
			if (visited[curr.v])
				continue;
			visited[curr.v] = true;

			// 뽑은 curr으로부터 출발해서 연결되는거 싸라락 비교..?
			for (Node node : adjList[curr.v]) {
				// 이미 알고있는 거리보다 더 가깝게 도달할 수 있다면
				if (dist[node.v] > dist[curr.v] + node.weight) {
					dist[node.v] = dist[curr.v] + node.weight;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}

		}

	}

}
