import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2750_수정렬하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		// 배열 입력 완료
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			if(i == 0) {
				sb.append(arr[i]);
			} else {
				sb.append('\n').append(arr[i]);
			}
		}
		System.out.println(sb);
	}
}
