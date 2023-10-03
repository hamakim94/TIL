package BOJ_220610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_11286_절대값힙 {

	static class Abs implements Comparable<Abs> {
		int num;

		Abs(int num) {
			this.num = num;
		}

		@Override
		public int compareTo(Abs other) {
			if (Math.abs(this.num) == Math.abs(other.num))
				return Integer.compare(this.num, other.num);
			return Math.abs(this.num) - Math.abs(other.num);
		}

		@Override
		public String toString() {
			return num + "";
		}
		
		

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Abs> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(br.readLine());
			if (now == 0) {
				if (pq.isEmpty())
					sb.append(0).append('\n');
				else
					sb.append(pq.poll()).append('\n');
			} else {
				pq.add(new Abs(now));
			}
		}
		System.out.println(sb);
	}
}
