package aps_220412;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SWEA_1251_하나로 {

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		double money;

		public Edge(int start, int end, double money) {
			this.start = start;
			this.end = end;
			this.money = money;
		}

		// 비교 기준, 내가 더 커? 뒤로!
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return (int) (this.money - o.money);
		}

	}

	static int[] p; // 부모 저장
	static List<Edge> list; // Edge들을 저장할 ArrayList
	static int N; // 사이즈
	static double E; // 환경 부담 세율
	static double ans; // 정답을 저장할 숫자
	static int[][] islands; // is the 섬s

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt(); // N 입력 받고
			islands = new int[N][2]; // 섬들 만들고
			list = new ArrayList<>(); // 배열도 초기화

			for (int i = 0; i < N; i++) {
				islands[i][0] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				islands[i][1] = sc.nextInt();
			}
			E = sc.nextDouble();
			// 조합 : 쉽게쉽게가자
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					double money = Math.pow((islands[i][0] - islands[j][0]), 2);
					money += Math.pow((islands[i][1] - islands[j][1]), 2);
					list.add(new Edge(i, j, money)); // 여기서 list에 더해준다

				}
			} // 넣기 완료
			Collections.sort(list); // Overriding한 Comparable로 정렬해줭~
			// 부모 만들고, makeSet
			p = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}

			ans = 0;
			int cnt = 0;
			int idx = 0;
			// 참일 떄 까지
			while (true) {
				Edge now = list.get(idx); // edge 하나 빼서
				int left = findSet(now.start); 
				int right = findSet(now.end);
				if (left != right) { // 다르면
					unionSet(left, right); // 합집합
					ans += now.money;  // 그 값 더해주고
					idx++; // 인덱스 올려주고
					cnt++; // 카운트 올려
					if (cnt == N - 1) // 노드의 수 - 1 만 큼 되면 끝내.
						break;
				} else
					idx++;

			}
			// 왜인진 모르겠으나 제일 나중에 소수를 곱해줘야 잘 되는거같아..
			sb.append("#").append(tc).append(" ").append(Math.round(ans*E)).append("\n");

		} // end testCase
		System.out.println(sb);

		// makeset
	} // end main

	static int findSet(int idx) {
		if (p[idx] != idx)
			p[idx] = findSet(p[idx]);
		return p[idx];
	}

	// unionSet
	static void unionSet(int l, int r) {
		int pl = findSet(l);
		int pr = findSet(r);
		p[pr] = pl;
	}

}
