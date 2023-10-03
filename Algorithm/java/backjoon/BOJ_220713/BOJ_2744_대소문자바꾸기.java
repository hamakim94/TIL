package BOJ_220713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2744_대소문자바꾸기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] input = br.readLine().toCharArray();
		for (int i = 0; i < input.length; i++) {
			if (input[i] > 'Z')
				sb.append((char) (input[i] - 32));
			else
				sb.append((char) (input[i] + 32));
		}
		System.out.println(sb);
	}
}
