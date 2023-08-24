package aps_220411_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 그래프02_인접리스트 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// V = 6이 들어올건데, 0~6번까지의 정점을 주겠음. 그러면 V+1개
		int V = sc.nextInt(); // 정점의 시작 번호는 무엇인지, 총 몇개인지 문제를 잘 보자
		int E = sc.nextInt();

		List<Integer>[] adjList = new ArrayList[V + 1];
		
		// 각각의 ArrayList를 new 해주자, 지금은 껍덱스밖에..
		for(int i=0; i < V+1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			// 유향 저장
			adjList[st].add(ed);
			// 무향이라면
			adjList[ed].add(st);

		}
		for (int i = 0; i <= V; i++) {
			System.out.print(i +": ");
			for (int j = 0; j < adjList[i].size(); j++) {
				System.out.print(adjList[i].get(j) + " ");
			}
			System.out.println();
		}

	}
}
