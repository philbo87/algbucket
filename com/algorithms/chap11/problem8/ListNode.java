package com.algorithms.chap11.problem8;

public class ListNode {
	private ListNode next;
	private int data;
	

	public ListNode(int d) {
		this.data=d;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}
