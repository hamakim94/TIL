import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10769_행복한지슬픈지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int happy = 0;
        int sad = 0;
        for (int i = 0; i <= str.length() - 3; i++) {
            String substr = str.substring(i, i + 3);
            if (substr.equals(":-)")) {
                happy++;
            } else if (substr.equals(":-(")) {
                sad++;
            }
        } // end for
        String ans = "";
        if (happy == sad && happy == 0) {
            ans = "none";
        } else {
            if (happy == sad) {
                ans = "unsure";
            } else if (happy > sad) {
                ans = "happy";
            } else {
                ans = "sad";
            }

        }
        System.out.println(ans);

    }
}
