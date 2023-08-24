import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2018_연속된자연수의합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int start = 1;
        int end = 1;
        long sum = 1; // 기본값
        int count = 0;
        while(end <= N){
            if(sum == N){
                count++;
                sum -= start++;
            } else if (sum > N){
                sum -= start++;
            } else {
                sum += ++end;
            }
        }
        System.out.println(count);


    }
}
