import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_16139_인간컴퓨터상호작용 {
    static StringBuilder sb = new StringBuilder();
    static char[] charArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        charArr = br.readLine().toCharArray();
        int N = Integer.parseInt(br.readLine());
        int[][] cumSum = new int[26][charArr.length + 1];
        for(int idx = 0; idx < charArr.length; idx++){
            for(int i=0; i<26; i++){
                if( (charArr[idx]- 'a') == i){
                    cumSum[i][idx+1] = cumSum[i][idx]+1;
                } else{
                    cumSum[i][idx+1] = cumSum[i][idx];
                }
            }
        }

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            char now = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(cumSum[now - 'a'][end+1] - cumSum[now - 'a'][start]).append('\n');
        }
        System.out.println(sb);
    } // end main

}

