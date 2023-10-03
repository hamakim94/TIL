package BOJ_220607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_11478_서로다른문자열의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Set<String> set = new HashSet<String>();

		int len = input.length();
		int now = 1;

		while (now <= len) {
			for (int i = 0; i <= len - now; i++) {
				set.add(input.substring(i, i + now));
			}
			now++;
		}
		System.out.println(set.size());

	}
}
