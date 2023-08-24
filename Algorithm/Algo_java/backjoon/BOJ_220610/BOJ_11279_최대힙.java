package BOJ_220610;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_11279_최대힙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			int now = sc.nextInt();
			if(now == 0) {
				if(pq.isEmpty())
					sb.append(0).append('\n');
				else
					sb.append(-pq.poll()).append('\n');
			}
			else {
				pq.add(-now);
			}
		}
		System.out.println(sb);
	}
}
