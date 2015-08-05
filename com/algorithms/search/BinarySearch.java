package com.algorithms.search;

public class BinarySearch {

	// O(log n) The iterative halving of data sets produces a growth curve that
	// peaks at the beginning and slowly flattens out as the size of the data increases
	// https://rob-bell.net/2009/06/a-beginners-guide-to-big-o-notation/
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		binarySearch(array, 2, 0, array.length);
	}

	public static void binarySearch(int[] array, int valueSearchingFor, int low, int high) {
		if (high < low) {
			System.out.println("ERROR high < low");
			return;
		}

		int mid = (low + high) / 2;

		if (array[mid] > valueSearchingFor) {
			// Value is in the left half
			binarySearch(array, valueSearchingFor, 0, mid - 1);
		} else if (array[mid] < valueSearchingFor) {
			// Value is in the right half
			binarySearch(array, valueSearchingFor, mid + 1, high);
		} else {
			// Midpoint is:
			System.out.println("Value " + valueSearchingFor + " found at position " + mid + " (positions 0 indexed)");
		}
	}

}
