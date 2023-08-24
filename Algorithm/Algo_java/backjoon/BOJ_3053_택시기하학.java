package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3053_택시기하학 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double n = Integer.parseInt(br.readLine());
		System.out.printf("%.6f\n", n*n*Math.PI);
		System.out.printf("%.6f", 2*n*n);
	}
}
