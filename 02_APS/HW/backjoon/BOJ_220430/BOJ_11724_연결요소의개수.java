package BOJ_220430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {

	static int[] p; // 부모 배열
	static int N, M; // 정점, 간선의 수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점의 수
		M = Integer.parseInt(st.nextToken()); // 간선의 수
		p = new int[N + 1];
		// make-set : 자기 자신을 대표로 만들자!
		p = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			p[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			unionSet(x, y); // 합집합과 동시에 path-compression 발생
		}
		HashSet<Integer> ans = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			// 이거 해야지, i 돌면서 전부 path-compression!
			ans.add(findSet(i));
		}
		System.out.println(ans.size());
	}

	// find-set
	static int findSet(int x) {
		if (x != p[x]) // 내 인덱스가 대표랑 값이 다르면
			p[x] = findSet(p[x]); // path-compression
		// 이 경우가 되는건 i == p[i]인 경우
		return p[x];

	}

	// union-set
	static void unionSet(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		p[py] = px; // y의 대표는, x의 대표로!
	}

}
