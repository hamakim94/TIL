package BOJ_220214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_10814_나이순정렬 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// 2차원 String 배열로 받자
		String[][] user = new String[n][2];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			user[i][0] = st.nextToken();
			user[i][1] = st.nextToken();
		}
		br.close();

		// 여기서 정렬 정하자
		Arrays.sort(user, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub
				// 음수면 위치 그대로, 양수면 자리 바꾼다는 느낌
				// 그리고 나이만 정렬하면 되니까, 추가 작업 필요 X
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}

		});

		for (int i = 0; i < n; i++) {
			System.out.println(user[i][0] + " " + user[i][1]);
		}

	}
}
