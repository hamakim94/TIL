package PGS_220504;

import java.util.*;

public class PGS_42586_기능개발 {

	class Solution {
		public int[] solution(int[] progresses, int[] speeds) {
			// 한 번 루프 돌기
			int startIdx = 0; // 시작 인덱스

			ArrayList<Integer> ansList = new ArrayList<>();

			while (startIdx != progresses.length) {
				// 한 번 더해주고
				for (int i = 0; i < progresses.length; i++) {
					progresses[i] += speeds[i];
				}

				if (progresses[startIdx] >= 100) {
					int cnt = 1;
					while (startIdx < progresses.length && progresses[startIdx] >= 100) {
						startIdx++;
						if (startIdx == progresses.length)
							break;

						if (progresses[startIdx] >= 100) {
							cnt++;
						}
					}
					ansList.add(cnt);
				}
			} // end while

			int[] answer = new int[ansList.size()];
			for (int i = 0; i < ansList.size(); i++) {
				answer[i] = ansList.get(i);
			}
			return answer;
		}
	}
}
