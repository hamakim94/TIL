import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1251_단어나누기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = br.readLine().toCharArray();

        PriorityQueue<String> queue = new PriorityQueue<>();

        for (int i = 0; i < charArr.length - 2; i++) {
            for (int j = i + 1; j < charArr.length - 1; j++) {
                for (int k = j + 1; k < charArr.length; k++) {
                    String ans = "";
                    for (int sidx = j - 1; sidx >= 0; sidx--) {
                        ans += charArr[sidx];
                    }
                    for (int midx = k - 1; midx >= j; midx--) {
                        ans += charArr[midx];
                    }
                    for (int eidx = charArr.length - 1; eidx >= k; eidx--) {
                        ans += charArr[eidx];
                    }
                    queue.add(ans);
                }
            }
        }
        System.out.println(queue.peek());
    }
}
