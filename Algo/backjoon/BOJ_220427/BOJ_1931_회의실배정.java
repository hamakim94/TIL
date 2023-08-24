package BOJ_220427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1931_회의실배정 {

	// 종료시간 기준 정렬(오름차순) => 끝나는 시간이 빠른거부터 보겠다는 뜻!
	// 시작시간도 큰 순서대로 나와서
	// 끝나는 시간이 마지막 선택된거 시작시간 이하인거 골라서
	// 그걸 또 새로운 시작으로..
	static class time implements Comparable<time> {
		int start;
		int end;

		public time(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(time o) {
			if (this.end == o.end) { // 끝 시간이 같아?
				return this.start - o.start; // 시작 시간 기준으로 오름차순! : 겹치는 경우 방지 88 48
			}
			// 끝 시간이 다른 경우는 그냥 오름차순!
			return this.end - o.end;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		PriorityQueue<time> pq = new PriorityQueue<>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.add(new time(start, end));
		}

		int endTime = 0; // 현재 끝나는 시간
		while (!pq.isEmpty()) {
			time now = pq.poll(); // 오름차순돼서, 끝나는 시간이 제일 일찍인게 나옴
			if (endTime <= now.start) { // 현재의 시작시간이 저장된 끝나는시간보다 크거나 같으면
				endTime = now.end; // 끝나는 시간 : 현재보고있는 곳에 끝나는 시간으로 해주고
				ans++; // 카운트~
			}

		}
		System.out.println(ans);
	}
}
