package backjoon_220202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class backjoon_1103_피보나치 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 케이스 횟수 주어짐
		int n = Integer.parseInt(br.readLine());

		// 답을 담을 리스트
		for (int j = 0; j < n; j++) {
			int input = Integer.parseInt(br.readLine());
			
			if (input == 0) {
				System.out.println("1 0");
			} else if (input == 1) {
				System.out.println("0 1");
			} else {
				int[][] ans_list = new int[input + 1][2];
				ans_list[0][0] = 1;
				ans_list[0][1] = 0;
				ans_list[1][0] = 0;
				ans_list[1][1] = 1;
				for (int i = 2; i <= input; i++) {
					ans_list[i][0] = ans_list[i - 1][0] + ans_list[i - 2][0];
					ans_list[i][1] = ans_list[i - 1][1] + ans_list[i - 2][1];
				}
				System.out.println(ans_list[input][0] + " " + ans_list[input][1]);
			}
		}
		br.close();

		// 0이 출력되는 횟수 ; 1이 출력되는 횟수를
	}
}
// 풀이 1 : 단점 : 시간이 오래걸림.
// 점화식처럼 가자
// 0이 출력되는 횟수, 1이 출력된 횟수를 [0,0] 식으로 배열을 만들자

//	static int count_zero = 0;
//	static int count_one = 0;
//
//	static int fibonacci(int input) {
//		if (input == 0) {
//			count_zero += 1;
//			return 0;
//		} else if (input == 1) {
//			count_one += 1;
//			return 1;
//		} else {
//			return fibonacci(input - 1) + fibonacci(input - 2);
//		}
//	}
//
//	public static void main(String[] args) {
//
//		Scanner sc = new Scanner(System.in);
//		// 케이스 횟수 주어짐
//		int n = sc.nextInt();
//		// 0이 출력되는 횟수 ; 1이 출력되는 횟수를
//		for (int i = 0; i < n; i++) {
//			count_zero = 0;
//			count_one = 0;
//			int input = sc.nextInt();
//			fibonacci(input);
//			System.out.println(count_zero + " " + count_one);
//		}
//		sc.close();
//		// 공백으로 구분하여 출력한다.
//
//	}
//}
