package PGS_220823;

import java.util.*;

public class PGS_같은숫자는싫어 {

	public class Solution {
		public int[] solution(int[] arr) {
			ArrayList<Integer> list = new ArrayList<>();
			int last = -1;

			for (int i : arr) {
				if (list.size() == 0) {
					last = i;
					list.add(i);
				}
				if (i == last)
					continue;
				last = i;
				list.add(i);

			}
			int[] answer = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				answer[i] = list.get(i);
			}

			return answer;
		}
	}
}
