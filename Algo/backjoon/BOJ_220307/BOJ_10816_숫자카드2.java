package BOJ_220307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10816_숫자카드2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		
		// hashMap 쓰자
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			// 없다면 만들어
			int now = Integer.parseInt(st.nextToken());
			if (!map.containsKey(now)) {
				map.put(now, 1);
			} else {
				map.put(now, map.get(now)+1);
			}
		} // end for : 입력완료
		//System.out.println(map.toString());
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int now = Integer.parseInt(st.nextToken());
			if(map.containsKey(now)) {
				sb.append(map.get(now)).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb);
		
	}
}
