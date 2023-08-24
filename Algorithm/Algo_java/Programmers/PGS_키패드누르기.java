public class PGS_키패드누르기 {

	class Solution {
		public String solution(int[] numbers, String hand) {
			StringBuilder sb = new StringBuilder();
			int[][] map = new int[10][3];
			int[] left = { 3, 0 };
			int[] right = { 3, 2 };
			map[0] = new int[] { 3, 1 };
			map[1] = new int[] { 0, 0 };
			map[2] = new int[] { 0, 1 };
			map[3] = new int[] { 0, 2 };
			map[4] = new int[] { 1, 0 };
			map[5] = new int[] { 1, 1 };
			map[6] = new int[] { 1, 2 };
			map[7] = new int[] { 2, 0 };
			map[8] = new int[] { 2, 1 };
			map[9] = new int[] { 2, 2 };

			// 1,4,6 이면 왼쪽 손가락, 왼쪽 손가락 좌표 업데이트
			// 3,6,9 이면 오른쪽 손가락,
			for (int i : numbers) {
				if (i == 1 || i == 4 || i == 7) {
					left = map[i];
					sb.append('L');
				} else if (i == 3 || i == 6 || i == 9) {
					right = map[i];
					sb.append('R');
				} else {
					int leftDist = Math.abs(left[0] - map[i][0]) + Math.abs(left[1] - map[i][1]);
					int rightDist = Math.abs(right[0] - map[i][0]) + Math.abs(right[1] - map[i][1]);
					if (leftDist > rightDist) {
						right = map[i];
						sb.append('R');
					} else if (leftDist < rightDist) {
						left = map[i];
						sb.append('L');
					} else {
						if (hand.equals("right")) {
							right = map[i];
							sb.append('R');
						} else {
							left = map[i];
							sb.append('L');
						}
					}
				}
			}
			String answer = sb.toString();
			return answer;
		}
	}
}
