package aps_220209;

public class List1_03_BabyGin_완전검색 {
	public static void main(String[] args) {
		int[] cards = { 5, 4, 6 };
		int N = 3; // 만약 6장이라면 아래 for문을 훨씬 아래로 들어감

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// i와 j는 달라야함!
				if (i != j) {
					for (int k = 0; k < N; k++) {
						// k는 i와 j와는 모두 달라야 함
						if (i != k && j != k) {
							System.out.printf("%d %d %d\n", cards[i], cards[j], cards[k]);
							
							if (runCheck(cards[i], cards[j], cards[k])) {
								System.out.println("run이야");
							} else if( tripletCheck(cards[i], cards[j], cards[k])){
								System.out.println("triplet이야");
							}
							}
					}// end for : 세번째 카드 뽑
				}// end if

			}//end for
		}// end for
		
		
	}
	// a, b, c 연속된 숫자인지 확인
	static boolean runCheck(int a, int b, int c) {
//		if (b==a+1 && c == a+2) {
//			return true;
//		}else {
//			return false;
//		}
		
//		if (b==a+1 && c == a+2) {
//		return true;
//		}
//		return false;
		
		return b == a+1 && c==a+2;
	}
	static boolean tripletCheck(int a, int b, int c) {
		return a==b && b==c;
	}
	
}