package BOJ_220316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966_프린터큐_틀림 {

	// 같은 수에서 구별법 : class를 만들어 boolean check = true면 내가 원하는거!
	static class CheckNum {
		int imp; // 중요도
		int check; // 내가 원하는 수인지

		public CheckNum(int imp, int check) {
			this.imp = imp;
			this.check = check;
		}

		@Override
		public String toString() {
			return imp + " "+ check ;
		}
		

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < testCase; tc++) {
			// 우선 큐 만들고
			Queue<CheckNum> que = new LinkedList<>();
			// que의 사이즈
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			// 내가 원하는 수!
			int idx = Integer.parseInt(st.nextToken());

			// 뽑을 때 마다, 1씩 더해줄 수
			int cnt = 0;

			// (중요도, 원하는 수)인지 까지 나옴,
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				que.add(new CheckNum(Integer.parseInt(st.nextToken()), i));
				
			}

			// 9부터 돌면서, 9랑 같으면 빼기, 그러면서 cnt 증가

			aa: for (int important = 9; important > 0; important--) {
				// 언제 뺄 지 몰라서, 그냥 N만큼 돌기로 했음!(어차피 최대 N번은 돌아야함)
				for (int t = 0; t < N; t++) {
					
					// 일단 하나 뽑고
					CheckNum now = que.poll();
					// now의 중요도가 important, 9부터 시작해서 차례로 작아지는 수라면
					if (now.imp == important) {
						// 카운트 증가, 다시 queue에 넣지 않는다! 수 ++
						cnt++;
						t--;
						N--;
						// 근데 뽑고 나서, 알고보니 내가 원하는 수? 끝내!
						if (now.check == idx) {
							break aa;
						}

					} else {
						// 중요도가 important랑 다르면 그냥 돌아가렴
						que.add(now);
					}
					
//					for (CheckNum q : que) {
//						System.out.print(q.toString() + " ");
//					}
//					System.out.println();
				}

			}
			// 뽑아
			sb.append(cnt).append("\n");

		} // end for :
		System.out.println(sb);
	}

}
