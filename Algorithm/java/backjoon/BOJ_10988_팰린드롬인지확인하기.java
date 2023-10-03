package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10988_팰린드롬인지확인하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		boolean check = true;
		for(int i=0; i< input.length / 2; i++) {
			if(input[i] != input[input.length-1-i]) {
				check = false;
				break;
			}
			
		}
		if (check) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
