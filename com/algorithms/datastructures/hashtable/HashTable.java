package com.algorithms.datastructures.hashtable;

public class HashTable {

	public static void main(String[] args){
		HashTable t = new HashTable(10);
		t.insert(100, "100");
		t.insert(10, "10");//Will be a collision
		t.insert(101, "101");
		
		t.search(100);
		t.search(10);
		t.search(101);
		t.search(1);
		
		t.delete(10);
		t.search(10);
	}
	
	private String[] table;
	private int tableSize;
	
	public HashTable(int tableSize){
		this.tableSize = tableSize;
		table = new String[tableSize];
	}
	
	private int hash(int key){
		return key % this.tableSize;
	}
	
	private void insert(int key, String value){
		//TODO: Deal with collisions
		int hashedKey = hash(key);
		table[hashedKey] = value;
	}
	
	private void delete(int key){
		int hashedKey = hash(key);
		table[hashedKey] = null;
	}
	
	private String search(int key){
		int hashedKey = hash(key);
		String value = table[hashedKey];
		System.out.println(value);
		return value;
	}
}
