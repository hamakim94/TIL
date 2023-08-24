package backjoon_220131;

import java.util.ArrayList;
import java.util.Scanner;

public class backjoon_1546_평균 {
	public static void main(String[] args) {
		// 최대값 먼저 구하기
		Scanner sc = new Scanner(System.in);
		double n = sc.nextDouble();
		
		ArrayList<Double> arraylist = new ArrayList<>();
		// 입력 받으며 최대값 구하기
		double maxi = 0;
		for (double i = 0; i < n; i++) {
			double a = sc.nextDouble();
			arraylist.add(a);
			maxi = (maxi < a) ? a : maxi;
		}
		// System.out.println(arraylist.toString() + " " + maxi);
		// 구한 다음 점수들 for문돌며 변경
		double sum = 0.0;
		for(int i = 0; i<n; i++) {
			arraylist.set(i,  arraylist.get(i)/maxi*100 );
			sum += arraylist.get(i);
		}
		
		System.out.println(sum / n);
		// 평균 출력(double)이용
	}
}
