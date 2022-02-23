package BOJ_220223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1158_요세푸스문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] arr = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int K = Integer.parseInt(arr[1]);
		Queue<Integer> que = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			que.add(i);
		}
		sb.append("<");
		while (que.size() >1) {
			for(int i=0; i<K-1; i++) {
				que.add(que.poll());
			}
			sb.append(que.poll()).append(", ");
		} // end while
		
		
		sb.append(que.poll()).append(">");
		System.out.println(sb);
	}
}
