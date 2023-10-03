import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2903_중앙이동알고리즘 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[16];
        dp[0] = 2;
        for (int i = 1; i <= 15; i++) {
            dp[i] = 2 * dp[i - 1] - 1;
        }
        System.out.println(dp[N] * dp[N]);

    }
}
