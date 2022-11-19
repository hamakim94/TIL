import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_N과M11 {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] sel;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sel = new int[M];
        ArrayList<Integer> arr = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            if(!set.contains(now)){
                arr.add(now);
                set.add(now);
            }
        }
        Collections.sort(arr);
        int[] newArr = new int [set.size()];
        for(int i=0; i< set.size(); i++){
            newArr[i] = arr.get(i);
        }
        DFS(0, newArr, M);
        System.out.println(sb);

    }
    static void DFS(int level, int[] arr, int m){
        // base case
        if(level == m){
            for(int now : sel){
                sb.append(now).append(' ');
            }
            sb.append('\n');
            return;
        }
        // recursive case
        for(int i=0; i<arr.length; i++){
            sel[level] = arr[i];
            DFS(level + 1, arr, m);
        }
    }
}
