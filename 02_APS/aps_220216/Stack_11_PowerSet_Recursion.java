package aps_220216;

public class Stack_11_PowerSet_Recursion {

	static boolean[] sel = new boolean[4]; // 재료
	static String[] ingre = { "단무지", "당근", "참치", "햄" };

	public static void main(String[] args) {
		powerset(0);
		
	}

	// 몇 번째 재료를 건드리고 있는지..
	public static void powerset(int idx) {
		// 기본 파트
		if (idx == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				if (sel[i]) {
					System.out.print(ingre[i]);
				}

			}
			System.out.println(":김밥");
			return;
		}

		// 재귀 파트
		
		// 뽑고 가고
		sel[idx] = true;
		powerset(idx + 1);
		// 안뽑고 가고
		sel[idx] = false;
		powerset(idx + 1);
		
		
	}
}
