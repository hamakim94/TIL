package BOJ_220625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1439_뒤집기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();

		// 스택을 쌓아서
		// 1. 0으로 바꾸는 경우, 바뀔떄 스택 비워, 0이면 넘어가고, 1이면 삭제후 cnt + 1
		int cntZero = 0;
		int cntOne = 0;
		Stack<Character> stack = new Stack<>();
		for (char input : arr) {
			if (stack.isEmpty()) {
				stack.add(input);
			} else {
				if (input == '0' && stack.peek() == '0') {
					stack.add(input);
				} else if (input == '0' && stack.peek() == '1') {
					cntZero++;
					stack.clear();
					stack.add(input);
				} else if (input == '1' && stack.peek() == '0') {
					cntOne++;
					stack.clear();
					stack.add(input);
				} else {
					stack.add(input);
				}
			}
		}
		if(!stack.isEmpty()) {
			if(stack.peek() == '0') {
				cntOne++;
			} else {
				cntZero++;
			}
		}
		System.out.println(Math.min(cntZero, cntOne));

	}
}
