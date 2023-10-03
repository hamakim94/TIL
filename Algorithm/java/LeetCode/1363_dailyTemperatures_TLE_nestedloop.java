class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 2 loop for : find till I get higher temperture
        int n = temperatures.length;
        for(int i=0; i<n; i++){
            int temp = 0;
            for(int j=i+1; j<n; j++){
                if(temperatures[i] < temperatures[j]){
                    temp = j - i;
                    break;
                }
            }
            temperatures[i] = temp;
        }
        return temperatures;
        
    }
}
