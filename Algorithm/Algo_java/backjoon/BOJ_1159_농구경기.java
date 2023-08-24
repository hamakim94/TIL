import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1159_농구경기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] chars = new int[26];
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String now = br.readLine();
            chars[now.charAt(0) - 'a']++;
        } // end for : 입력 완료
        for(int i=0; i<26; i++){
            if(chars[i] >= 5){
                sb.append((char) (i+'a'));
            }
        }
        if(sb.length() == 0){
            System.out.println("PREDAJA");
        } else{
            System.out.println(sb);
        }
    }
}
