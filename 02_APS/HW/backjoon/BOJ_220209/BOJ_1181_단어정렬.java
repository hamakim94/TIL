package BOJ_220209;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ_1181_단어정렬 {
	public static void main(String[] args) {
		// 일단 생각
		// 길이 순으로 나타내야 하니까..

		// 그다음 보자
		Scanner sc = new Scanner(System.in);
		// 문자 개수
		int n = sc.nextInt();
		// 1.char로 받아서 string으로 이어붙이기
		// 2. 그럼 int array를 만들어서 , 이어붙인 string들을 parseint해서 넣어주자
		long[] arr1 = new long[n];
		String now;
		for (int i = 0; i < n; i++) {
			now = sc.next().toUpperCase();
			String k = "";
			for (int j = 0; j < now.length(); j++) {
				k += (now.charAt(j) + 0);
			}
			arr1[i] = Long.parseLong(k);
			// System.out.println(k);
		}
		// System.out.println(Arrays.toString(arr1));
		// 중복제거
		// 해쉬맵으로, key값으로 long을 넣어주고
		HashMap<Long, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < arr1.length; i++) {
			hashMap.put(arr1[i], 0);
		}
		// 어레이리스트를 만들어서
		ArrayList<Long> aryList = new ArrayList<>();
		// key 요소를 하나 만들어서 aryList에 더해주고
		for (long key : hashMap.keySet()) {
			aryList.add(key);
		}
		// 문제에 필요한 배열을 구한다.
		Long[] arr = new Long[aryList.size()];
		for (int i = 0; i < aryList.size(); i++) {
			arr[i] = aryList.get(i);
		}

		// 선택정렬
		// 3. 해당 최소값에 인덱스, 현재 인덱스를 swap
		for (int i = 0; i < arr.length - 1; i++) {
			// 1. 첫 번째 선택
			int currentIdx = i;
			// 2. 뒤에 반복문 돌면서, 최소값 찾아
			int minIdx = i;
			for (int j = i + 1; j < arr.length; j++) {
				// 최소 인덱스 찾기
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				} // end if :
			} // end for 최소 인덱스까지 찾았어
				// swap
			long temp = arr[currentIdx];
			arr[currentIdx] = arr[minIdx];
			arr[minIdx] = temp;
		} // end for. 정렬 완
			// System.out.println(Arrays.toString(arr));

		// 해야할 일
		// 1. 정렬된 새로운 배열에서 요소 하나씩 접근
		for (int i = 0; i < arr.length; i++) {
			// 2. String으로 만들어 2칸씩 떼기
			String k = arr[i] + "";
			int max_index = k.length();
			int index = 0;
			String tmp = "";
			while (index < max_index) {
				// 2-1. 그걸 char로.
				// 2-2. 숫자 x를 더해서 소문자로 // A : 65, a : 97 : +32
				// 2-3. 빈 String에 += 해서 이어붙여준다
				tmp += (char) (Integer.parseInt(k.substring(index, index + 2)) + 32);
				index += 2;
			}
			System.out.println(tmp);
		}

	}
}
