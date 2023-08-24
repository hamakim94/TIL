import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1120_문자열 {
    public static void main(String[] args) throws IOException {
        // 1. 개수가 같을 때, 그냥 for문 돌리기
        // 2. 개수가 다를 때
        // 작은거(2), 큰게 있어(4)
        // 큰거 for문 도는데, 작은거 만큼 돌아야함
        // 길이가 4 -> 0,1 / 1,2 / 2,3  4-2 만큼!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        char[] small = input[0].toCharArray();
        char[] big = input[1].toCharArray();
        int S = small.length;
        int B = big.length;
        int ans = Integer.MAX_VALUE;
        for(int i=0; i< B - S + 1; i++ ){
            int cnt = 0;
            for(int j=i; j< i+S; j++){
                if(small[j-i] != big[j]) cnt++;
            }
            ans = Math.min(cnt, ans);
        }
        System.out.println(ans);

    }

}
