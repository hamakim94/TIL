import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_25501_재귀의귀재 {
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            cnt = 0;
            String input = br.readLine();
            System.out.println(String.format("%d %d", isPalindrome(input), cnt) );
        }

    }
    public static int recursion(String str, int l, int r){
        cnt++;
        if(l >= r){
            return 1;
        } else if (str.charAt(l) != str.charAt(r)){
            return 0;
        } else{
            return recursion(str, l+1, r-1);
        }
    }
    public static int isPalindrome(String str){
        return recursion(str, 0, str.length() -1);
    }
}
