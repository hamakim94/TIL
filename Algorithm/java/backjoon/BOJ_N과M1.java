import java.util.Scanner;

public class BOJ_N°úM1 {
	static boolean[] visited;
	static int[] arr;
	static int N, M;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		visited = new boolean[N];
		sb = new StringBuilder();
		DFS(0);
		System.out.println(sb.toString());
	}
	static void DFS(int level) {
		if(level == M) {
			for(int num : arr) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		}
		// ³Ö°í
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[level] = i+1;
				DFS(level+1);
				visited[i] = false;
			}
		}

	}
}
