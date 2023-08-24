package aps_220214;

import java.util.Arrays;

public class String_문자열뒤집기 {
	public static void main(String[] args) {
		//문자열 뒤집기
		//1. 뒤에서부터 읽어서 확인
		//2. swap (절반만큼만 swap)
		//3. Stringbuilder, StringBuffer
		
		String text = "나는바보다";
		
		//1. 뒤에서 읽기 (다보바는나)
		for(int i=text.length()-1; i>=0; i--) {
			System.out.println(text.charAt(i));
		}
		//2. swap
		char[] arr = text.toCharArray();
		
		int len = text.length();
		
		for(int i =0; i<len/2; i++) {
			char tmp = arr[i];
			arr[i] = arr[len - 1 - i];
			arr[len-1-i] = tmp;
		}
		System.out.println(Arrays.toString(arr));
		
		// Stringbuilder
		StringBuilder sb = new StringBuilder();
		sb.append(text);
		sb.reverse();
		System.out.println(sb);
		
		
	}
}
