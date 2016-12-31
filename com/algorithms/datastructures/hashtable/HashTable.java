package com.algorithms.datastructures.hashtable;

import com.algorithms.datastructures.linkedlist.LinkedList;
import com.algorithms.datastructures.linkedlist.LinkedListNode;

public class HashTable {

	public static void main(String[] args){
		HashTable t = new HashTable(10);
		t.insert(100);
		t.insert(10);//Will be a collision
		t.insert(101);
		
		t.search(100);
		t.search(10);
		t.search(101);
		t.search(1);
		
		t.delete(10);
		t.search(10);
	}
	
	private LinkedList[] table;
	private int tableSize;
	
	public HashTable(int tableSize){
		this.tableSize = tableSize;
		table = new LinkedList[tableSize];
		
		for(int i = 0; i < tableSize; i++){
			table[i] = new LinkedList();
		}
	}
	
	private int hash(int key){
		return key % this.tableSize;
	}
	
	private void insert(int key){
		int hashedKey = hash(key);
		table[hashedKey].insert(key);
	}
	
	private void delete(int key){
		int hashedKey = hash(key);
		LinkedList chain = table[hashedKey];
		chain.delete(key);
	}
	
	private void search(int key){
		int hashedKey = hash(key);
		LinkedList chain = table[hashedKey];
		
		LinkedListNode nodeInChain = chain.search(key);
		boolean exists = nodeInChain != null;
		System.out.println(key + ": " +  exists);
	}
}
