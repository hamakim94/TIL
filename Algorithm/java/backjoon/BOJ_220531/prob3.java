package BOJ_220531;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class prob3 {
	static char[] arr = { 'A', 'S', 'A', 'D','A', 'D', 'A', 'S' };
	static Stack<Character> st = new Stack<>();
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		printyeah(0);
	}
	static void printyeah(int index) {
		// base case
		if(index == arr.length) {
			return;
		}
		
		// recursive case
		System.out.println(arr[index]);
		printyeah(index + 1);
		System.out.println(arr[index]);
	}

}
