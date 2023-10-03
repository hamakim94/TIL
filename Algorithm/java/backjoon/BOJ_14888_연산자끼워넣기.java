import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {
    static int N;
    static int[] enumArr = new int[4];
    static int[] arr;
    static int maxi = Integer.MIN_VALUE;
    static int mini = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        // 현재 위치를 들고다니는 인덱스 level, 배열의 길이와 같아지면 out?!
        // 연산 결과를 가지고 다니는 result,
        // for문 돌면서, 0이면 continue, 1이면 1개 빼고 연산 하고 다음 재귀
        // 나오면서 다시 1 더해주는 느낌!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            enumArr[i] = Integer.parseInt(st.nextToken());
        } // end input
        cal(0,arr[0]);
        System.out.printf("%d\n%d", maxi, mini);

    }
    static void cal(int level, int value){
        // base case
        if(level == N-1){
            mini = Math.min(mini, value);
            maxi = Math.max(maxi, value);
            return;
        }

        for(int i=0; i<4; i++){
            if(enumArr[i] <= 0) continue;
            enumArr[i]--;
            cal(level + 1, calc(i, value, arr[level+1]));
            enumArr[i]++;

        }
    }
    static int calc(int idx, int num1, int num2){
        if(idx == 0){
            return num1 + num2;
        } else if (idx == 1){
            return num1 - num2;
        } else if (idx == 2){
            return num1 * num2;
        } else{
            return num1 / num2;
        }
    }
}
