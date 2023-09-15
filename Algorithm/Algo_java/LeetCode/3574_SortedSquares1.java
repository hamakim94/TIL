class Solution {
    public int[] sortedSquares(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : nums){
            pq.add(n*n);
        }
        for(int i=0; i<nums.length; i++){
            nums[i] = pq.poll();
        }
        return nums;
    }
}
