package BOJ_220314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654_랜선자르기_bruteforce {
	static int cnt ; // 잘린 조각의 개수
	static int num ; // 랜선의 길이, 1씩 증가시킬 예정
	public static void main(String[] args) throws IOException {
		//우선 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		// 최대 최소 담을 변수
		int maxVal = 0;
		
		// 입력을 담을 배열
		int[] arr = new int[K];
		
		for(int i=0; i<K; i++) {
			int now = Integer.parseInt(br.readLine());
			// 자료 삽입
			arr[i] = now;
		} // end for : 자료 입력 완료
		// 0부터 증가시킬거야
		num =0;
		int rt = maxVal;
		
		while(true) {
			// 1씩 더해 주고
			num++;
			//카운팅해주고
			cnt =0;
			for(int i=0; i<K; i++) {
				cnt += arr[i]/num;
			} // cnt가 N보다 작아진 시점에 딱 멈추고, num을 감소시킨다
			if(cnt < N) {
				num--;
				break;
			}
		}
		//그걸 뽑자
		System.out.println(num);
	}
}
