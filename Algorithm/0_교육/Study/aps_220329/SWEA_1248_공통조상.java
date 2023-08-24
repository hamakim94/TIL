package aps_220329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1248_공통조상 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 입력값 4개
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());

			// 정점의 총 수
			int V = Integer.parseInt(st.nextToken());
			// 간선의 수
			int E = Integer.parseInt(st.nextToken());
			// 원하는 정점 번호 1
			int leaf1 = Integer.parseInt(st.nextToken());
			// 원하는 정점 번호 2;
			int leaf2 = Integer.parseInt(st.nextToken());

			// 입력값을 넣을 2차원 배열,
			ArrayList<int[]> arr = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int[] now = new int[2];
				now[0] = Integer.parseInt(st.nextToken());
				now[1] = Integer.parseInt(st.nextToken());
				arr.add(now);
			}
			// 루트 노드들 정리하는거

			ArrayList<Integer> leaf1Parent = new ArrayList<>();
			ArrayList<Integer> leaf2Parent = new ArrayList<>();

			int bornToBeParent = leaf1;
			while (bornToBeParent != 1) {
				for (int[] now : arr) {
					if (now[1] == bornToBeParent) {
						leaf1Parent.add(now[0]);
						bornToBeParent = now[0];
						break;
					}
				}
			}
			//System.out.println(leaf1Parent.toString());

			bornToBeParent = leaf2;
			while (bornToBeParent != 1) {
				for (int[] now : arr) {
					if (now[1] == bornToBeParent) {
						leaf2Parent.add(now[0]);
						bornToBeParent = now[0];
						break;
					}
				}
			}
			//System.out.println(leaf2Parent.toString());


			int ans1 =0;
			int maxIdxLeaf1 = leaf1Parent.size() - 1;
			int maxIdxLeaf2 = leaf2Parent.size() - 1;
			while (maxIdxLeaf1>= 0 && maxIdxLeaf2 >= 0) {
				//System.out.println(maxIdxLeaf1 + " " +  maxIdxLeaf2);
				//if (leaf1Parent.get(maxIdxLeaf1 ) == leaf2Parent.get(maxIdxLeaf2 )) {
				if (leaf1Parent.get(maxIdxLeaf1 ).equals(leaf2Parent.get(maxIdxLeaf2 ))) {

					ans1 = leaf1Parent.get(maxIdxLeaf1);

					maxIdxLeaf1--;
					maxIdxLeaf2--;
				} else {

					break;
				}
			}
			// System.out.println(ans1);

			// 이제 여기서부터, 쭈욱 돌면서 count 해줘야 하는데..
			// BFS 느낌
			// 반복문 돌고, now[0]번 값이 1과 같다면..
			// Queue.add now(1)
			// count + 1;
			// 하나 뽑고, 반복문 돌고,
			Queue<Integer> que = new LinkedList<Integer>();
			que.add(ans1);
			int ans2 = 0;
			while (que.size() != 0) {
				int poped = que.poll();
				ans2++;
				for (int[] now : arr) {
					if (now[0] == poped) {
						que.add(now[1]);
					}
				}
			}
			// System.out.println(ans2);
			System.out.println("#" + tc + " " + ans1 + " " + ans2);
		}
	}
}
