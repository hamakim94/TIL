import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_18810_solvedac {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        int idx = (int) Math.round( ( (double) N * 15 / 100));
        int total = N - 2 * idx;
        int sum = 0;
        for (int i = idx; i < N - idx; i++) {
            sum += nums[i];
        }
        System.out.println(Math.round((double) sum / total));
    }

}
