class Solution {
    public String solution(int a, int b) {
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] d = {"FRI","SAT", "SUN","MON","TUE","WED","THU"};
        int now = -1;
        for(int i=0; i<a-1; i++){
            now += days[i];
        }
        now += b;
        return d[now%7];
    }
}
