package BOJ_220622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_18870_ÁÂÇ¥¾ÐÃà {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> map = new HashMap<>();
		int rank = 0;
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		// deep
		int[] sort = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			sort[i] = arr[i];
		}
		Arrays.sort(sort);
		for(int num : sort) {
			if(!map.containsKey(num))
				map.put(num, rank++);
		}
		for(int k : arr ) {
			sb.append(map.get(k)).append(' ');
		}
		System.out.println(sb);
		
	}
}
