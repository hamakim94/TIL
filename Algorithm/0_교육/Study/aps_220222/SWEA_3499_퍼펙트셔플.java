package aps_220222;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_3499_퍼펙트셔플 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		String[] arr;
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			StringBuilder sb = new StringBuilder();
			int n = sc.nextInt();
			arr = new String[n];
			Queue<String> left = new LinkedList<String>();
			Queue<String> right = new LinkedList<String>();
			for (int i = 0; i < n; i++) {
				// 짝수인 경우엔, 2로 나눈 몫 전까지 left에 들어감
				if (n % 2 == 0) {
					if (i < n / 2) {
						left.add(sc.next());
					} else {
						right.add(sc.next());
					}
					// 홀수인 경우엔 2로 나눈 몫까지 left에 들어감
				} else {

					if (i <= n / 2) {
						left.add(sc.next());
					} else {
						right.add(sc.next());
					}

				}

			} // end for : 왼쪽 오른쪽 구분 완료
			sb.append("#").append(tc).append(" ");
			// 이제 하나씩 pop해주면서 출력값에 더해줄거야
			while (!(left.isEmpty() && right.isEmpty())) {
				if (!left.isEmpty()) {
					sb.append(left.poll());
					sb.append(" ");
				}
				if (!right.isEmpty()) {
					sb.append(right.poll());
					sb.append(" ");
				}
			}
			sb.append("\n");
			System.out.print(sb);
		} // end for : 테스트 케이스 다 함

	}
}
