import java.util.*;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxi = 0;
        for(int i=1; i<nums.length ; i++){
            if(nums[i] == 1){
                nums[i] = nums[i-1] + nums[i];
            } 
        }
        for(int i=0; i<nums.length ; i++){
           if(maxi < nums[i]){
               maxi = nums[i];
           }
        }
        
        return maxi;
    }
}
