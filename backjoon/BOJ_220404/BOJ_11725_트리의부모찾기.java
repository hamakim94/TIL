package BOJ_220404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기 {
	public static void main(String[] args) throws IOException {
		// 일단 한번 배열로 해보자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 2 <= N <= 100000
		int N = Integer.parseInt(br.readLine());
		// 부모 노드 보관소
		int[] parents = new int[N + 1];
		// 출력을 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		
		// 각 노드의 부모가 명확히 정해져야함
		// 입력받기 : nodes라는 hashset
		HashSet<int[]> nodes = new HashSet<>();
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int[] now = new int[2];
			now[0] = Integer.parseInt(st.nextToken());
			now[1] = Integer.parseInt(st.nextToken());
			nodes.add(now);
		}
		// 1부터 시작하기 위해, BFS를 돌거얌
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(1);
		// que가 비어있지 않을 때 까지
		while (!que.isEmpty()) {
			// 현재 목표값, 즉 부모 노드
			int tofind = que.poll();
			// 부모 자식 관계를 배열에 parents 배열에 저장하고, 앞으로 지울 간선들
			ArrayList<int[]> todel = new ArrayList<>();
			// node들을 돌면서
			for (int [] now : nodes) {
				// 왼쪽, 오른쪽 따로 받고
				int left = now[0];
				int right = now[1];
				// 왼쪽 노드 번호가 부모 노드랑 같으면
				if (left == tofind) {
					// 부모 선정
					parents[right] = left;
					// 부모 노드를 que에 넣어(새로운 시작이니까)
					que.add(right);
					// 원래 nodes에서 지우기 위해 더해준다
					todel.add(now);
				} else if (right == tofind) {
					// 마찬가지
					parents[left] = right;
					que.add(left);
					todel.add(now);
				}
			}
			// 이제 nodes 지우기, 이렇게 해야 나중에 똑같은게 안 세진다.
			for(int[] del : todel) {
				nodes.remove(del);
			}
			
			
			// 이제 해당 꺼 빼기
		} // end while, BFS
		for(int i=2; i<=N; i++) {
			sb.append(parents[i]).append("\n");
		}
		System.out.println(sb);
		
	}
}
