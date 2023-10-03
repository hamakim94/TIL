import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11005_진법변환2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int base = Integer.parseInt(st.nextToken());
        System.out.println(baseTenToNum(num, base));
    }

    private static String baseTenToNum(int num, int base) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int number = num % base;
            char toAppend = numToChar(number);
            sb.append(toAppend);
            num /= base;
        }
        return sb.reverse().toString();
    }

    private static char numToChar(int num) {
        if (num >= 10) {
            return (char) (num +55);
        } else{
            return (char) (num+48);
        }
    }
}
