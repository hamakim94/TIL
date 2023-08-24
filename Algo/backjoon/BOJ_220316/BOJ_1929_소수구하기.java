package BOJ_220316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1929_소수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] now = br.readLine().split(" ");
		// M이상
		int M = Integer.parseInt(now[0]);
		// N이하의 모든 소수
		int N = Integer.parseInt(now[1]);

		// 에라토스테네스의 체
		int[] define = new int[N + 1];
		
		// 2부터 시작해서 N까지 하고,  
		for (int i = 2; i <= N; i++) {

			// 2부터 시작하니, 2는 소수니까, 2의 배수 싹 삭제
			// 3의 배수 싹 삭제 ... 삭제 안 된거? 소수!
			if (define[i] == 0) {
				//오 삭제 안 됨? 너 소수(1)
				define[i] = 1;
				int toSum = i;
				// 배수들 다 삭제시키기
				while (true) {
					toSum += i;
					if (toSum <= N) {
						define[toSum] = i;
					} else {
						break;
					}
				} // end while : 채우기 완료
			} else { // 0이 아니라면 넘어가
				continue;
			}

		} // end for : N까지 체 완료
		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N; i++) {
			if (define[i] == 1) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}
}