import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2580_스도쿠2 {

    static int[][] sudoku = new int[9][9];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0; i<9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        } // end input
        find(0,0);

    }
    static void find(int row, int col){
        if(col == 9){
            find(row + 1, 0);
            return;
        }
        if(row == 9){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    sb.append(sudoku[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }
        if(sudoku[row][col] == 0){
            for(int i=1; i<10; i++){
                if(possible(row,col,i)){
                    sudoku[row][col] = i;
                    find(row, col + 1);
                }
            }
            sudoku[row][col] = 0;
            return;
        }
        find(row, col+1);
    }
    static boolean possible(int row, int col, int value){
        for(int r=0; r<9; r++){
            if(sudoku[r][col] == value){
                return false;
            }
        } // 행 처리

        for(int c=0; c<9; c++){
            if(sudoku[row][c] == value){
                return false;
            }
        } // 열 처리

        int blockRow = row/3;
        int blockCol = col/3;
        for(int r = 3*blockRow; r<3*blockRow+3; r++){
            for(int c=3*blockCol; c<3*blockCol+3; c++){
                if(sudoku[r][c] == value){
                    return false;
                }
            }
        }
        return true;
    }

}
