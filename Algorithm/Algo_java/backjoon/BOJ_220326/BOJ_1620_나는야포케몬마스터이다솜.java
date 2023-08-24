package BOJ_220326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_1620_나는야포케몬마스터이다솜 {

	public static int N, M;
	public static String[] dogam;
	public static String input;
	public static HashMap<String, Integer> nameToNum;

	public static void main(String[] args) throws IOException {

		// 첫쨰 줄
		// 도감에 수록돼있는 포켓몬의 수 N , 내가 맞춰야 하는 문제의 개수
		// 1<= N,M <= 100000
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] problem = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(problem[0]);
		M = Integer.parseInt(problem[1]);

		// (2회차)도감을 위한 hashmap으로 하니 틀리네요!, 
		// (3회차)일단 key로 num에 접근하는 해쉬맵도 만들어봄
		dogam = new String[N + 1];
		nameToNum = new HashMap<>();

		// 둘째 줄 부터 N개의 줄에 1번이 포켓, N번 포켓몬까지
		for (int num = 1; num <= N; num++) {
			input = br.readLine();
			dogam[num] = input;
			nameToNum.put(input, num);
		}
		// 그 다음 줄 부터 m개의 줄에 내가 맞춰야 하는 문제가 입력으로 들어옴
		// 문제가 알파벳으로만 들어오면 번호를 말하고, 숫자로만 들어오면 포켓몬 번호
		// 입력이 2가지 경우로 들어오네..

		for (int prob = 0; prob < M; prob++) {
			input = br.readLine();
			// 첫 문자의 아스키 코드가 48부터 57 사이에 있는 경우만 Integer.parint하자
			if (input.charAt(0) <= 57) {
				int dogamKey = Integer.parseInt(input);
				sb.append(dogam[dogamKey]).append("\n");
				// 그 외는 value에서 찾기
			} else {
				sb.append(nameToNum.get(input)).append("\n");

			}
		} // end for
		System.out.println(sb);
	}
}
