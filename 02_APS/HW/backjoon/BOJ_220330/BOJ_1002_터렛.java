package BOJ_220330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1002_터렛 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 자료의 수
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			if (x1 == x2 && y1 == y2 && r1 == r2) {
				System.out.println(-1);

			} else if (x1 == x2 && y1 == y2 && r1 != r2) {
				System.out.println(0);

			} else {
				double distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
				System.out.println("dist" + " " + distance);
				
				if (distance > r1 + r2) {
					System.out.println(0);
					// 두 원점 사이의 거리가 같으면 그냥 1
				} else if (distance == r1 + r2) {
					System.out.println(1);
					
				} 
				// 두 원점 사이의 거리가 각 길이의 합 보다 길면,
				else {
					// 여기서 경우가 더 나뉘게 되네..

					// 만약 두 반지름의 차가 dist 보다 크면 안 만나고
					if (Math.abs(r1 - r2) > distance) {
						System.out.println(0);
					}

					else if (Math.abs(r1 - r2) == distance) {
						System.out.println(1);
					}
					// 아닌 경우 두 점 만나네
					else {
						System.out.println(2);
					}

				}

			}

		}

	}
}
