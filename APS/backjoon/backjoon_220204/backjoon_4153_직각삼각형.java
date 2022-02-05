package backjoon_220204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class backjoon_4153_직각삼각형 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			//입력값 충 최대값을 찾아야함
			ArrayList<Integer> arr = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a + b + c == 0)
				break;
			arr.add(a);
			arr.add(b);
			arr.add(c);
			Collections.sort(arr);
			
			if (arr.get(0) * arr.get(0) + arr.get(1) * arr.get(1) == arr.get(2) * arr.get(2)) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
		br.close();

	}
}
