package backjoon_220131;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class backjoon_2920_음계 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int res_asec = 0;
		int res_desc = 0;

		for (int i = 1; i < 9; i++) {
			int k = Integer.parseInt(st.nextToken());
			if (i == k) {
				res_asec += 1;
			}
			if (9 - i == k) {
				res_desc += 1;
			}
		}

		if (res_asec == 8) {
			System.out.println("ascending");
		} else if (res_desc == 8) {
			System.out.println("descending");
		} else
			wr.write("mixed");
		wr.close();
		br.close();

	}
}
