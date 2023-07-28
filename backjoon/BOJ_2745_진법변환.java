import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2745_진법변환 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] nums = st.nextToken().toCharArray();
        int base = Integer.parseInt(st.nextToken());
        System.out.println(numsToTen(nums, base));
    }

    private static int numsToTen(char[] nums, int base) {
        int answer = 0;
        // 각각 하나의 char 마다
        // base씩을 곱해줘야 한다.
        // 그런데 해당 수가 A를 넘어간 시점부턴, A부턴 11로 세야한다.
        int degree = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int now = nums[i];
            if (now - 'A' >= 0) {
                now = nums[i] - 55;
            } else {
                now = nums[i] - '0';
            }
            answer += now * Math.pow(base, degree++);
        }
        return answer;

    }
}
