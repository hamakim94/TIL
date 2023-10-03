import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10986_나머지합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int mok = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] sums = new long[size + 1];
        long[] count = new long[mok];
        long answer = 0;
        for (int i = 1; i <= size; i++) {
            // 구간합을 M으로 나눈 나머지를 구한다.
            sums[i] = (sums[i - 1] + Long.parseLong(st.nextToken())) % mok;
            if(sums[i] == 0) answer++;
            count[(int)sums[i]]++;
//            내 틀린 풀이
//            for(int j=0; j<i; j++){
//                if ((sums[i] - sums[j]) % mok == 0) {
//                    answer++;
//                }
//            }
        }

        for(int i=0; i<mok; i++){
            if(count[i] <= 1) continue;
            long tempCnt = count[i];
            answer += (tempCnt * (tempCnt - 1)) / 2;
        }
        System.out.println(answer);

    }
}
