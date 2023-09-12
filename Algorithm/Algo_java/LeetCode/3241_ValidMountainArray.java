class Solution {
    public boolean validMountainArray(int[] arr) {
        int minIdx = 0;
        int maxIdx = arr.length -1;
        if(maxIdx + 1 < 3) return false;
        
        while(minIdx < arr.length-1 && arr[minIdx] < arr[minIdx+1]){
            minIdx++;
        }
        while(maxIdx >0 &&arr[maxIdx-1] > arr[maxIdx] ){
            maxIdx--;
        }
     
        return minIdx > 0 && maxIdx < arr.length - 1 && minIdx == maxIdx;
    }
}
