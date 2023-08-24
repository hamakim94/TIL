package BOJ_220314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941_크로아티아알파벳 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		
		// 해당 문자열을 돌면서
		String[] cro = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for(int i=0; i<cro.length; i++) {
			// 찾아서 바꿔주기
			word = word.replace(cro[i], "1");
		}
		// 길이 출력
		System.out.println(word.length());
		
		
	}
}
