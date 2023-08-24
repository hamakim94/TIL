import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11660_구간합구하기5_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(st.nextToken());
        int lineSize = Integer.parseInt(st.nextToken());

        int[][] sum = new int[size + 1][size + 1];

        for (int i = 1; i <= size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= size; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        } // 누적합 end
        for (int i = 0; i < lineSize; i++) {
            st = new StringTokenizer(br.readLine());
            int sRow = Integer.parseInt(st.nextToken());
            int sCol = Integer.parseInt(st.nextToken());
            int eRow = Integer.parseInt(st.nextToken());
            int eCol = Integer.parseInt(st.nextToken());

            sb.append(sum[eRow][eCol] - sum[eRow][sCol - 1] - sum[sRow-1][eCol] + sum[sRow-1][sCol-1]).append('\n');


        }
        System.out.println(sb);
    }
}
