package BOJ_220531;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class prob2 {
	static char[] arr = { 'A', 'S', 'A', 'D', 'A', 'S' };

	public static void main(String[] args) {
		// n 입력 2 2번 flip
		// a, b 입력 1 3 // *7 + 15 % 7 : 뒤집기 공식
		HashMap<Character, Integer> map = new HashMap<>();
		for(char a : arr) {
			if(map.containsKey(a)) {
				map.put(a, map.get(a) + 1);
			} else {
				map.put(a,  1);
			}
		}
		int max = 0;
		char ans = '0';
		for(char k : map.keySet()) {
			if(map.get(k) > max) {
				max = map.get(k);
				ans = k;
			}
			
		}
		System.out.println(ans+" " + max);
	}

}
