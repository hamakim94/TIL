package aps_220214;

public class String_패턴매칭 {
	public static void main(String[] args) {

		char[] text = "This iss a book".toCharArray();
		char[] pattern = "iss".toCharArray();

		System.out.println(BruteForecFor(text, pattern));
		System.out.println(BruteForceWhile(text, pattern));
	}
	
	public static int BruteForceWhile(char[] t, char[] p) {
		int i =0; // t 인덱스
		int j = 0; // p 인덱스
		int N = t.length;// t의 길이
		int M = p.length; // p의 길이
		
		while(i<N && j<M) {
			if( t[i] != p[j]) {
				
				i -= j;
				j = -1;
			}
			i++;
			j++;
		}
		
		if(j == M){
			return i-M;
		}
		return -1;
	}
	
	

	public static int BruteForecFor(char[] t, char[] p) {

		int N = t.length;// 본문의 길이
		int M = p.length;// 패턴의 길이

		// 시작점을
		for (int i = 0; i < N - M + 1; i++) {
			boolean flag = true; // 이번 차례에 패턴을 찾았는지 못 찾았는지

			// i를 시작점으로 하는 패턴 검사 끝.
			for (int j = 0; j < M; j++) {
				if (p[j] != t[i + j]) {
					flag = false;
					break;
				}
			}
			if (flag)
				return i;
		}

		// 찾지 못 하면
		return -1;

	}
	
	

}
