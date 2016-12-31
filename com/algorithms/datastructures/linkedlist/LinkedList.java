package com.algorithms.datastructures.linkedlist;

public class LinkedList {

	private LinkedListNode head;

	public void insert(int unhashedKey) {
		LinkedListNode node = new LinkedListNode();
		node.setUnhashedKey(unhashedKey);

		if (head == null) {
			head = node;
		} else {
			LinkedListNode tail = tail();
			tail.setNext(node);
			node.setPrev(tail);
		}
	}

	private LinkedListNode tail() {
		LinkedListNode node = head;
		while (node.getNext() != null) {
			node = node.getNext();
		}

		return node;
	}

	public void delete(int unhashedKey) {
		LinkedListNode node = search(unhashedKey);
		LinkedListNode prev = node.getPrev();
		LinkedListNode next = node.getNext();

		if (prev != null) {
			prev.setNext(next);
		}

		if (next != null) {
			next.setPrev(prev);
		}
	}

	public LinkedListNode search(int unhashedKey) {
		LinkedListNode node = head;

		while (node != null) {
			if (node.getUnhashedKey() == unhashedKey) {
				return node;
			}
			
			node = node.getNext();
		}
		
		return null;
	}
}
