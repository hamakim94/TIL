package aps_220406;

public class 분할정복02_거듭제곱_재귀 {

	public static void main(String[] args) {
		
		int C = 2;
		int N = 10;
		

		System.out.println(power(C, N));
		
	}
	
	
	// C : 숫자(밑수) n : 거듭제곱(지수)
	static int power(int C, int N) {
		if(N == 1) {
			return C;
		}

		
		// 짝수 일떄
		if(N%2 == 0) {
			return power(C,N/2) * power(C, N/2);
		} 
		// 홀수 일떄
		else {
			return power(C, (N-1)/2) * power(C, (N-1)/2) * C;			
		}
	}
}
