package BOJ_220427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5525_IOIOI100 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cntIOI = Integer.parseInt(br.readLine());
		int size = Integer.parseInt(br.readLine()); 
		String str = br.readLine(); // 입력 문자열
		int ans = 0; // 정답
		int checkIOI = 0; // IOI 개수 세기
		// 3개를 보므로, 마지막 - 2 까지만!
		for(int i=0; i<size-2 ; i++) {
			// IOI 패턴이라면
			if(str.charAt(i) == 'I' && str.charAt(i+1) == 'O' && str.charAt(i+2) == 'I' ) {
				checkIOI++; // 개수 더해주고
				// cntIOI와 체크한게 같아지는 순간
				if(checkIOI == cntIOI) {
					checkIOI--; // 다음걸 확인하기 위해 1개 감소시키고
					ans++;// 정답에 1 더해줌
				} 
				i++; // 이렇게 하면 IOI 만나면 for문에서 i가 2씩 더해주는거(0 안봄0
			} else {
				checkIOI = 0; // 초기화
			}
		}
		System.out.println(ans);
	}
}
