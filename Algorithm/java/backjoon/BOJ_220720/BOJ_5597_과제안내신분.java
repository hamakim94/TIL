package BOJ_220720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5597_과제안내신분 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[31];
		for(int i=0; i<28; i++) {
			arr[Integer.parseInt(br.readLine())] = 1;
		}
		for(int i=1; i<=30; i++) {
			if(arr[i]==0) {
				sb.append(i).append('\n');
			}
		}
		System.out.println(sb);
	}
}
