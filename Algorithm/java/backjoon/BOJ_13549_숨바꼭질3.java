import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13549_숨바꼭질3 {
	
	static int N, K; // 시작점, 목표점
	static boolean[] visited = new boolean[100001]; // 방문처리
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		PriorityQueue<Stat> que = new PriorityQueue<>();
		que.add(new Stat(N,0));
		while(!que.isEmpty()) {
			Stat now = que.poll();
			visited[now.idx] = true;
			if(now.idx == K) {
				System.out.println(now.value);
				break;
			}
			if(now.idx*2 <= 100000 && !visited[now.idx*2]) {
				que.add(new Stat(now.idx*2, now.value));
			}
			if(now.idx - 1 >= 0 && !visited[now.idx - 1]) {
				que.add(new Stat(now.idx - 1 , now.value + 1));
			}
			if(now.idx + 1 <= 100000 && !visited[now.idx + 1]) {
				que.add(new Stat(now.idx+1, now.value + 1));
			}
		}
		
		
		
	}
	
	static class Stat implements Comparable<Stat>{
		int idx;
		int value;
		public Stat(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}

		@Override
		public int compareTo(Stat o) {
			// TODO Auto-generated method stub
			return this.value - o.value;
		}
	 
		
	}

}

