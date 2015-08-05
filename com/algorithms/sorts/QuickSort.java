package com.algorithms.sorts;

public class QuickSort {

	public static void main(String[] args){
		int[] a = {11,1,12,44,97,2};
		quickSort(a, 0, a.length-1); 
		System.out.print("{");
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]+ " ");
		}
		System.out.print("}");
	}
	
	private static void quickSort(int[] a, int low, int high){
		if(low < high){
			int q = partition(a, low, high);
			quickSort(a, low, q-1);
			quickSort(a, q+1, high);
		}
	}

	private static int partition(int[] a, int low, int high) {
		int pivotIndex = high;//last value
		int pivotValue = a[pivotIndex];
		
		int wallIndex = low;//this is the index of the wall, we will manipulate it
		for(int i=low; i<=high-1;i++){
			//if the current value of i is less than or equal to pivot value, switch them, and increment the partition index (the wall)
			if(a[i] <= pivotValue){
				int temp = a[i];
				a[i] = a[wallIndex];
				a[wallIndex] = temp;
				
				wallIndex++;
			}
		}
		
		//swap A[storeIndex] and A[high] 
		//move pivot to the final place
		int temp = a[wallIndex];
		a[wallIndex] = a[high];
		a[high] = temp;
		
		return wallIndex;
	}
}
