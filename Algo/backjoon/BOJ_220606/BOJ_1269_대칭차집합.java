package BOJ_220606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1269_대칭차집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<Long> setA = new HashSet<Long>();
		HashSet<Long> setB = new HashSet<Long>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			setA.add(Long.parseLong(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			setB.add(Long.parseLong(st.nextToken()));
		}
		int cnt = 0;
		for(Long k : setA) {
			if(setB.contains(k))
				cnt++;
		}
		System.out.println(setA.size() + setB.size() - 2*cnt);
	}
}
