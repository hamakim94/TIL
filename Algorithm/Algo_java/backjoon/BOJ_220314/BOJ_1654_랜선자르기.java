package BOJ_220314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// Q) lt를 0으로 설정
// Q) long을 써야하는 이유좀 ㅠ

public class BOJ_1654_랜선자르기 {
	public static void main(String[] args) throws IOException {
		//우선 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		long N = Integer.parseInt(st.nextToken());
		
		// 최대 최소 담을 변수
		long maxVal = 0;
		
		// 입력을 담을 배열
		
		long[] arr = new long[K];
		
		for(int i=0; i<K; i++) {
			long now = Long.parseLong(br.readLine());
			//최대값
			if ( now > maxVal) {
				maxVal = now;
			}
			// 자료 삽입
			arr[i] = now;
		} // end for : 자료 입력 완료
		
		//자료가 1부터 2^31 -1 까지이므로, lt = 0으로 두자 이러니 안 되네,,
		// 1로 둬야함(최대값이 1이면 mid가 0이 나온다
		long lt = 1;
		long rt = maxVal;
		//System.out.println(lt + " " + rt);
		while(lt <= rt) {
			long mid = (lt+rt)/2;
			// 잘린 선들의 개수를 저장
			long cnt = 0;
			// 각 원소별로 중앙값으로 나눈 몫들을 더해준다
			for(int i=0;i<K; i++) {
				cnt += arr[i]/mid;
			}
			//System.out.println("cnt : " + cnt + " mid : " + mid);
			//만약 cnt가 N보다 작으면(길이가 길면) 
			if(cnt < N) {
				// rt를 mid -1로
				rt = mid -1;
				//cnt가 N보다 크거나 같으면
			} else if(cnt >= N) {
				// lt 조정해
				lt = mid + 1;
			}
			
		} // end while : 이진탐색 끝
		System.out.println(lt-1);
	}
}
