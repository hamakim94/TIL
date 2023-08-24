import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_색종이만들기2 {

    static int[] ans;

    public static void main(String[] args) throws IOException {

        ans = new int[2];// 하얀색0 또는 파란색1

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // end input

        DNQ(map, 0,0, N);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

    private static void DNQ(int[][] map, int startRow, int startCol, int size) {

        boolean flag = check(map, startRow, startCol, size);
        if (flag) {
            ans[map[startRow][startCol]]++;
        } else{
            DNQ(map, startRow, startCol, size / 2);
            DNQ(map, startRow, startCol + size/2, size / 2);
            DNQ(map, startRow +size / 2 , startCol, size / 2);
            DNQ(map, startRow + size / 2 , startCol+ size / 2 , size / 2);
        }
    }

    private static boolean check(int[][] map, int startRow, int startCol, int size) {
        if(size == 1){
            return true;
        }
        int temp = map[startRow][startCol];
        boolean flag = true;
        outer : for (int i = startRow; i < startRow+size; i++) {
            for (int j = startCol; j < startCol+size; j++) {
                if (map[i][j] != temp) {
                    flag = false;
                    break outer;
                }
            }
        }
        return flag;
    }
}
