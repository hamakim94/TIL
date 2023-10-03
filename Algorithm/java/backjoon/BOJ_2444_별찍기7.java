import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2444_별찍기7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 2*N; i++) {
            for (int j = 0; j < Math.abs(N-i); j++) {
                sb.append(' ');
            }

            if (i <= (2*N)/2) {
                for (int j = 0; j < 2 * i - 1; j++) {
                    sb.append('*');
                }
            } else {
                for (int j = 0; j < 2 * (2 * N - i)-1; j++) {
                    sb.append('*');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }
}
