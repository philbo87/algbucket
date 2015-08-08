package com.algorithms.chap11.problem8;

import java.util.HashSet;
import java.util.Set;

public class Problem8 {

	private SimpleList list;

	public static void main(String[] args) {
		Problem8 prob8 = new Problem8();
		prob8.track(1);
		prob8.track(1);
		System.out.println(prob8.getRankOfNumber(1));
	}

	public Problem8() {
		this.list = new SimpleList();
	}

	public void track(int x) {
		list.appendToHead(x);// O(1)
	}

	public int getRankOfNumber(int x) {
		ListNode n = list.getHead();
		int numberLessThanOrEqualTo = 0;
		boolean elementFound = false;
		while (n != null) {
			if (x == n.getData() && !elementFound) {
				elementFound = true;
				// Do Not count this one. We only do that once
			} else if (n.getData() <= x) {
				numberLessThanOrEqualTo++;
			}
			n = n.getNext();
		}

		return numberLessThanOrEqualTo;
	}
}
