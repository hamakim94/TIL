package BOJ_220427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5525_IOIOI50 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numAns = Integer.parseInt(br.readLine());
		int size = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int cnt = 0;
		String ans = "I";
		for(int i=0; i<numAns; i++) {
			ans += "OI";
		}
		for(int i=0; i<=size - ans.length(); i++) {
			if(ans.equals(str.substring(i, i + ans.length() ))){
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
