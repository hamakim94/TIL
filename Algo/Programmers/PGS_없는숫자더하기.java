
public class PGS_���¼��ڴ��ϱ� {

	class Solution {
		public int solution(int[] numbers) {
			int answer = 0;
			boolean[] check = new boolean[10];
			for (int num : numbers) {
				check[num] = true;
			}
			for (int i = 0; i < 10; i++) {
				if (!check[i])
					answer += i;
			}

			return answer;
		}
	}
}
