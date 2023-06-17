package backjoon_220205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_15829_Hashing {

	public static final int m = 1234567891;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int ch;
		String str = br.readLine();
		long hash = 0;
		for (int i = 0; i < n; i++) {

			ch = str.charAt(i) - 'a' + 1;
			hash += ch * hash(i);
//			for(int j = 0; j < i; j++) {
//				times = times * 31 % 1234567891;
//			}		
		}
		System.out.println(hash % m);

		br.close();

	}

	public static long hash(int b) {
		return b == 0 ? 1 : hash(b - 1) * 31 % m;
	}
	// 1234567891 MOD수로 나누기
}
