
public class PGS_소수만들기 {
	class Solution {
		public int solution(int[] nums) {
			int answer = 0;
			// 에라토스테네스의 체
			boolean[] checkPrime = new boolean[3000];
			int[] primeNums = new int[3000];
			for (int i = 0; i < 3000; i++) {
				primeNums[i] = i;
				checkPrime[i] = true;
			}
			for (int i = 2; i < 3000; i++) {
				if (checkPrime[i]) {
					for (int k = i + i; k < 3000; k += i) {
						checkPrime[k] = false;
					}

				}
			}
			for (int i = 0; i < nums.length - 2; i++) {
				for (int j = i + 1; j < nums.length - 1; j++) {
					for (int k = j + 1; k < nums.length; k++) {
						int tempNum = nums[i] + nums[j] + nums[k];
						if (checkPrime[tempNum]) {
							answer++;
						}
					}
				}
			}

			return answer;
		}
	}
}
