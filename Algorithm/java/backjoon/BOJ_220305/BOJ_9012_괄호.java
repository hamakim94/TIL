package BOJ_220303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012_괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		String input;
		Stack<Character> stack;
		//testCase 시작
		for (int i = 0; i < n; i++) {
			
			input = br.readLine();
			
			stack = new Stack<>();
			
			// ( 만나면 넣고, ) 만나면 뺴기, 중간에 비어있어도 out, 다 했는데 차있어도 out
			boolean flag = true;
			
			for(int k=0; k<input.length(); k++) {
				// 현재 캐릭터
				char now = input.charAt(k);
				// 열면 열기
				if(now == '(') {
					stack.add(now);
				} else {
					if(stack.isEmpty()) {
						flag=false;
						break;
					}
					stack.pop();
				}
			} // end for
			
			// 최종 스택 비어있니
			if(!stack.isEmpty()) {
				flag = false;
			}
			
			if(flag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			
		}

	}
}
