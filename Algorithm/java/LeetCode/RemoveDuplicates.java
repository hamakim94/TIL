class Solution {
    public int removeDuplicates(int[] nums) {
        // 전거랑만 비교하다가
        // 달라지는 순간, idx에 다시 넣으면 되는거 아니야?
        // 내 상태를 가지고 있고
        int idx = 1;
        int status = nums[0];
        for(int i=0, n = nums.length-1; i<n; i++){
            if(nums[i] != nums[i+1]){
                nums[idx++] = nums[i+1];
            }
        }
        return idx;
    }
}
