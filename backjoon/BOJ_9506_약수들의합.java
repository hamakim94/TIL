import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_9506_약수들의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if(num ==  -1) break;
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            for (int i = 1; i <= num / 2; i++) {
                if (num % i == 0) {
                    sum += i;
                    list.add(i);
                }
            }

            if (sum == num) {
                sb.append(num).append(' ').append('=').append(' ');
                for (int i = 0; i < list.size(); i++) {
                    if (i == list.size() - 1) {
                        sb.append(list.get(i)).append('\n');
                        break;
                    }
                    sb.append(list.get(i)).append(" + ");
                }

            } else{
                sb.append(num).append(" is NOT perfect.\n");
            }
        } // end while
        System.out.println(sb);
    }
}
