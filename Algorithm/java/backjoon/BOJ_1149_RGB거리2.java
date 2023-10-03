import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] rgb = new int[3][N];
        int[][] dp = new int[3][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                rgb[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = rgb[0][0];
        dp[1][0] = rgb[1][0];
        dp[2][0] = rgb[2][0];

        System.out.println(getMin(rgb, dp, N));

    }

    private static int getMin(int[][] rgb, int[][] dp, int size) {
        for(int i=1; i<size; i++){
            dp[0][i] = Math.min(dp[1][i - 1], dp[2][i - 1]) + rgb[0][i];
            dp[1][i] = Math.min(dp[0][i - 1], dp[2][i - 1]) + rgb[1][i];
            dp[2][i] = Math.min(dp[0][i - 1], dp[1][i - 1]) + rgb[2][i];
        }
        return Math.min(Math.min(dp[0][size-1], dp[1][size-1]), dp[2][size-1]);
    }
}
