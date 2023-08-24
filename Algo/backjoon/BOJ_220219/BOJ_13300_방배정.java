package BOJ_222219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13300_방배정 {
	public static void main(String[] args) throws IOException {
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String[] strList;
		strList = br.readLine().split(" ");
		int N = Integer.parseInt(strList[0]);
		int K = Integer.parseInt(strList[1]);
		int cnt = 0; // 총합
		int[] manArr = new int[7];
		int[] womanArr = new int[7];

		for (int i = 0; i < N; i++) {
			strList = br.readLine().split(" ");
			int gender = Integer.parseInt(strList[0]);
			int grade = Integer.parseInt(strList[1]);

			// 여성, 남성 배열의 학년 칸에 1씩 더해준다
			if (gender == 0) {
				womanArr[grade]++;
			} else {
				manArr[grade]++;
			}
		} // end for : 모든 경우에수 다 세줌(카운팅 끝)
		
		// 몫이 있으면,  몫 만큼 더해주고, 몫을 더했는데도 나머지가 있으면, 방 하나 추가
		for (int j = 1; j <= 6; j++) {
			cnt += womanArr[j] / K;
			cnt += manArr[j] / K;
			if (womanArr[j] % K > 0) {
				cnt += 1;
			}
			if (manArr[j] % K > 0) {
				cnt += 1;
			}

		} // end for : 카운팅
		
		System.out.println(cnt);
	}

}
