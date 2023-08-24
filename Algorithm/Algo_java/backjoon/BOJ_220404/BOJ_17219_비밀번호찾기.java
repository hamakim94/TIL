package BOJ_220404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_17219_비밀번호찾기 {
	static String[] now;
	static String key;
	public static void main(String[] args) throws IOException {
		// HASHMAP 이용하면, contains : O(1), 편한거 아냐?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		now = br.readLine().split(" ");
		int N = Integer.parseInt(now[0]);
		int M = Integer.parseInt(now[1]);
		
		HashMap<String, String> findpw = new HashMap<>();
		for(int i=0; i<N; i++) {
			now = br.readLine().split(" ");
			findpw.put(now[0], now[1]);
		}
		
		for(int i=0; i<M; i++) {
			key = br.readLine();
			sb.append(findpw.get(key)).append("\n");
		}
		System.out.println(sb);
		
		
	}
}
