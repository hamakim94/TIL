package backjoon_220205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_2275_부녀회장이될테야 {
	public static void main(String[] args) throws IOException {
		// 직접 for문돌면서 만들어야할거같아

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 최고 : 14층 14호

		// 층이다
		int k = 14;
		// 호다
		int n = 14;

		// 층,호수를 그냥 쓰기 위함
		int[][] arr = new int[k + 1][n + 1];

		// 0층 챱챱!
		for (int i = 0; i < 15; i++) {
			arr[0][i] = i;
		}

		// 각층 1호는 무적권 1이니, 1 다 넣
		for (int i = 1; i < 15; i++) {
			arr[i][1] = 1;
		}

		// 1층부터 14층까지
		for (int floor = 1; floor < 15; floor++) {
			// 2호부터 14호까지
			for (int ho = 2; ho < 15; ho++) {
				// 한층 아래에 호수 작거나 같은거 다더해
				for (int i = 1; i <= ho; i++) {
					arr[floor][ho] += arr[floor - 1][i];
				}
			}
		}

		int rep = Integer.parseInt(br.readLine());
		for (int i = 0; i < rep; i++) {
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());
			System.out.println(arr[a][b]);
		}

	}
}
