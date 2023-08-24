package aps_220411_graph;

import java.util.Arrays;
import java.util.Scanner;

public class 그래프01_인접행렬 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// V = 6이 들어올건데, 0~6번까지의 정점을 주겠음. 그러면 V+1개
		int V = sc.nextInt(); // 정점의 시작 번호는 무엇인지, 총 몇개인지 문제를 잘 보자
		int E = sc.nextInt();
		
		int[][] adjArr = new int[V+1][V+1];
		
		for(int i=0; i<E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			// 유향 저장
			adjArr[st][ed] = 1;
			// 무향이라면
			adjArr[ed][st] = 1;
		}
		for(int i=0; i <= V; i++) {
			System.out.println(Arrays.toString(adjArr[i]));
		}
		
	}
}
