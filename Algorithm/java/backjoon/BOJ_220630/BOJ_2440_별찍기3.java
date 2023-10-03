package BOJ_220630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2440_별찍기3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=N; i>0; i--) {
			for(int j=0; j<i; j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
