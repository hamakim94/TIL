import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10820_문자열분석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        StringBuilder sb= new StringBuilder();

        while ( (input = br.readLine()) != null){
            int small = 0;
            int big = 0;
            int space = 0;
            int number =0 ;

            char[] arr = input.toCharArray();
            for (char now : arr){
                if(now >= 'a' && now <= 'z'){
                    small++;
                } else if(now >= 'A' && now <= 'Z'){
                    big++;
                } else if(now == ' '){
                    space++;
                } else if(now >= '0' && now <= '9'){
                    number++;
                }
            } // end for
            sb.append(small).append(' ').append(big).append(' ').append(number).append(' ').append(space).append('\n');

        } // end while
        System.out.println(sb.toString());
        br.close();
    }
}
