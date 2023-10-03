package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_2587_대표값2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> que = new PriorityQueue<>();
		int sum = 0;
		for(int i=0; i<5; i++) {
			int now = Integer.parseInt(br.readLine());
			que.add(now);
			sum += now;
		}
		System.out.println(sum / 5);
		que.poll();
		que.poll();
		System.out.println(que.peek());
		
	}
}
