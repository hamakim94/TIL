import java.util.Scanner;

public class BOJ_N과M3 {
	
	static int N, M; // N : 1~N까지 수, M : 길이
	static int[] sel;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sel = new int[M];
		DFS(0);
		System.out.println(sb.toString());
		
	}
	private static void DFS(int level) {
		// base case
		if(level == M) {
			for(int i : sel) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		// rescursive
		for(int i=0; i<N; i++) {
			sel[level] = i+1;
			DFS(level + 1);
		}
		
	}
}
