package aps_220223;

import java.util.Arrays;

public class LinkedList_02_삽입정렬 {
	public static void main(String[] args) {
		int[] data = { 69, 10, 30, 2, 16, 8, 31, 22 };

		// 0번 인덱스는 정렬이 돼있어~~~
		for (int i = 1; i < data.length; i++) {
			int key = data[i]; // i번쨰 자리 정렬할래
			int j;

			// 뒤로 밀면서 위치 확보
			for (j = i - 1; j >= 0 && data[j] > key; j--) {
				data[j+1] = data[j]; // 오른쪽으로 밀어
				//조건이 들어가줘야함
			}
			// j라는 위치에 넣어야 할 것 같은데 마지막에 한 번 깎임
			data[j+1] = key;
			
			System.out.println(Arrays.toString(data));

		}
	}
}
