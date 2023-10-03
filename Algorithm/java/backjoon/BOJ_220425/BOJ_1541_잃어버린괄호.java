package BOJ_220425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541_잃어버린괄호 {
	// - 만나는 순간, 뒤에 숫자들이 + 있으면 다 더한다음에,
	// - 만나면 빼고, 끝까지 갔으면 그냥 빼 같은데
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// - 를 기준으로 split 때리고
		String[] a = br.readLine().split("-");
		// 대충 묶이는거 다 더해서 빼면 됨
		int ans = 0;
		for (int i = 0; i < a.length; i++) {
			if (i == 0) { // 첫 번째 수는 그냥 더하고
				ans += plus(a[i]);
			} else { // 나머진 그냥 다 -
				ans -= plus(a[i]);
			}
		}
		System.out.println(ans);

	}

	// -는 이미 사라졌으니, 쪼개진 문자 더해주는 함수
	static int plus(String str) {
		int sum = 0;
		String[] nums = str.split("\\+"); // 자바에서는, 특수문자를 정규표현식 쓸 때 \\ 쓴다네요. .겁나이상
		for (String a : nums) {
			sum += Integer.parseInt(a); // 숫자로 바꾸고 누적합
		}
		return sum;
	}
}
