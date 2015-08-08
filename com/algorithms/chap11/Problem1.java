package com.algorithms.chap11;

public class Problem1 {
	public static void main(String[] args) {
		int[] a = {10,20,0,0};//0s are buffer
		int[] b = {1,21};
		merge(a,b,2,b.length);
	}
	
	public static int[] merge(int[] a, int[] b, int lastA, int lastB){
		int indexA = lastA -1;
		int indexB = lastB -1;
		int indexMerged = lastB + lastA-1;
		
		while(indexB >= 0){
			//end of a is less than end of b
			if(indexA >= 0 && a[indexA] > b[indexB])
			{
				a[indexMerged] = a[indexA];
				indexA--;
			}else{
				a[indexMerged] = b[indexB];
				indexB--;
			}
			indexMerged--;
		}
		
		return a;
	}
}
