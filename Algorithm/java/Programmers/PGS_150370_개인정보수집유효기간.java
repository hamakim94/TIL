import java.util.*;

class Solution {
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> ans = new ArrayList<>();
        
        int total = getDate(today);
        
        Map<String, Integer> map = new HashMap<>();
        for(String t : terms){
            String[] arr = t.split(" ");
            map.put(arr[0], Integer.parseInt(arr[1]));
        }
        
        for(int i=0, l = privacies.length; i< l; i++){
            String[] temp = privacies[i].split(" ");
            int dates = getDate(temp[0]) - 1;
            if(isExpired(dates, map, today, temp[1])){
                ans.add(i + 1);
            } 
        }
        int[] answer = new int[ans.size()];
        int idx = 0;
        for(int i : ans){
            answer[idx++] = i;
        }
        
        return answer;
    }
    
    boolean isExpired(int dates, Map<String, Integer> map, String today, String t){
        int now = getDate(today);
        int toAdd = map.get(t);
        dates += toAdd * 28;
        if(now > dates) return true;
        return false;
        
    }
    
    int getDate(String date){
        String[] tod = date.split("\\.");
        int year = Integer.parseInt(tod[0]);
        int month = Integer.parseInt(tod[1]);
        int day = Integer.parseInt(tod[2]);
        return year * 28 * 12 + month * 28 + day;
    }
}
