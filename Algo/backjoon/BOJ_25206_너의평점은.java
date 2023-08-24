import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_25206_너의평점은 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double sumScore = 0.0; // 학점만 저장
        double totalScore = 0.0; // 학점 * 점수

        for (int i = 0; i < 20; i++) {
            String[] scores = br.readLine().split(" ");
            if(scores[2].equals("P")) continue;
            double num = Double.parseDouble(scores[1]); // 학점
            sumScore += num;

            if (!scores[2].equals("F")) {

                totalScore += num*countScore(scores[2]);
            }
        }
        System.out.printf("%.6f", totalScore / sumScore);
    }

    static double countScore(String score) {
        switch (score) {
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
        }
        return 0.0;


    }
}
