package com.algorithms.sorts;

//O(n log n)
public class MergeSort {

	public static void main(String[] args) {
		int[] input = { 22, 33, 11, 4, 643, 9, 0, 234, 99, 100 };
		int[] output = mergeSort(input);
		for (int i : output) {
			System.out.print(" " + i);
		}
	}

	public static int[] mergeSort(int[] array) {
		if (array.length == 1) {
			return array;
			// Best case O(1)?
		}

		// Split the input into two halves
		int mdpt = array.length / 2;
		int[] left = new int[mdpt];
		int[] right;
		if (array.length % 2 == 0) {
			// Even length
			right = new int[mdpt];
		} else {
			// odd length
			right = new int[mdpt + 1];
		}

		int rightIndex = 0;
		for (int i = 0; i < array.length; i++) {
			if (i < mdpt) {
				left[i] = array[i];
			} else {
				right[rightIndex] = array[i];
				rightIndex++;
			}
		}

		left = mergeSort(left);
		right = mergeSort(right);

		return merge(left, right);
	}

	static int[] merge(int[] l, int[] r) {
		int totElem = l.length + r.length;
		int[] merged = new int[totElem];
		int mergedIndex, leftIndex, rightIndex;
		mergedIndex = leftIndex = rightIndex = 0;

		while (mergedIndex < totElem) {
			// If there are still elements to view in both right and left arrays
			if ((leftIndex < l.length) && (rightIndex < r.length)) {

				// If the current element in the left array is less than the
				// current element in the right array, set this index in merged
				// array to the current value in left array, and increment
				// left/merged indexes
				if (l[leftIndex] < r[rightIndex]) {
					merged[mergedIndex] = l[leftIndex];
					mergedIndex++;
					leftIndex++;
				} else {
					// Else, the current element in the right arrya is less than
					// the current element in the left array.
					// set this index in merged
					// array to the current value in right array, and increment
					// right/merged indexes
					merged[mergedIndex] = r[rightIndex];
					mergedIndex++;
					rightIndex++;
				}
			} else {
				// Else, at this point, we have exhausted one of these arrays.
				// Figure out which still has elements, and add them all in in
				// order to the result
				if (leftIndex >= l.length) {
					while (rightIndex < r.length) {
						merged[mergedIndex] = r[rightIndex];
						mergedIndex++;
						rightIndex++;
					}
				}
				if (rightIndex >= r.length) {
					while (leftIndex < l.length) {
						merged[mergedIndex] = l[leftIndex];
						leftIndex++;
						mergedIndex++;
					}
				}
			}
		}
		return merged;

	}
}
