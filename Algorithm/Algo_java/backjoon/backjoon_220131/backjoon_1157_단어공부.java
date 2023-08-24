package backjoon_220131;


import java.util.HashMap;
import java.util.Scanner;


public class backjoon_1157_단어공부 {
	public static void main(String[] args) {
		// 우선 입력받기
		Scanner sc = new Scanner(System.in);
		
		HashMap<Character, Integer> hashmap = new HashMap<>(); 
		String word = sc.next();
		char[] word2 = word.toUpperCase().toCharArray();
		// 알파벳 대소문자로 구성된 단어
		// 가장많이사용된 알파벳 출력
		
		for (char w : word2) {
			if (hashmap.get(w) == null) {
				hashmap.put(w, 1);
			} else {
				hashmap.put(w, hashmap.get(w) +1);
			}
			
		}

		// 개수 셀 땐 대소문자 구분 X
		int maxi = 0;
		for( char key : hashmap.keySet()) {
			maxi = (maxi < hashmap.get(key)) ? hashmap.get(key) : maxi;
		// 출력은 대문자로.
		}
		int cnt = 0;
		char kk = 0 ;
		for( char key : hashmap.keySet()) {
			//cnt =  (hashmap.get(key) == maxi) ? cnt + 1 : cnt;
			if (hashmap.get(key) == maxi){
				cnt += 1;
				kk = key;
			}
		}
		
		if (cnt >= 2) {
			System.out.println("?");
		}else {
			System.out.println(kk);
			}
		
	}
}
