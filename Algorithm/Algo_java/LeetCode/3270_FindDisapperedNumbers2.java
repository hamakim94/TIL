class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        int idx;
        for(int i=0; i<n; i++){
            idx = Math.abs(nums[i]) -1;
            if(nums[idx] < 0) continue;
            nums[idx] *= -1;
        }
        
        for(int i=0; i<n; i++){
            if(nums[i] > 0){
                list.add(i+1);
            }
        }
        return list;
    }
}
