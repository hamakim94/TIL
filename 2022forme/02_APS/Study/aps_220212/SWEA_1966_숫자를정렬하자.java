package aps_220212;


import java.util.Scanner;

public class SWEA_1966_숫자를정렬하자 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 전체 테스트케이스 개수
		int testCase = sc.nextInt();
		for(int t=1; t<=testCase; t++) {
			// 길이를 입력받아
			int len = sc.nextInt();
			//배열입력
			int[] arr = new int[len];
			for(int i=0; i<len; i++) {
				arr[i] = sc.nextInt();
			}
			//System.out.println(Arrays.toString(arr));
			// 정렬된 배열 받아
			int[] sorted = countSort(arr);
			// 형식에 맞게 출력
			System.out.printf("#%d ", t);
			for(int i=0; i<sorted.length; i++) {
				System.out.print(sorted[i] +" ");
			}
			System.out.println();
			
		}

	}

	public static int[] countSort(int[] arr) {
		// arr 최댓값 찾기
		int N = arr.length;
		int max = 0;
		int[] sorted = new int[N];
		for (int i = 0; i < N; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		// 최댓값을 사용한 카운팅
		int[] count = new int[max + 1];
		int c = 0;
		while (c < N) {
			count[arr[c]] += 1;
			c++;
		}
		//System.out.println(Arrays.toString(count));
		// 누적합
		c = 0;
		while (c < count.length-1) {
			count[c+1] += count[c];
			c++;
		}
		//System.out.println(Arrays.toString(count));
		//이제 원래 배열 거꾸로 돌며, --count[배열값] 한걸 넣어주기
		c=N-1;
		while(c >= 0) {
			sorted[--count[arr[c]]] = arr[c];
			c--;
		}
		return sorted;

	}
}
