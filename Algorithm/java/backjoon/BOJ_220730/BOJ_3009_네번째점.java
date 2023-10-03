package BOJ_220730;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ_3009_네번째점 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> mapR = new HashMap<>();
		HashMap<Integer, Integer> mapC = new HashMap<>();
		for(int i=0; i<3; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			mapR.put(r, mapR.getOrDefault(r, 0)+1);
			mapC.put(c, mapC.getOrDefault(c, 0)+1);	
		}
		for(int key : mapR.keySet()) {
			if(mapR.get(key) == 1) {
				sb.append(key).append(' ');
			}
		}
		for(int key : mapC.keySet()) {
			if(mapC.get(key) == 1) {
				sb.append(key).append(' ');
			}
		}
		System.out.println(sb);
	}
}
