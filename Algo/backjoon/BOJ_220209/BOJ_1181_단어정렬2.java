package BOJ_220209;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class BOJ_1181_단어정렬2 {
	public static void main(String[] args) {
		// 일단 생각
		// 길이 순으로 나타내야 하니까..

		// 그다음 보자
		Scanner sc = new Scanner(System.in);
		// 문자 개수
		int n = sc.nextInt();

		ArrayList<String> beforeArr = new ArrayList<>();
		for(int i =0; i<n; i++) {
			beforeArr.add(sc.next());
		}
		sc.close();
		
		HashSet<String> set = new HashSet<>(beforeArr);
		ArrayList<String> arr = new ArrayList<>(set);
		
		System.out.println(arr.toString());
		// 문자 길이로 정렬하기
		// 버블정렬
		for(int i=0; i<arr.size()-1; i++) {
			for(int j=i+1)
			
		}

	}

}
