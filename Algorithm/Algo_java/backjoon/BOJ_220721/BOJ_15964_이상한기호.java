package BOJ_220721;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_15964_�̻��ѱ�ȣ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger A = sc.nextBigInteger();
		BigInteger B = sc.nextBigInteger();
		System.out.println(A.pow(2).subtract(B.pow(2)));
	}
}
