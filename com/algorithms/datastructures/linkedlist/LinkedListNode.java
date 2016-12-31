package com.algorithms.datastructures.linkedlist;

public class LinkedListNode {

	private int unhashedKey;
	private LinkedListNode prev;
	private LinkedListNode next;
	
	public int getUnhashedKey() {
		return unhashedKey;
	}
	public void setUnhashedKey(int unhashedKey) {
		this.unhashedKey = unhashedKey;
	}
	public LinkedListNode getPrev() {
		return prev;
	}
	public void setPrev(LinkedListNode prev) {
		this.prev = prev;
	}
	public LinkedListNode getNext() {
		return next;
	}
	public void setNext(LinkedListNode next) {
		this.next = next;
	}
}
