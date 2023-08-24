package aps_220218;

import java.util.Arrays;

public class PowerSet_For {
	public static void main(String[] args) {

		int[] bit = new int[4];

		int N = bit.length;

		for (int i = 0; i < 2; i++) {
			bit[0] = i;
			for (int j = 0; j < 2; j++) {
				bit[1] = j;
				for (int k = 0; k < 2; k++) {
					bit[2] = k;
					for (int l = 0; l < 2; l++) {
						bit[3] = l;

						System.out.println(Arrays.toString(bit));
					}
				}
			}
		}
	}
}
