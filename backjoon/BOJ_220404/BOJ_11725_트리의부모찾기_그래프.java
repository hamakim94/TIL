package BOJ_220404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기_그래프 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		// 노드 개수
		int N = Integer.parseInt(br.readLine());
		
		// 부모 담을 자료
		int[] parents = new int[N+1];
		
		// 이제 노드 담을 자료
		List<Integer>[] list = new ArrayList[N+1];
		// 주소 만들어줘야함. 아니면 그냥 비어있음(인터페이스)
		for(int i=0; i< list.length; i++) {
			list[i] = new ArrayList<>();
		}
		// N-1번째 줄까지 연결된 두 정점
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 인덱스가 시작, 안에있는 ArrayList들이 갈 수 있는 곳!
			list[a].add(b);
			list[b].add(a);
		}
		
		// BFS
		// 갔는지 체크할 배열이 필요하네
		boolean[] visited = new boolean[N+1];
		// 큐도 필요하네
		Queue<Integer> que = new LinkedList<>();
		// 초기값 넣어주고, 갔니?
		que.add(1);
		visited[1] = true;
		while(!que.isEmpty()) {
			int start = que.poll();
			// 여기선 이제, list[start] 번째 원소들을 순회해야함
			for(int i : list[start]) {
				// 어 안들렸니?
				if(visited[i] == false) {
					// 그럼 갈 곳에 넣어주고
					que.add(i);
					// 간곳 체크하고
					visited[i] = true;
					// 부모 노드 설정하렴~
					parents[i] = start;
				}
			}
		} // end bfs
		for(int i=2; i<parents.length; i++) {
			sb.append(parents[i]).append("\n");
		}
		
		System.out.println(sb);
		
		
	}
}