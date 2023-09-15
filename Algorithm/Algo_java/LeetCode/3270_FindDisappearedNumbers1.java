class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int[] counts = new int[n+1];
        for(int num : nums){
            counts[num]++;
        }
        for(int i=1; i<=n; i++){
            if(counts[i] == 0){
                list.add(i);
            }
        }
        return list;
    }
}
