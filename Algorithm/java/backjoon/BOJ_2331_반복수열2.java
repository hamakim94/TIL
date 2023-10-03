import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class BOJ_2331_반복수열2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		int A = sc.nextInt();
		int P = sc.nextInt();
		HashSet<Integer> set = new HashSet<>();
		set.add(A);
		arr.add(A);
		outer : while(true) {
			A = getNext(A, P);
			if(set.contains(A)) {
				for(int i=0; i<arr.size(); i++) {
					if(arr.get(i) == A) {
						System.out.println(i);
						break outer;
					}
				}
			} else {
				set.add(A);
				arr.add(A);
			}
		}

	}
	static int getNext(int num, int power) {
		int nextNum = 0;
		while(num != 0) {
			int temp = num % 10;
			nextNum += Math.pow(temp, power);
			num /= 10;
			
		}
		return nextNum;
	}
}
