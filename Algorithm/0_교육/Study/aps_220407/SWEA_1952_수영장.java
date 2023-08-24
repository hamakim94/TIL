package aps_220407;

import java.util.Scanner;

public class SWEA_1952_수영장 {
	// 월별 사용일수
	static int[] months;
	static int days, month, threeMonth, year, minValue;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		// 계획
		int testCase = sc.nextInt();

		for (int tc = 1; tc <= testCase; tc++) {
			// 입력 받고(배열로)
			days = sc.nextInt();
			month = sc.nextInt();
			threeMonth = sc.nextInt();
			year = sc.nextInt();
			// 합의 최소값;
			minValue = 0;
			months = new int[12];
			for (int i = 0; i < 12; i++) {
				months[i] = sc.nextInt();
			}
			// 1 아닌 숫자 만나 ! 우선 하루치 비용으로 다 최소값 채워
			for (int i = 0; i < 12; i++) {
				if (months[i] != 0) {
					months[i] = months[i] * days;
				}
			}
			// 1 아닌 순자 만나 ! 1달 요금과 비교해서 최소값 채워
			for (int i = 0; i < 12; i++) {
				if (months[i] != 0) {
					months[i] = Math.min(months[i], month);
				}
				
			} // end for : 1일, 1달 비교 완료, 이제 구해진 합을 구하자
			// 여기까지 나온 수들의 합을 minVal이라 두자
			for(int i=0; i<12; i++) {
				minValue += months[i];
			}
			
			// 3달 비교 : 재귀
			countMinval(0,0);
			
			// 나온 합들과 1년치 비용이랑 싸워!
			minValue = Math.min(minValue, year);
			sb.append("#").append(tc).append(" ").append(minValue).append("\n");
		} // end testCase
		System.out.println(sb);
	}// end main
	private static void countMinval(int idx, int sum) {
		// 가지치기
		if(sum > minValue) {
			return;
		}
		// 11이 넘어가면 minValue 계산해보기
		if(idx > 11) {
			if(sum < minValue) {
				minValue = sum;
			}
			return;
		}
		// 재귀
		countMinval(idx + 1, sum + months[idx]);
		countMinval(idx+3, sum+threeMonth);
	}
	
}
