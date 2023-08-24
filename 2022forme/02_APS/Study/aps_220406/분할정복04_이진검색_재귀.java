package aps_220406;


public class 분할정복04_이진검색_재귀 {
	 
	
	static boolean binarySearch(int[] arr, int left, int right, int key) {
		
		if(left > right) return false;
				
		else {
			int mid = (left + right) / 2;
			
			if(key == arr[mid]) return true;
			
			else if (key < arr[mid])
				return binarySearch(arr, left, mid-1, key);
			else
				return binarySearch(arr, mid+ 1, right, key);
		}
			
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1,7,9,13,19,28,31,39,41};
		
		if(binarySearch(arr, 0, arr.length-1, 8)) {
			System.out.println("찾음");
		} else {
			System.out.println("못찾음");
		}
			
	}
	
}	

