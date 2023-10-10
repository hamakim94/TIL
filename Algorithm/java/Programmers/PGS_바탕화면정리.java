import java.util.*;

class Solution {
    
    public int[] solution(String[] wallpaper) {
        // min, min, max, max 뺴서 더하기
        int row = wallpaper.length;
        int col = wallpaper[0].length();
        int minR, maxR, minC, maxC;
        
        minR = minC =  Integer.MAX_VALUE;
        maxR = maxC = Integer.MIN_VALUE;
        
        char[][] arr = new char[row][col];
        for(int r=0; r<row; r++){
            arr[r] = wallpaper[r].toCharArray();
        }
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(arr[i][j] == '#'){
                    minR = Math.min(minR, i);
                    minC = Math.min(minC, j);
                    maxR = Math.max(maxR, i+1);
                    maxC = Math.max(maxC, j+1);
                    
                }
            }
        }
        int[] answer = {minR, minC, maxR, maxC};
        return answer;
    }
}
