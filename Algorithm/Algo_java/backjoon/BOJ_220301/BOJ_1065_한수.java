package BOJ_220301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1065_한수 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 한수의 개수를 담을 변수
		int cnt = 0;

		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			// 100 미만이면 무적권 한수
			if (i < 100) {
				cnt++;
			} else {
				// 스트링으로 변환
				String now = i + "";
				// 첫 두 자리로, 등차를 구함
				int sub = now.charAt(0) - now.charAt(1);
				boolean flag = true;
				// 그 다음부터, 마지막까지
				for (int k = 1; k < now.length() - 1; k++) {
					// 구한 등차라 다른 차이가 나오면 바로 false - break
					if (now.charAt(k) - now.charAt(k + 1) != sub) {
						flag = false;
						break;
					}
				// 만약 다 같으면 cnt 해줌
				}
				if (flag) {
					cnt++;
				}
			}

		} // end for : brute force
		System.out.println(cnt);

	}
}
