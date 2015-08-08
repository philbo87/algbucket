package com.algorithms.chap11.problem8;

public class SimpleList {
	ListNode head;
	
	public SimpleList(){
		
	}
	
	public void appendToHead(int d){
		ListNode n = new ListNode(d);
		n.setNext(head);
		this.head=n;
	}
	
	public ListNode getHead(){
		return head;
	}
}
