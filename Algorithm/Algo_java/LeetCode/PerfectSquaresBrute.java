class Solution {
    public int numSquares(int n) {
        
        if(n < 4) {
            return n;
        }
        
        int ans = n;
        
        for(int i=1; i*i <= n; i++){
            int square = i*i;
            ans = Math.min(ans, 1 + numSquares(n - square));
        }
        return ans;
        
    }
}
