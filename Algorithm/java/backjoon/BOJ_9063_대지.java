import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9063_대지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int miniX = Integer.MAX_VALUE;
        int maxiX = Integer.MIN_VALUE;
        int miniY = Integer.MAX_VALUE;
        int maxiY = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x > maxiX) {
                maxiX = x;
            }
            if (x < miniX) {
                miniX = x;
            }
            if (y > maxiY) {
                maxiY = y;
            }
            if (y < miniY) {
                miniY = y;
            }

        } // end for
        System.out.println((maxiX - miniX) * (maxiY - miniY));

    }
}
