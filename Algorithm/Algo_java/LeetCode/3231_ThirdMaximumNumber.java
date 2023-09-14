class Solution {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        
        for(int n : nums){
            if(first == n || second == n || third == n ) continue;

            if(first <= n){
                third = second;
                second = first;
                first = n;
            } else if (second <= n){
                third = second;
                second = n;
            } else if (third <= n){
                third = n;
            }
        }

        if (third != Long.MIN_VALUE) return (int) third;
        return (int) first;
        
    }
}
