package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2935_소음 {
	public static void main(String[] args) throws IOException {
		
		// 배열을 만들어서
		// 문자열 길이 - 1 
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String operator = br.readLine();
		String s2 = br.readLine();
		StringBuilder sb= new StringBuilder();
		
		if(operator.equals("*")) {
			int k = s1.length() -1 + s2.length()-1;
			sb.append(1);
			for(int i=0; i<k; i++) {
				sb.append(0);
			}
		} else {
			int maxSize = Math.max(s1.length()-1, s2.length()-1);
			int minSize = Math.min(s1.length()-1, s2.length()-1);
			if(maxSize == minSize) {
				sb.append(2);
				for(int k=maxSize; k>0; k--) {
					sb.append(0);
				}
			}else {
				sb.append(1);
				for(int k=maxSize; k>0; k--) {
					if(k == minSize + 1) {
						sb.append(1);
					} else {
						sb.append(0);
					}
					
				}
			}
			
		}
		System.out.println(sb.toString());
		
	}
}
