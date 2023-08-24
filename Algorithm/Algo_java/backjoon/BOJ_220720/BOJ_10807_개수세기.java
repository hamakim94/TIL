package BOJ_220720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10807_개수세기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> map = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(st.nextToken());
			if(!map.containsKey(now)){
				map.put(now, 1);
			} else {
				int temp = map.get(now) + 1;
				map.put(now, temp);
			}
		} // end for
		int ans = Integer.parseInt(br.readLine());
		if(map.containsKey(ans)) {
			System.out.println(map.get(ans));
		} else {
			System.out.println(0);
		}
	}
}
