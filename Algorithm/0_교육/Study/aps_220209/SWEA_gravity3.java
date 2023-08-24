package aps_220209;


import java.util.Scanner;

public class SWEA_gravity3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 1차원 배열을 입력받는다
		int size = sc.nextInt();
		
		int[] arr = new int[size];
		// 배열을 만들었다
		for(int i =0; i<size; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 중요한건 90도 회전하구
		// 하나하나 낙차를 계산해야함.
		// 그렇다면 최대 낙차? => size - 1(해당 문제는 8)
		
		// 최대낙차 계산
		int max = 0;
		for (int i = 0; i< size -1; i++) {
			
			// 크거나 같은거의 개수
			int cnt = 0;
			// 그럼 각자 가장 큰게 떨어질 때, 나보다 크거나 같은 값이 있으면 cnt에더해
			// 여기서 j는 끝까지 돌아야함.
			for(int j = i+1; j<size; j++) {
				if (arr[i] <= arr[j]) {
					cnt += 1;
				}//end if
			}//end for : 크거나 같은값 계산
			
			int ans = (size-1) - i - cnt;
			// 최대 낙차에 크거나 같은 값들을 더해줘야겠네?
			max = (max < ans) ? ans : max;

			
			
		}// end for : 다 돌기
		System.out.println(max);
	}
}
