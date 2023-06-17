package BOJ_220609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class BOJ_9020_골드바흐의추측 {
	static int[] primes;

	// 일단 애매하네
	// 10000개까지 소수 있는 배열 찾고
	// 그중에서 중복해서 2개 뽑은 후
	// 차이가 가장 적은걸 골라야하나..
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		primes = new int[10001];
		ArrayList<Integer> primeList = new ArrayList<>();
		// 에라토스테네스의 체
		for (int i = 2; i <= 10000; i++) {
			if (primes[i] == 0) {
				if (isPrime(i)) {
					primes[i] = 1;
					primeList.add(i);
					for (int j = i + i; j <= 10000; j += i) {
						primes[j] = i;
					}
				}
			}

		}

		for (int t = 0; t < tc; t++) {
			int N = Integer.parseInt(br.readLine());
			int left = N/2;
			int right = N/2;
			
			while(true) {
				if(primes[left] == 1 && primes[right] == 1) {
					System.out.println(left + " " + right);
					break;
				}
				right++;
				left--;
					
			}
		}
	}

	static boolean isPrime(int num) {
		if (num == 1)
			return false;

		int cnt = 0;
		for (int i = 1; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				cnt++;
		}
		if (cnt == 1)
			return true;
		return false;

	}
}
