import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_N과M12 {

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> numArr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (!set.contains(now)) {
                set.add(now);
                numArr.add(now);
            }
        }
        Collections.sort(numArr);
        int[] arr = new int[set.size()];
        for (int i = 0; i < set.size(); i++) {
            arr[i] = numArr.get(i);
        }
        sel = new int[M];
        DFS(0, 0, arr);
        System.out.println(sb);

    }
    public static void DFS(int level, int before, int[] arr){
        if(level == M){
            for(int i : sel){
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = before; i< arr.length; i++){
            sel[level] = arr[i];
            DFS(level + 1, i, arr);
        }
    }
}
