package BOJ_220603;

public class study {

	public static void main(String[] args) {
		DFS(0);
	}

	private static void DFS(int idx) {
		if (idx == 2) {
			return;
		}
		for (int i = 0; i < 2; i++) {
			System.out.print(idx);
			DFS(idx + 1);
			System.out.print(idx);
		}

	}
}
