import java.util.HashSet;
import java.util.Scanner;

public class SWEA_1244_최대상금_final {

	// 2번 바꿨는데
	// 처음 왔던 숫자로 되돌아 간다면
	// 무적권 갈 수 있는 숫자 아니야?
	// 만약 되돌아오면, 더 탐색 할 필요 없지 않아?
	// swap.. 진짜 너무 더러움
	static HashSet<Integer> setOdd, setEven; // 홀수/짝수번 수 바꾼 후 저장
	static int start, cnt, ans;

	public static void main(String[] args) {
		// 결국 각 상황별로 조합을 만들어야 하네
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int tc = 1; tc <= N; tc++) {
			start = sc.nextInt();
			setOdd = new HashSet<>();
			setEven = new HashSet<>();
			// 숫자 배열을 쪼개서, 이걸 들고다닐거야
			String[] arr = (start + "").split("");
			cnt = sc.nextInt(); // 횟수
			ans = 0;
			go(arr, 0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void go(String[] arr, int count) {
		// base case
		if (count == cnt) {
			if (cnt % 2 == 0) { // 짝수번 switch한거중에 최대찾고
				for (int k : setEven) {
					ans = Math.max(ans, k);
				}
			} else { // 홀수면 홀수번 switch한거중에 최대찾아
				for (int k : setOdd) {
					ans = Math.max(ans, k);
				}
			}

			return;
		}

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				swap(i, j, arr);// swap 했음
				String tempStr = ""; // 임시 문자열 생성
				for (int k = 0; k < arr.length; k++) {
					tempStr += arr[k];
				}
				int tempNum = Integer.parseInt(tempStr); // 숫자로
				// count 0일때, 1번 바꾼거
				if (count % 2 == 0) {
					// 만약, 기존에 없던걸 추가한다면!!!
					if (setOdd.add(tempNum)) { 
						go(arr, count + 1); // swap 한 배열 갖고 내려가
						swap(i, j, arr); // 그거 끝났으면 다시 swap해서 원본 돌려놔
					} else {
						swap(i, j, arr); // 이미 swap은 했으니까, 다시 원본으로 해
					}   // 이거 안 해서 1시간 반정도 날림
				} else {
					if (setEven.add(tempNum)) {
						go(arr, count + 1);
						swap(i, j, arr);
					} else {
						swap(i, j, arr);
					}
				}

			}
		}

	}
	// 주소니까,, 이게 void로 그냥 가능하네연..
	static void swap(int i, int j, String[] arr) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
