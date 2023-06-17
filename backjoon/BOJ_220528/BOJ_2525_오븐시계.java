package BOJ_220528;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2525_오븐시계 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(br.readLine());
		
		int hourToAdd = time / 60;
		int minuteToAdd = time % 60;
		
		// 가장 작은 경우부터
		// 현재 분 + 더할 분 >=60 인 경우, 1 더하기
		// 현지 시간 + 앞으로 더할 시간이
		
		if(M+ minuteToAdd >= 60) 
			hourToAdd++;
		M = (M + minuteToAdd )%60;
		H = (H+hourToAdd) % 24;
		
		System.out.println(H + " " + M);
	}
}

