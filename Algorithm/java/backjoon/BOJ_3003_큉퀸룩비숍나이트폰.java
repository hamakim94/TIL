import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3003_큉퀸룩비숍나이트폰 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] chess = {1, 1, 2, 2, 2, 8};
        StringBuilder sb = new StringBuilder();
        for (int j : chess) {
            sb.append(j - Integer.parseInt(st.nextToken())).append(' ');
        }
        System.out.println(sb);
    }
}
