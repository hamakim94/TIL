class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int l = 0;
        int r = n - 1;
        int idx = n-1;
        
        while(l <= r){
            if(Math.abs(nums[l]) >= Math.abs(nums[r])){
                arr[idx--] = nums[l]*nums[l];
                l++;
            } else{
                arr[idx--] = nums[r]*nums[r];
                r--;
            }
        }
        return arr;
        
    }
}
