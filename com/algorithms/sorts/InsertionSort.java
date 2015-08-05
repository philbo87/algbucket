package com.algorithms.sorts;

//O(N^2) because we are iterating through the elements N times in the outer loop, then up to N times in inner loop, so N*N = N^2
//But this is in place, so we take up only as much memory as the array and temp var, which is nice
public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = { 234, 544, 55, 1111, 90000, 1, 67, 99 };

		printArray(arr);

		int[] sortedArray = doInsertionSort(arr);
		printArray(sortedArray);
	}

	private static void printArray(int[] arr) {
		System.out.print("{ ");
		for (int a : arr) {
			System.out.print(a + ", ");
		}
		System.out.println("}");
	}

	public static int[] doInsertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
		}

		return arr;
	}
}
