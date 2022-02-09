package backjoon_220131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class backjoon_3052_나머지 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Set<Integer> res = new HashSet<>();

		for (int i = 0; i < 10; i++) {
			res.add(Integer.parseInt(br.readLine()) % 42);
		}
		System.out.println(res.size());

		br.close();

	}
}
