package backjoon_220131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_10809_알파벳찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		// 알파벳은 보통 26개.

		// 알파벳 26개를 배열로 초기화 ( -1, 값이 들어있지 않다고 가정)
		int[] arr = new int[26];
		for (int i = 0; i < 26; i++) {
			arr[i] = -1;
		}

		// 처음 나타난 문자로 어떻게 할까.. 따로 set을 만들어야하나 아니면 좋은 방법이 있을까
		// 아 배열의 index가 -1일 때만 하면 되는구나
		for (int j = 0; j < input.length(); j++) {
			if (arr[(input.charAt(j) - 'a')] == -1)
				arr[(input.charAt(j) - 'a')] = j;
		}

		for (int j = 0; j < 26; j++) {
			System.out.print(arr[j] + " ");
		}

	}
}
