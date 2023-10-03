package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12034_김인천씨의식료품가게 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int size;
		int[] arr;
		boolean[] visited;
		for(int t=1; t<=T; t++) {
			sb.append("Case #").append(t).append(": ");
			size = Integer.parseInt(br.readLine());
			arr = new int[size*2];
			visited = new boolean[size*2];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<size*2; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<size*2; i++) {
				if(!visited[i]) {
					visited[i] = true;
					for(int j=i+1; j<size*2; j++) {
						if(visited[j]) continue;
						if(arr[i]/3*4 == arr[j]) {
							visited[j] = true;
							sb.append(arr[i]).append(' ');
							break;
						}
					}
				}
			}
			sb.append('\n');
			
			
		}
		System.out.println(sb);
		
	}
}
