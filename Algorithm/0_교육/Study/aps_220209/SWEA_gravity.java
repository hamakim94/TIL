package aps_220209;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_gravity {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i =0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		//최대값 찾기
		int max = 0;
		for(int i =0; i<n; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		//인덱스의 차이로 답을 내고 싶으니, cnt로 index를 위한 배열 만들어
		ArrayList<Integer> index = new ArrayList<>();
		// 최대값을 통해서, 같은 길이가 있는지 확인
		int cnt = 0;
		for(int i =0; i<n; i++) {
			if (arr[i] == max) {
				cnt += 1;
				index.add(i);
			}
		}
		//떨어지는 최대높이 - 첫 번째 맥스값의 위치 - max인 칸의 개수-1
		System.out.println( n-1 - index.get(0) - (cnt-1) );
		
		
		
	}
}
