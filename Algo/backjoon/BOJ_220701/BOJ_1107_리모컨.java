package BOJ_220701;

import java.util.Scanner;

public class BOJ_1107_리모컨 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		int m = sc.nextInt();
		
		boolean[] broken = new boolean[10];
		for(int i=0; i<m; i++) {
			broken[sc.nextInt()] = true;
		}
		
		int result = Math.abs(target - 100); // 초기값 설정, 시작점이 100이니까!
		
		for(int i=0; i<=999999; i++) {
			String str = String.valueOf(i); //str로
			int len = str.length();
			
			boolean isBreak = false;
			// 자릿수를 하나씩 돌면서
			for(int j=0; j<len; j++) {
				if(broken[str.charAt(j) - '0']) { // 고장난 버튼 눌러야 한다면!!
					isBreak = true;
					break;
				}
			}
			// 고장나면. 그냥 못 간다고 생각하는듯 부서저있지 않다면
			if(!isBreak) {
				int min = Math.abs(target - i) + len; // i를 누른 후 (len)target까지 이동하는 횟수
				result = Math.min(min,  result);
			}
		}
		System.out.println(result);
	}
}
