package aps_220226;

import java.util.Arrays;

public class 삽입정렬 {
	public static void main(String[] args) {
		int[] data = { 69, 10, 30, 2, 16, 8, 31, 22 };
		
		// 삽입정렬
		// 이미 정렬된 왼쪽, 나머지 오른쪽이라고 생각하기
		// 현재 데이터를 뽑아놓고, 
		// 현재 데이터 이전의 idx부터 처음까지 for문을 돌면서
		// 		만약 크다면 한 칸 우측으로 옮겨주기
		// 		근데 for문을 돌면서 넣어야 할 idx보다 항상 -1 값이 나오므로, idx + 1 해야함
		// 		크지 않으면, 빠져나옴
		
		for(int i=1; i<data.length; i++) {
			int temp = data[i]; // 현재 정렬을 할 것들
			int j = 0;
			
			for(j = i-1; j>=0 && data[j] > temp; j--) {
				data[j+1] = data[j];
			}
			data[j + 1] = temp;
			
		} // end for
		
		System.out.println(Arrays.toString(data));
	} 
}
