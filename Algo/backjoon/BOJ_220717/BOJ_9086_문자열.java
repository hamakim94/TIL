package BOJ_220717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9086_¹®ÀÚ¿­ {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String now = br.readLine();
			sb.append(now.charAt(0)).append(now.charAt(now.length()-1));
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
