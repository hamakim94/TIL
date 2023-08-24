import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10798_세로읽기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[5][15];
        for (int i = 0; i < 5; i++) {
            char[] input = br.readLine().toCharArray();
            int idx = 0;
            for (char now : input) {
                arr[i][idx++] = now;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 5; i++) {
                if(arr[i][j] ==  0) continue;
                sb.append((char) arr[i][j]);
            }
        }
        System.out.println(sb);

    }

}
