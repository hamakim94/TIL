class Solution {
    public int[] sortedSquares(int[] nums) {
        int N = nums.length;
        for(int i=0; i<N; i++){
            nums[i] = nums[i]*nums[i];
        }
        
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                if(nums[i] > nums[j]){
                    swap(nums, i, j);
                }
            }
        }
        return nums;
    }
    
    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
