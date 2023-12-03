1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        for(int ing : ingredient){
            list.add(ing);
            if(list.size() >= 4){
                int n = list.size();
                if(list.get(n-1) == 1 && list.get(n-2) == 3 && list.get(n-3) == 2 && list.get(n-4) == 1){
                    answer++;
                    list.remove(n-4);
                    list.remove(n-4);
                    list.remove(n-4);
                    list.remove(n-4);
                } 
            }
        }


        return answer;
    }
}

