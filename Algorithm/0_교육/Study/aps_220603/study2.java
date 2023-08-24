package BOJ_220603;

public class study2 {
	
	static int n = 3;
	static int[] arr = new int[10];
	
	public static void main(String[] args) {
		DFS(0, 0);
	}

	private static void DFS(int lev, int sum ) {
		if(lev == n) {
			for(int i=0; i<n; i++) {
				System.out.print(arr[i]);
				
			}
			System.out.println(" sum : " + sum);
			return;
		}
		
		for (int i = 0; i < 6; i++) {
			arr[lev] = i+1;
			DFS(lev + 1, sum + i+1); 
		}

	}
}
