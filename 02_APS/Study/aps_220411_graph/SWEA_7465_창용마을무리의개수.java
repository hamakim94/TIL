package aps_220411_graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class SWEA_7465_창용마을무리의개수 {

	static int N, M; // N : 사람의수(노드), M 관계수(간선)
	static int[] p; // 대표를 가리키는 배열
	static int[] rank; // 랭크를 저장하는 배여
	static HashSet<Integer> toCnt;
	public static void main(String[] args) {

		// 총 3가지 단계를 만들어야 한다.
		// N+1 만큼 배열을 만들어[make-set]
		// 대표찾는 메또드 만들어[find-set]
		// 합치는 메또드 만들어(union-set(a,b))

		// 입력 받기
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();

			makeSet(N); // p 완성

			for (int i = 0; i < M; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				// 각 입력이 유니온이야
				unionSet(start, end);
			}
			
			// 대표자 최신화
			for(int i=1; i <= N; i++) {
				findSet(i);
			}
			
			// 부모의 개수를 세면 되는거 아냐?
			toCnt = new HashSet<>();
			for(int i=1; i <=N; i++) {
				toCnt.add(p[i]);
			}
			//System.out.println(Arrays.toString(p));
			System.out.println("#" + tc + " " + toCnt.size());

		}

	}

	private static void makeSet(int N) {
		// 기본 배열 만들어줘
		p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
		rank = new int[N+1];

	}
	// path compression,
	// Find-Set을 행하는 과정에서, 만나는 모든 노드들이 직접 root를 가리키도록 포인터를 바꿔
	private static int findSet(int idx) {
		
		if (p[idx] != idx)
			return p[idx] = findSet(p[idx]);
		return p[idx];
	}
	
	private static void unionSet(int x, int y) {
		// 각각 최상위 노드의 랭크를 계산해서, 넣어주겠다
		link(findSet(x), findSet(y));
	}
	// x의 대표의 자릴 찾아 . y의 대표 자리에 넣어!, 근디 이게 양측이네 ㅠㅠ
	private static void link(int x, int y) {
		
		// x기준, x가 더 커야해
		if(rank[x] > rank[y])
			p[y] = x;
		
		else {
			// 그 반대는 거꾸로 연결시키고
			p[x] = y; 
			// 랭크가 같다면, y의 크기 + 1;
			if(rank[x] == rank[y])
				rank[y]++;
		}
	}
}
