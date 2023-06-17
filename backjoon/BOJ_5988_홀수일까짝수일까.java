package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5988_홀수일까짝수일까 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String st = br.readLine();
			int lastNum = st.charAt(st.length() - 1) - '0';
			if(lastNum % 2 == 0) {
				sb.append("even").append('\n');
			} else {
				sb.append("odd").append('\n');
			}
			
		}
		System.out.println(sb.toString());
	}
}
