package BOJ_220617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4101_크냐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a== 0 && b == 0) break;
			if(a > b)
				sb.append("Yes").append('\n');
			else
				sb.append("No").append('\n');
		}
		System.out.println(sb);
	
		
	}
}
