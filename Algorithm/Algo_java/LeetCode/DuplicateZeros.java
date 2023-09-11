class Solution {
    public void duplicateZeros(int[] arr) {
        int size = arr.length;
        for(int i=0; i<size; i++){
            if(arr[i] == 0 ){
                if(i == size - 1) break;
                push(i, arr);
                i++;
            }
        }
    }
    
    void push(int idx, int[] arr){
        int size = arr.length;
        for(int i=size-1; i>idx; i--){
            arr[i] = arr[i-1];
        }
    }
}
