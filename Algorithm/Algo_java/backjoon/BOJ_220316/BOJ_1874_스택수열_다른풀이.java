package BOJ_220316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874_스택수열_다른풀이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		StringBuilder sb = new StringBuilder();

		int start = 0;
		// N번 반복할거고
		for (int i = 0; i < N; i++) {
			// 입력값을 받아
			int value = Integer.parseInt(br.readLine());
			// 1부터 들아갈 수, start가 value보다 작으면
			if (start < value) {
				// start+1부터, value랑 같아질 때 까지
				for (int k = start + 1; k <= value; k++) {
					sb.append("+").append("\n");
					// push를 해준다
					stack.add(k);
				}
				// start값을 value로 해줌으로, 다음에 큰 값 들어올 때 for문 돌 수있
				System.out.printf("-------start : %d < value : %d(input값) 인 경우-------\n", start, value );
				System.out.println(stack.toString() + " " + start + " " + value);
				start = value;
				System.out.println(stack.toString() + " " + start + " " + value);
			}
			// 만약 start >= value 일 때, 사실 같은 경우밖에 없음
			// 아직 for문 안, stack.peek()이 무조건 value랑 같아야 함
			else if (value != stack.peek()) {
				System.out.println(stack.toString() + " " + start + " " + value);
				System.out.println("NO");
				return; // main 함수 끝
			}
			System.out.printf("----pop : start : %d >= value : %d(input값) 일 때-------\n", start, value);
			System.out.println(stack.toString() + " " + start + " " + value);
			stack.pop();
			System.out.println("after pop" + stack.toString() + " " + start + " " + value);
			System.out.println("----------------------------------------------------------------------");
			sb.append("-").append("\n");
			

		} // end for
		System.out.println(sb);

	}
}
