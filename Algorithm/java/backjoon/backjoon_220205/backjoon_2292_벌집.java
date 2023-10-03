package backjoon_220205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_2292_벌집 {
	public static void main(String[] args) throws IOException {
		// 그냥, 6n + 1 계속 계산하다가
		// 그거보다 작으면
		// 그 n이 답이야.
		
		//인풋
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		br.close();
		
		int n = 0;
		// a1 - a0 = 6
		// a2 - a1 = 6*2
		//   ...
		// an - an-1 = 6*n
		// +
		// an - 1 = 3*n*(n+1)
		while ( 3*n*(n+1)+1 <number) {
			n += 1;
		}
		// 1일때부터 1로 더하니까, 결과값에 1 더해야해
		System.out.println(n+1);
		
		
	}
}
