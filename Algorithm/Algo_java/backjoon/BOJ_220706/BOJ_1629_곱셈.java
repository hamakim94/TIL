package BOJ_220706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_1629_곱셈 {
	static long C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Long A = Long.parseLong(st.nextToken());
		Long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		System.out.println(pow(A,B));

	}
	private static long pow(Long a, Long expo) {
		if(expo == 1){
			return a;
		}
		long temp = pow(a, expo/2);
		
		if(expo % 2 == 1) {
			return (temp * temp % C) * a%C;
		}
		return temp*temp%C;
		
		
	}
}
