package backjoon_220204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_10250_ACM호텔 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i =0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			int line;
			if (n%h == 0) {
				line = n/h;
			} else {
				line = n/h+1 ;	
			}
			int ho;
			if (n%h == 0) {
				ho = h;
			}else {
				ho = n%h;
			}
			
			System.out.printf("%d%02d", ho, line);
			System.out.println();
		}
		br.close();
	}
}
