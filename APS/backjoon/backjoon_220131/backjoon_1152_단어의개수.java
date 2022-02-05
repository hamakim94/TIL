package backjoon_220131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_1152_단어의개수  {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String res;
		res = br.readLine();
		StringTokenizer st = new StringTokenizer(res);
		int cnt = 0;
		
		while(st.hasMoreTokens()) {
			cnt += 1;
			st.nextToken();
		}
		System.out.println(cnt);
		br.close();
	}

}


