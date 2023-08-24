package BOJ_220411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_9375_패션왕신해빈 {
	// 곱의 법칙 문제
	// 각 옷 종류는 독립.
	// 각 종류의 size+1을 누적곱
	// 1빼면 됨(다 안 입은 경우)

	static HashMap<String, Integer> map;
	static String key; // 옷의 종류
	static int ans; // 정답을 저장할 값
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			map = new HashMap<>();
			ans = 1; // 정답 초기화, 곱할거니까 1로
			int size = Integer.parseInt(br.readLine());
			for (int i = 0; i < size; i++) {
				// 같은 이름은 존재 X => 종류만 가져오기
				key = br.readLine().split(" ")[1];

				// 없으면 1넣고, 있으면 가져와서 1씩 더하고
				if (!map.containsKey(key))
					map.put(key, 1);
				else
					map.put(key, map.get(key) + 1);

			} // HashMap 생성 for문 완료
				// 이제 각 key안에 그 사이즈만큼 돌면서, (안입는거 + 각 사이즈) 누적곱
			for (String keys : map.keySet())
				ans *= (map.get(keys) + 1);

			// 출력을 위한 경우 나누기, 1 빼는 이유는 모두 안 입는 경우가 있기 때문에
			if (tc == 0)
				sb.append(--ans);
			else
				sb.append("\n").append(--ans);

		} // end testCase
		System.out.println(sb);
	}
}
