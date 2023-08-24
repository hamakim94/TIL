package aps_220209;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.SoapBindingParameterStyle;

public class List1_04_BabyGin_그리디 {
	public static void main(String[] args) {
		int[] cards = { 5, 4, 6 };
		int N = 3; // 만약 6장이라면 아래 for문을 훨씬 아래로 들어감
		
		
		// 편하게 run : 크기를 늘림
		int [] cnt = new int[12];
		// 값을 카운팅 해서 cnt에 넣어줌(해당 값을)
		for(int i =0; i<cards.length; i++) {
			cnt[cards[i]]++;
		}
		// 해당 i번쨰 카드 검사
		int i = 0;
		// while문 : 조건이 거짓이 될 때 까지 도니까, 거짓일 떄 멈춰!
		while(i<10) {
			//triplet 검사
			if (cnt[i] >= 3) {
				cnt[i] -= 3;
				System.out.println("triplet");
				continue; // 하나 나왔으면, 다시 조건문 해보자, triplet이 2개면 2개가 안 나와
			}
			if(cnt[i-1] >= 1 && cnt[i] >= 1 && cnt[i+1] >= 1 ) {
				cnt[i]--;
				cnt[i-1]--;
				cnt[i+1]--;
				System.out.println("Run 이라네");
				continue;
			}
		}
		i++;
		
	}

}