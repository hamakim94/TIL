import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20529_가장가까운세사람의심리적거리 {

    static String[] mbti;
    static int N;
    static int[] sel;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            answer = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            sel = new int[N];
            mbti = br.readLine().split(" ");
            if(N > 32){
                sb.append(0).append('\n');
            } else{
                combNToThree(0, 0);
                sb.append(answer).append('\n');
            }

        }
        System.out.println(sb);
    }

    private static void combNToThree(int level, int cnt) {
        if(cnt >= 3){
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<N; i++){
                if(sel[i] == 1) list.add(i);
            }
            cal(list);
            return;
        }
        for(int i=level; i < N; i++){
            if(sel[i] == 0){
                sel[i] = 1;
                combNToThree(i + 1, cnt + 1);
                sel[i] = 0;
            }

        }

    }

    private static void cal(List<Integer> list) {
        char[] one = mbti[list.get(0)].toCharArray();
        char[] two = mbti[list.get(1)].toCharArray();
        char[] three = mbti[list.get(2)].toCharArray();

        answer = Math.min(caculate(one, two)+ caculate(one, three)+caculate(two, three), answer);
    }

    static int caculate(char[] arr1, char[] arr2) {
        int level = 0;
        for(int i=0; i<4; i++){
            if (arr1[i] != arr2[i]) {
                level++;
            }
        }
        return level;
    }
}
