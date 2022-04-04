package aps_220404;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class SWEA_6808_규영이와인영이의카드게임 {
	// 문제의 개수
	static int N = 9; // 배열의 총 수
	static int[] gyu; // 규영이의 숫자들
	static int[] ans; // 정답을 담을 배열
	static int gyuWin, inWin; // 각각 승리수
	static HashSet<Integer> pool; // 1~18까지 숫자들
	static ArrayList<Integer> in; // 인영이의 숫자들

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			// 전체집합을 만들고(1~18)
			pool = new HashSet<>();
			for (int i = 1; i <= 18; i++) {
				pool.add(i);
			}
			// 입력 받은걸로 pool에서 제거 -> in영이..
			gyu = new int[9];
			for (int i = 0; i < 9; i++) {
				gyu[i] = sc.nextInt();
				pool.remove(gyu[i]);
			}
			// 남은거 넣어주기
			in = new ArrayList<>();
			for (int i : pool) {
				in.add(i);
			}
			// 인영이 배열 완성
			// 이제 인영이 배열을 퍼뮤테이션 돌아야함..
			
			// 승수 초기화
			gyuWin = 0; 
			inWin = 0;
			// 정답 배열 초기화
			ans = new int[N];
			perm(0, 0);
			System.out.println("#" + tc + " " + gyuWin + " " + inWin);

		}
	} // end main

	// 해당 idx는, 인영이의 점수들에 대한 idx
	static void perm(int idx, int visited) {
		// N까지 다 돌았을 때 경우를 세줄거야
		if (idx == N) {
			// 각각 점수를 세준다
			int gyuScore = 0;
			int inScore = 0;
			for (int i = 0; i < N; i++) {
				if (gyu[i] > ans[i]) {
					gyuScore += (gyu[i] + ans[i]);
				} else {
					inScore += (gyu[i] + ans[i]);
				}
			} // 서로의 점수 나옴
			if (gyuScore > inScore) {
				gyuWin++;
			} else if (gyuScore < inScore) {
				inWin++;

			}
			return;
		}

		// k == N 일

		for (int i = 0; i < N; i++) {
			// 이제 썼는지, 안 썼는지 확인!
			// 이제 visited 라는 수와 몇 번째 자리에 있는지 교집합!
			// 1 1 1 1 1 0 0 1
			// 0 0 0 0 0 0 1 0 => 짜피 교집합하면 visited, i번째 자리만 파악하게 돼!
			// 0 만 아니면 그 자릿수 썼다는 뜻!
			if ((visited & (1 << i)) != 0) {
				continue;
			}
			// ans[] idx자리에 안 쓴거 넣어주고(i번쨰)
			ans[idx] = in.get(i);
			// idx 자리 하나 증가시켜주고, visited라는 숫자와 안 들어간 수를 합집합 해줘서
			// 썼다고 처리해주는느낌!
			perm(idx + 1, visited | (1 << i));
			// 이렇게 처리해주면, visited 자체를 들고다니기 때문에 따로 뺴줄 필요도 없다

		}
	}
}
