import java.util.Arrays;

public class PGS_체육복 {
	class Solution {
	    public int solution(int n, int[] lost, int[] reserve) {
	        int answer = 0;
	        // 0을 만나면, 앞에 2 있는지 확인 있으면 1감소 1추가, 다음으로
	        //           뒤에 2 있는지 확인, 있으면 1감소 1추가, 다음으로
	        int[] students = new int[n+2];
	        for(int i=1; i<=n; i++){
	            students[i] = 1;
	        }
	        for(int idx : lost){
	            students[idx]--;
	        } // 없으면 0 ==> 이라고 생각해서 틀림
	        for(int idx : reserve){
	            students[idx]++;
	        } // 여유분 있으면 2 == > 이라고 생각해서 틀림, 문제 조건에 힌트가 나와있음
	        
	        for(int num=1; num<=n; num++){
	            if(students[num] == 0){
	                if(students[num-1] == 2){
	                    students[num-1]--;
	                    students[num]++;
	                    continue;
	                }
	                if(students[num+1] == 2){
	                    students[num+1]--;
	                    students[num]++;
	                    continue;
	                } 
	            } 
	            
	        }
	        for(int i=1; i<=n ; i++){
	            if(students[i] >= 1){
	                answer++;
	            }
	        }
	        return answer;
	    }
	}
