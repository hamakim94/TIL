package BOJ_222219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_14696_딱지놀이 {
	public static void main(String[] args) throws IOException {
		// 0. input 받기 - arraylist에 더해주기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		ArrayList<Integer> A; // A의 딱지스
		ArrayList<Integer> B; // B의 딱지스
		String[] str; // br.readline을 split해서 얻은 String 배열을 저장할 주소
		int testCase = Integer.parseInt(br.readLine()); // testCase

		for (int k = 0; k < testCase; k++) {
			A = new ArrayList<>();
			B = new ArrayList<>();

			str = br.readLine().split(" ");
			int aSize = Integer.parseInt(str[0]); // a가 낼 것들의 사이즈
			for (int i = 1; i <= aSize; i++) {
				A.add(Integer.parseInt(str[i]));
			}
			str = br.readLine().split(" ");
			int bSize = Integer.parseInt(str[0]); // b가 낼 것들의 사이즈
			for (int i = 1; i <= bSize; i++) {
				B.add(Integer.parseInt(str[i]));
			}

			// 2. sort하기 ( 내림차순 )
			A.sort(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return -Integer.compare(o1, o2);
				}
			});
			B.sort(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return -Integer.compare(o1, o2);
				}
			});
			// 3. 인덱스 i, j를 돌면서
			// 4. while (i < A.length && j<B.length)
			int idxA = 0;
			int idxB = 0;
			String ans = "D";
			while (idxA < A.size() && idxB < B.size()) {
				// 4. 만약 A[i]== B[J} : i++, j++
				if (A.get(idxA) == B.get(idxB)) {
					idxA++;
					idxB++;
				}
				// 4. 만약 A[i] > B[J} : ans = "A"
				else if (A.get(idxA) > B.get(idxB)) {
					ans = "A";
					break;
					// 4. 만약 A[i] > B[J} : ans = "B"
				} else {
					ans = "B";
					break;
				}
			} // end while : search 완료

			// 다 똑같은데, 나와서 보니 A는 남아있고, B가 남아있을 수도 있으니
			if (ans == "D") {
				if (aSize > bSize) {
					ans = "A";
				} else if (aSize < bSize) {
					ans = "B";
				}
			}
			System.out.println(ans);

		}

	}
}
