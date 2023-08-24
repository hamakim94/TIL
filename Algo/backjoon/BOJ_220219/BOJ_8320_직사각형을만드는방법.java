package BOJ_222219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8320_직사각형을만드는방법 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		// 2중 for문을 돌면서, j가 i보다 크거나 같을때만 센다(직사각형 기준 대각선 위쪽 삼각형만 세겠다)
		for(int i=1; i<=n; i++) {
			for(int j = i; j<=n; j++) { 
				// 넓이가 n보다 작거나 같으면, cnt += 1;
				if(i*j <= n) {
					cnt += 1;
				}
			}
		} // end for : 대각선 위 세기
		System.out.println(cnt);
	}
}
