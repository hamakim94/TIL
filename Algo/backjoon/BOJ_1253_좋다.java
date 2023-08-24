import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253_좋다 {
    static long[] num;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new long[N];
        answer = 0;
        for (int i = 0; i < N; i++) {
            num[i] = Long.parseLong(st.nextToken());
        } // end input
        Arrays.sort(num);
        for (int i = 0; i < N; i++) {
            twoPointer(i, N);
        }
        System.out.println(answer);
    }

    private static void twoPointer(int idx, int size) {
        long find = num[idx];
        int l = 0;
        int r = size - 1;
        while (l < r) {
            if (num[l] + num[r] == find) {
                if( l != idx && r != idx){
                    answer++;
                    break;
                } else if (l == idx){
                    l++;
                } else if (r == idx) {
                    r--;
                }
            } else if (num[l] + num[r] > num[idx]) {
                r--;
            } else{
                l++;
            }
        }
    }
}
