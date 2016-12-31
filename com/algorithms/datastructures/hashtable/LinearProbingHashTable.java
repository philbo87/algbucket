package com.algorithms.datastructures.hashtable;

//Flawed: Promotes clustering around collisions
public class LinearProbingHashTable {

	public static void main(String[] args) {
		LinearProbingHashTable t = new LinearProbingHashTable(10);
		t.insert(89);
		t.insert(18);
		t.insert(49);
		t.insert(58);
		t.insert(69);
		t.insert(690);
		t.insert(12);
		t.insert(63);
		t.insert(629);
		t.insert(691);
		t.insert(6977);

		t.search(6977);
		t.delete(6977);
		t.search(6977);

		t.insert(6977);
		t.search(6977);

		//t.print();
	}

	private HashTableItem[] table;
	private int tableSize;
	private int size;

	public LinearProbingHashTable(int tableSize) {
		this.tableSize = tableSize;
		this.size = 0;
		table = new HashTableItem[tableSize];
	}

	private void print(){
		for(int i = 0; i<tableSize; i++){
			if(table[i] !=null){
				System.out.println("table["+i+"]:\tKey: " + table[i].getUnhashedKey() + "\tIs Deleted: "+ table[i].isDeleted());
			}else{
				System.out.println("table["+i+"]:\t is null");
			}
		}
	}
	private int hash(int key, int attempt) {
		return ((key % this.tableSize) + attempt) % this.tableSize;
	}

	// O(1) operation amoritized
	// Could be O(n) on double
	private void insert(int key) {
		putKeyWithoutExpansion(key);

		if (size == tableSize) {
			doubleHashTable();
		}

	}

	private void doubleHashTable() {
		HashTableItem[] old = table;
		tableSize = tableSize * 2;
		table = new HashTableItem[tableSize];
		

		// For each item in the existing table:
		// Rehash it for new tableSize
		// Put in new table
		for (int i = 0; i < old.length; i++) {
			if (old[i] != null && !old[i].isDeleted()) {
				putKeyWithoutExpansion(old[i].getUnhashedKey());
			}
		}

	}
	
	private void putKeyWithoutExpansion(int key){
		int attempt = 1;
		boolean success = false;
		while (!success) {
			int hashedKey = hash(key, attempt);
			if (table[hashedKey] == null || table[hashedKey].isDeleted()) {
				table[hashedKey] = new HashTableItem(key);
				success = true;
			}
			attempt++;
		}

		size++;
	}

	private void delete(int key) {
		HashTableItem item = search(key);

		item.setDeleted(true);
		size--;

		if (size < (tableSize / 4)) {
			shrinkHashTable();
		}
	}

	private void shrinkHashTable() {
		HashTableItem[] old = table;
		tableSize = tableSize / 2;
		table = new HashTableItem[tableSize];
		// For each item in the existing table:
		// Rehash it for new tableSize
		// Put in new table
		for (int i = 0; i < old.length; i++) {
			if (old[i] != null && !old[i].isDeleted()) {
				insert(old[i].getUnhashedKey());
			}
		}
	}

	private HashTableItem search(int key) {
		int attempt = 1;
		boolean stopSearching = false;
		HashTableItem item = null;
		while (!stopSearching) {
			int hashedKey = hash(key, attempt);
			if (table[hashedKey] != null && !table[hashedKey].isDeleted() && table[hashedKey].getUnhashedKey() == key) {
				item = table[hashedKey];
				stopSearching = true;
			} else if (table[hashedKey] == null) {
				stopSearching = true;
			}
			attempt++;
		}

		boolean exists = item != null;
		System.out.println(key + ": " + exists);

		return item;
	}
}
