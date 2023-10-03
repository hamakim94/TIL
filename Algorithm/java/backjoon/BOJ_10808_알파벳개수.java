import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10808_알파벳개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[26];
        char[] charArr = br.readLine().toCharArray();
        for(char now : charArr){
            arr[now - 'a'] += 1;
        }
        for(int now : arr){
            sb.append(now).append(' ');
        }
        System.out.println(sb);

    }
}
