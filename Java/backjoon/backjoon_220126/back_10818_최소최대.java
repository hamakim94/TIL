package back220126;

import java.util.Scanner;

public class back_10818_최소최대 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int maxi = -1000001;
		int mini = 1000001;

		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			if (num > maxi) {
				maxi = num;
			}
			if (num < mini) {
				mini = num;
			}
		}
		System.out.println(mini + " " + maxi);

		sc.close();
	}
}
