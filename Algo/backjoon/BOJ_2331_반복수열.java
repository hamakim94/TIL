
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2331_반복수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int P = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		list.add(A);
		while(true) {
			int temp = list.get(list.size() - 1);
			int next = 0;
			while(temp != 0) {
				int num = temp % 10;
				next += Math.pow(num, P);
				temp /= 10;
			}
			if(list.contains(next)) {
				System.out.println(list.indexOf(next));
				break;
			} else {
				list.add(next);
			}
		}
	}
	
}
