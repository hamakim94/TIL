package backjoon_220131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_8958_OX퀴즈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inp = Integer.parseInt(br.readLine());

		for (int t = 0; t < inp; t++) {
			// 한 줄 읽고
			String n = br.readLine();
			int total_count = 0;
			int box_count = 0;
			// 그 줄의 길이만큼 반복
			for (int i = 0; i < n.length(); i++) {
				// 값이 0이 반복되면 box_count + =1
				if (String.valueOf(n.charAt(i)).equals("O") && i < n.length() - 1) {
					box_count += 1;
				// 마지막까지 O인 경우가 있으므로, 그 때 box_count + 1 해주고 (n*(n+1))/2 합공식 이해서 전체 합에 더해줌
				} else if (String.valueOf(n.charAt(i)).equals("O") && i == n.length() - 1) {
					box_count += 1;
					total_count += box_count * (box_count + 1) / 2;
				} else {
					// 0 만나면 더해주고, box_count 초기화
					total_count += box_count * (box_count + 1) / 2;
					box_count = 0;
				}
			}
			System.out.println(total_count);
		}
	}
}
