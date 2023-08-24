package aps_220413;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Dijkstra {

	static class Node {

		int v, weight;

		public Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
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
		// 박문철이
		boolean[] visited = new boolean[V];

		// 시작 노드까지의 거리는 0;
		dist[st] = 0;
		
		// V까지 도는거, V-1까지 도는것에 대한 차이를 진하게 생각해 보자..
		for (int i = 0; i < V - 1; i++) {
			int minidx = -1;
			int minValue = INF;
			
			// 선택하지 않은 정점 중 dist가 가장 짧은것을 골라..
			for(int j=0; j<V; j++) {
				if(!visited[j] && minValue > dist[j]) {
					minValue = dist[j];
					minidx = j;
				}
			}
			
			if(minidx == -1) break; // 연결되지 않은 경우가 있으므로..
			
			visited[minidx] = true;
			
			for(int j=0; j < adjList[minidx].size(); j++) {
				Node cur = adjList[minidx].get(j);
				// 연결되었으면서 방문하지 않았고 이미 가지고있는값과 지금값 + 이동한 값을 더한값이 더 작다면 갱신
				if(!visited[cur.v] && dist[cur.v] > dist[minidx] + cur.weight ) {
					dist[cur.v] = dist[minidx] + cur.weight;
				}
			}
			
		}

	}
	

}
