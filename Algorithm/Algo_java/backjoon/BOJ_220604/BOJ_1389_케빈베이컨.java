import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1389_�ɺ����� {
	static int N, M;
	// ������� ����غ���
	static int[][] arr;
	static boolean[] visited; // �湮ó��
	static ArrayList<int[]> size;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][N + 1];
		size = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[start][end] = 1;
			arr[end][start] = 1;
		} // end for : �Է� �Ϸ�
	
		for(int i=1; i<N+1; i++) {
			int sum = 0;
			for(int j=1; j<N+1; j++) {
				if(i==j) continue;
				sum += BFS(i,j);
			}
			size.add(new int[] {i, sum});
		}
		size.sort(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return o1[1] - o2[1];
				return o1[1]-o2[1];
			}
		});
		
		System.out.println(size.get(0)[0]);

	}

	private static int BFS(int start, int end) {
		// BFS ���� ���
		// �湮ó�� �迭 �ʱ�ȭ
		visited = new boolean[N+1];
		// ������ queue�� �ְ� �湮ó��
		Queue<Integer> que = new LinkedList<>();
		que.add(start);
		visited[start] = true;
		int size = 0;
		outer : while(true) {
			size++;
			int len = que.size();
			for(int i=0; i<len; i++) {
				int now = que.poll();
				for(int j=1; j<N+1; j++) {
					if(!visited[j] && arr[now][j] == 1) {
						que.add(j);
						visited[j] = true;
						if(j == end) {
							break outer;
						}
					}
				}
			}
		}
		return size;
	}

}
