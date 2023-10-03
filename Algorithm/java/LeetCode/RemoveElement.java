class Solution {
    public int removeElement(int[] nums, int val) {
        int answer = 0;
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            if(nums[i] == val) answer++;
        }
        
        for(int l=0; l<n; l++){
            if(nums[l] == val){
               
                int r = n-1;
                while(l < r){
                    if(nums[r] != val){
                        swap(nums, l, r);
                    }
                    r--;
                }
            }
        }
        return n - answer;
    }
    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
