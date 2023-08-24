package BOJ_220710;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_2407_조합 {
	static BigInteger par, son;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		par = BigInteger.ONE;
		son = BigInteger.ONE;
		for(int i=0; i<m; i++) {
			par = par.multiply(new BigInteger(String.valueOf(n-i)));
			son = son.multiply(new BigInteger(String.valueOf(i+1)));
		}
		System.out.println(par.divide(son));
		
	}
}
