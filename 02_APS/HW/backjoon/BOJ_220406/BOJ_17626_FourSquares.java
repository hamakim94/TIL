package BOJ_220406;

import java.util.Scanner;

public class BOJ_17626_FourSquares {
	// 최대 4개까지니까.
	static int minVal = 4;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		// 숫자 해당 해의 최소값을 구할 배열
		int[] arr = new int[n+1];
		
		arr[0] = 0;
		arr[1] = 1; // 1은 1의 제곱 오직 하나
		
		// 잘 이해 안가네요.
		// 2부터 돌건데
		for(int i=2; i<=n; i++) {
			// 1부터 제곱한 값이 i보다 작거나 같을 때 까지, 더해줄꺼야
			// 더해지는 최소 제곱수의 개수의 최소값
			int min = Integer.MAX_VALUE;
			
			for(int toSquare = 1; toSquare*toSquare <= i; toSquare++) {
				// 아래에서 부터 채워지고, arr[5] = arr[4] + arr[1] 꼴이니까, 
				// arr[9] = arr[1] arr[8] 비교
				// arr[9]   arr[4] arr[5] 비교
				//          arr[0] 비교
				min = Math.min(min, arr[i - toSquare*toSquare ]);
			}
			// 각 부분의 최소값에 1씩 더해준다(저번에 했던거 최소값에 에 1만 끼룩 더할래~)
			// 어짜피 이전까지 구한 숫자들이 다 최솟값이고
			//  1, 4, 9, 25, 36 제곱수일 때만 휘리릭 바뀌니 그전꺼 이용 가능~
			arr[i] = min + 1;
		}
		
		System.out.println(arr[n]);
		
	}
	
}
