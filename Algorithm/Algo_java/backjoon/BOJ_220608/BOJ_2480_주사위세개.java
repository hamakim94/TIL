package BOJ_220608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2480_주사위세개 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		if(a == b && b == c) {
			System.out.println(1000*a+10000);
		} else if ( a == b && b != c) {
			System.out.println(1000 + 100*a);
		} else if ( b == c && a != b) {
			System.out.println(1000 + 100*b);
		} else if ( a == c && b != c) {
			System.out.println(1000 + 100*a);
		} else {
			int maxi = Math.max(a, Math.max(b, c));
			System.out.println(100*maxi);
		}
		
		
	}
}
