package BOJ_220306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_제로 {
	public static void main(String[] args) throws IOException {
		// 가장 첫 줄은 입력의 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		// 스택 활용
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(br.readLine());
			if(now >0) {
				stack.add(now);
			} else {
				// 0을 만나면 마지막꺼 빼;
				stack.pop();
			}
		} // end for : 스택 완료
		int sum = 0;
		for(int i=0; i<stack.size(); i++) {
			sum += stack.get(i);
		}
		System.out.println(sum);

		
	}

}
