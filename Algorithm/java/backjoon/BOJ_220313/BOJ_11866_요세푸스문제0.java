package BOJ_220313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11866_요세푸스문제0 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		// 1부터 N까지
		int N = Integer.parseInt(st.nextToken());
		// K번쨰 값 뽑기
		int K = Integer.parseInt(st.nextToken());

		// 값을 담을 리스트 : ArrayList로 만들어서, K번째 자료를 remove 할거야
		List<Integer> arr = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			arr.add(i);
		}

		// 처음 숫자는 -1 : (for문을 돌면서 K씩 더할거므로)인덱스는 0부터 시작
		int idx = -1;
		sb.append("<");

		// 계획
		// for문을 1번 남을 때 까지 돌려서(0부터, N-1 보다 작을때)
		for (int i = 0; i < N - 1; i++) {
			// 현재 위치 + K해서 가져올거고,
			idx += K;
			// 여기서 만약 더한 값이 list의 size보다 크다면, size로나눈 나머지를 idx로 설정
			if (idx >= arr.size()) {
				idx %= arr.size();
			}
			sb.append(arr.remove(idx)).append(", ");
			// 하나 빠졌으므로, idx를 한 칸 땡겨와야 함
			idx--;
		} // end for : 1개 남음

		// 마지막 그냥 빼서 넣어주고, > 더해줌
		sb.append(arr.remove(0)).append(">");

		System.out.println(sb);

	}
}
