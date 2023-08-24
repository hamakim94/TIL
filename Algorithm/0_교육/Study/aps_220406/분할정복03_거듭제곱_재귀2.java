package aps_220406;

public class 분할정복03_거듭제곱_재귀2 {

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

		int result;
		// 짝수 일떄
		if(N%2 == 0) {
			result = power(C, N/2);
			return result * result;
		} 
		// 홀수 일떄
		else {
			result = power(C, (N-1)/2);
			return result * result* C;			
		}
	}
}
