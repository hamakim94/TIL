class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int l = 0;
        for(int r=0; r<nums.length; r++){
            if(nums[r]%2 == 0){
                int temp = nums[l];
                nums[l++] = nums[r];
                nums[r] = temp;
                
            }
        }
        return nums;
    }
}
