import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for(int t=0; t<tc; t++){
            int size = Integer.parseInt(br.readLine());
            int[][] scores = new int[2][size + 1];
            int[][] dp = new int[2][size+1];
            for(int i=0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=size; j++){
                    scores[i][j] = Integer.parseInt(st.nextToken());
                }
            } // input 완료
            dp[0][1] = scores[0][1];
            dp[1][1] = scores[1][1];

            for(int k=2; k<=size; k++){
                dp[0][k] = Math.max(dp[1][k-1], dp[1][k-2]) + scores[0][k];
                dp[1][k] = Math.max(dp[0][k-1], dp[0][k-2]) + scores[1][k];
            }
            System.out.println(Math.max(dp[0][size], dp[1][size]));
        }
    }
}
