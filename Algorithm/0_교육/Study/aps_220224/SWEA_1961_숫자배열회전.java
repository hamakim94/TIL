package aps_220224;

import java.util.Scanner;

public class SWEA_1961_숫자배열회전 {

	public static void main(String[] args) {
		// 입력 받기
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			int n = sc.nextInt();
			// 기본 배열 받기
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();

				}
			}
			// 하나로?
			String[] str= new String[n];
			// 초기값 공백으로
			for(int i=0; i<n; i++) {
				str[i] = "";
			}
			// 90도 회전
			// 배열을 만들어, 회전을 하고 나온 첫 번째 선을 누적해서 더해줌
			// 한 줄을 돌고 나면 공백을 추가해서 다음거 더할 수 있도록 만들어줌
			int cnt = 0;
			for (int c = 0; c < n; c++) {
				for (int r = n - 1; r >= 0; r--) {
					//sb.append(arr[r][c]);
					str[cnt] += arr[r][c];
				} // end for\
				str[cnt++] += " ";
			
			}
			cnt = 0;
			// 180도 회전
			for (int r = n - 1; r >= 0; r--) {
				for (int c = n - 1; c >= 0; c--) {
					//System.out.print(arr[r][c]);
					str[cnt] += arr[r][c];
				}
				str[cnt++] += " ";
			}
			
			cnt = 0;
			for (int c = n - 1; c >= 0; c--) {
				for (int r = 0; r < n; r++) {
//					System.out.print(arr[r][c]);
					str[cnt] += arr[r][c];
				}
//				System.out.println();
				str[cnt++] += " ";
			} // 다 더해짐
			System.out.println("#" + tc);
			for(int i=0; i<n; i++) {
				System.out.println(str[i]);
			}
		}
	}
}
