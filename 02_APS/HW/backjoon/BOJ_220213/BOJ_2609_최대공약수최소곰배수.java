package BOJ_220213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609_최대공약수최소곰배수 {
	public static void main(String[] args) throws IOException {
		// 그냥 for문 돌면서, 돌이 동시에 나눠지는거 최대값 찾고
		// 둘이 곱한거까지 돌면서
		// 그 두 수로 동시에 나눠지는지 while문 돌면서 찾아
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(sc.nextToken());
		int b = Integer.parseInt(sc.nextToken());
		br.close();
		// 큰 수를 뒤로 넣어주는 swap, b가 더 크다!
		if (a > b) {
			int temp = a;
			a = b;
			b = temp;
		}
		int maxCum = 0;
		// 최대공약수 찾기
		for (int i = 1; i <= a; i++) {
			if (a % i == 0 && b % i == 0) {
				maxCum = i;
			}
		}
		System.out.println(maxCum);
		// 최소공배수 찾기;
		int minCum = b;
		while (true) {
			if (minCum % a == 0 && minCum % b == 0) {
				System.out.println(minCum);
				break;
			}
			minCum++;
		}
		
	}

}
