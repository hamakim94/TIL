package BOJ_220624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1427_소트인사이드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		char[] arr = br.readLine().toCharArray();
		for (char a : arr) {
			int now = (int) a - '0';
			pq.add(-now);
		}
		while (!pq.isEmpty()) {
			sb.append(-pq.poll());
		}
		System.out.println(sb);
	}
}
