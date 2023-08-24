import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_10867_중복뺴고정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		List<Integer> arr = new ArrayList<>(set);
		arr.sort((a1, b1) -> a1 - b1);
		StringBuilder sb = new StringBuilder();
		for(int element : arr) {
			sb.append(element).append(' ');
		}
		System.out.println(sb.toString());
	}
}
