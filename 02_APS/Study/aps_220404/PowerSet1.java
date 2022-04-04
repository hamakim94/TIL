package aps_220404;

public class PowerSet1 {
	public static void main(String[] args) {
		// 결국 근본 생각은, 2진수로 표현하면, 그 자체 자리에 있고 없고가 다 나와버림!

		// 비트마스킹 이용
		int N = 4;
		int[] arr = { 1, 2, 3, 4 };

		// 비트를 활용하면 알아서 예쁘게, 있고 없고가 판단 가능해
		for (int i = 0; i < (1 << N); i++) {
			for (int j = 0; j < N; j++) {
				// 해당 i라는 이진수가 j번 이동했을 때 겹쳐? 그럼 있어, 그럼 뽑아
				if ((i & (1 << j)) > 0) {
					// 여기서 이진수가 나오는건 알겠는데, 그 자릿수별로 어떻게 뽑죠??
					// i : 1 1 0 0 , j가 쉬프트 하면서
					System.out.print(arr[j] + " ");
				}
				
			}
			System.out.println();
		}

	}
}
