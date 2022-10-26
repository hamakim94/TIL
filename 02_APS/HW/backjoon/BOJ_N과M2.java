import java.util.Scanner;

public class BOJ_N°úM2 {
	static int[] sel;
	static boolean[] check;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		sel = new int[M];
		
		DFS(0, 0);
		System.out.println(sb.toString());
	}
	private static void DFS(int at, int depth) {
		if(depth == M) {
			for(int i : sel) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=at; i<N; i++) {
			sel[depth] = i+1;
			DFS(i + 1, depth + 1);
			
		}
		
	}
}
