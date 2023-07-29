import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2720_세탁소사장동혁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int money = Integer.parseInt(br.readLine());
            int[] changes = new int[4];
            countChange(changes, money);
            for (int i = 0; i < 4; i++) {
                sb.append(changes[i]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void countChange(int[] changes, int money) {
        if( money / 25 > 0) {
            int coins = money / 25;
            changes[0] += coins;
            money -= 25 * coins;
        }
        if (money / 10 > 0) {
            int coins = money / 10;
            changes[1] += coins;
            money -= 10 * coins;
        }
        if (money / 5 > 0) {
            int coins = money / 5;
            changes[2] += coins;
            money -= 5 * coins;
        }
        if (money> 0) {
            changes[3] += money;
            money -= money;
        }
    }
}
