package aps_220225;

import java.util.Scanner;

public class SWEA_1289_원재의메모리복구하기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for(int tc=1; tc<=testCase; tc++) {
			// 입력 배열
			String[] now = sc.next().split("");
			// 개수 세기
			int cnt = 0;
			
			for(int i=0; i<now.length; i++) {
				if(now[i].equals("1")) {
					cnt++;
					now[i] = "0";
					for(int j=i+1; j<now.length; j++) {
						now[j] = (now[j].equals("0")) ? "1":"0";
					}
				}
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
