package backjoon_220205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_11050_이항계수1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int mother= 1;
		int son =1;
		if (k == 0) {
			System.out.println(1);
		} else {
			for(int i = 0; i<k; i++) {
				mother *= (n-i);
				son *= (i+1);
			}
			System.out.println(mother/son);
		}
	}
}
