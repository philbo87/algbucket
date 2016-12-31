package com.algorithms.datastructures.hashtable;

import com.algorithms.datastructures.linkedlist.LinkedList;
import com.algorithms.datastructures.linkedlist.LinkedListNode;

public class ChainingHashTable {

	public static void main(String[] args) {
		ChainingHashTable t = new ChainingHashTable(8);
		t.insert(100);
		t.insert(10);// Will be a collision
		t.insert(101);

		t.search(100);
		t.search(10);
		t.search(101);
		t.search(1);

		t.delete(10);
		t.delete(101);
		t.search(10);
	}

	private LinkedList[] table;
	private int tableSize;
	private int size;

	public ChainingHashTable(int tableSize) {
		this.tableSize = tableSize;
		this.size = 0;
		table = new LinkedList[tableSize];

		for (int i = 0; i < tableSize; i++) {
			table[i] = new LinkedList();
		}
	}

	private int hash(int key) {
		return key % this.tableSize;
	}

	//O(1) operation amoritized
	//Could be O(n) on double
	private void insert(int key) {
		int hashedKey = hash(key);
		table[hashedKey].insert(key);

		size++;
		
		if(size > tableSize){
			doubleHashTable();
		}

	}

	private void doubleHashTable() {
		LinkedList[] old = table;

		tableSize = tableSize *2;
		LinkedList[] doubledTable = new LinkedList[tableSize];
		for (int i = 0; i < tableSize; i++) {
			doubledTable[i] = new LinkedList();
		}
		table = doubledTable;
		
		//For each item in the existing table:
		//Rehash it for new tableSize
		//Put in new table
		for(int i=0; i<old.length; i++){
			LinkedList chain = old[i];
			LinkedListNode chainNode = chain.getHead();
			while(chainNode != null){
				insert(chainNode.getUnhashedKey());
				chainNode = chainNode.getNext();
			}
		}
		
	}

	private void delete(int key) {
		int hashedKey = hash(key);
		LinkedList chain = table[hashedKey];
		chain.delete(key);
		size--;
		
		if(size < (tableSize/4)){
			shrinkHashTable();
		}
	}

	private void shrinkHashTable() {
		LinkedList[] old = table;

		tableSize = tableSize/2;
		LinkedList[] halvedTable = new LinkedList[tableSize];
		for (int i = 0; i < tableSize; i++) {
			halvedTable[i] = new LinkedList();
		}
		table = halvedTable;
		
		//For each item in the existing table:
		//Rehash it for new tableSize
		//Put in new table
		for(int i=0; i<old.length; i++){
			LinkedList chain = old[i];
			LinkedListNode chainNode = chain.getHead();
			while(chainNode != null){
				insert(chainNode.getUnhashedKey());
				chainNode = chainNode.getNext();
			}
		}		
	}

	private void search(int key) {
		int hashedKey = hash(key);
		LinkedList chain = table[hashedKey];

		LinkedListNode nodeInChain = chain.search(key);
		boolean exists = nodeInChain != null;
		System.out.println(key + ": " + exists);
	}
}
