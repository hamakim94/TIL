package BOJ_220326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1676_팩토리얼0의개수_인터넷 {

	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		//0, 1, 2, 3, 4 는 0으로 그냥 세짐
		int cnt = 0;
		// 재귀 느낌임.
		while(num >= 5) {
			// 여기서 5로 나눈 몫을 더해 주는데, 만약 5가 더 곱해져 있으면 더 더해야함.
			cnt += num/5;
			// 예를들어 25면, 일단 몫 5 더해주고, 5로 나눠져서 다시 5를 5로 나눈 몫을 더해줘서 6
			// 125, 25 더해주고, 25 => 5 더해주고, 5 1 더해줌. (감은잘안옴)
			num /= 5;
		}
		System.out.println(cnt);

	}

}
