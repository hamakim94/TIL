import java.util.Arrays;

public class PGS_ü���� {
	class Solution {
	    public int solution(int n, int[] lost, int[] reserve) {
	        int answer = 0;
	        // 0�� ������, �տ� 2 �ִ��� Ȯ�� ������ 1���� 1�߰�, ��������
	        //           �ڿ� 2 �ִ��� Ȯ��, ������ 1���� 1�߰�, ��������
	        int[] students = new int[n+2];
	        for(int i=1; i<=n; i++){
	            students[i] = 1;
	        }
	        for(int idx : lost){
	            students[idx]--;
	        } // ������ 0 ==> �̶�� �����ؼ� Ʋ��
	        for(int idx : reserve){
	            students[idx]++;
	        } // ������ ������ 2 == > �̶�� �����ؼ� Ʋ��, ���� ���ǿ� ��Ʈ�� ��������
	        
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
