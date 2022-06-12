package BOJ_220612;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1655_가운데를말해요 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minQue = new PriorityQueue<>((o1, o2) -> o1 - o2);
		PriorityQueue<Integer> maxQue = new PriorityQueue<>((o1, o2) -> o2 - o1);
		int size = 0;
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(br.readLine());
			
			if(minQue.size() == maxQue.size()) {
				maxQue.add(now);
			} else {
				minQue.add(now);
			}
			
			if(!minQue.isEmpty() && !maxQue.isEmpty()) {
				if(minQue.peek() < maxQue.peek()) {
					int temp = minQue.poll();
					minQue.add(maxQue.poll());
					maxQue.add(temp);
				}
			}
			sb.append(maxQue.peek()).append('\n');

		}
		System.out.println(sb);
	}
}
