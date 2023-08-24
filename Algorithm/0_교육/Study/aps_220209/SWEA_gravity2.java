package aps_220209;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_gravity2 {
	public static void main(String[] args) {
		
		int[] box = {7,4,2,0,0,6,0,7,0};
		// 각 열 확인
		int ans = 0;
		//i번째 박스 검사
		
		for(int i =0; i<box.length; i++) {
			// 최대 낙하높이
			// box의 길이가 9라면, 0번째 박스는 최대 8만큼 떨어질 수 있다
			// 3번째 박스는: 최대 5만큼 떨어질 수 있다
			// i번쨰 박스는 box.length -1 -i 만큼 떨어질 수 있다
			int cnt = box.length - 1 - i;
			for(int j = i+1; j<box.length; j++) {
				// 번쨰 박스보다 높이가 더 크거나 같은 값이 나오면 낙차를 감소시킴
				if(box[j]>= box[i]) {
					cnt--;
				}
				
				
			}
			//갱신
			if (ans < cnt ) {
				ans = cnt;
			}
		}
		System.out.println(ans);
		
		
	}
}
