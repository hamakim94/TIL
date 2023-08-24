package PGS_220821;

import java.util.*;

public class PGS_더맵게 {

	class Solution {
		public int solution(int[] scoville, int K) {
			int answer = 0;
			ArrayList<Long> arr = new ArrayList<>();
			for (int i = 0; i < scoville.length; i++) {
				arr.add((long) scoville[i]);
			}
			Collections.sort(arr);
			while (true) {
				if (arr.get(0) >= K)
					break;
				answer++;
				Collections.sort(arr);
				long newNum = arr.get(0) + 2 * arr.get(1);
				if (arr.size() >= 1) {
					arr.remove(0);
				} else {
					return -1;
				}
				if (arr.size() >= 1) {
					arr.remove(0);
				} else {
					return -1;
				}
				if (arr.size() == 1 && arr.get(0) < K) {
					return -1;
				}
				arr.add(newNum);
			}

			return answer;
		}
	}
}
