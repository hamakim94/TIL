package PGS_220509;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PGS_42890_후보키 {
	
	class Solution {
	    public int solution(String[][] relation) {
	        // ArrayList<String> ans : 후보키 열을 담는 공간
	        // 비트마스킹을 이용한 부분집합을 통해서, 1<<열 만큼 돌릴거고
	        // HashSet을 만들어서
	            // 행을 돌면서 StringBuilder로 이용해서
	                // 만약 열 크기만큼 shift했을 때 교집합이 0이 아니라면(있다)
	                // StringBuilder에 relation[][]을 추가. ( 2개가 겹친 경우는, 2개가 동시에 되겠지)
	            // StringBuilder로 합쳐진 문자열을 HashSet에 toString해서 추가
	            // 만약에 HashSet의 size가 행과 같고, 이전에 쓰이지 않았으면(함수 만들거얌)
	            // ans에 해당 열을 추가한다
	        int answer = 0;
	        int row = relation.length;
	        int col = relation[0].length;
	        List<Integer> ans = new ArrayList<>();
	        // i : 열
	        for(int i=0; i < (1<<col); i++){
	            Set<String> set = new HashSet<>();
	            // j : 행
	            for(int j=0; j< row; j++){
	                StringBuilder sb = new StringBuilder();
	                for(int k=0; k<col; k++){
	                    if( (i & (1<<k)) != 0){
	                        sb.append(relation[j][k]);
	                    }
	                }
	                set.add(sb.toString());
	            }
	            if(set.size() == row && isUsed(i, ans)){
	                ans.add(i);
	            }
	        }
	        answer = ans.size();
	        return answer;
	    }
	    // 함수에 관해서
	    // ans의 크기만큼 for문을 돌면서
	    // ans.get(i) & 정답열 == ans.get(i) , 즉 모든 이진수가 똑같다면(수가 일치한다면)
	    // 해당 열은 이미 후보키로 쓰였으므로 return false
	    // return true
	    public boolean isUsed(int idx, List<Integer> ans){
	        for(int i=0; i<ans.size(); i++){
	            if( (ans.get(i) & idx) == ans.get(i) ) return false;
	        }
	        return true;
	    }
	    
	}

}
