package com.algorithms.datastructures.hashtable;

public class HashTableItem {

	private int unhashedKey;
	private boolean isDeleted;

	public HashTableItem(int unhashedKey){
		this.unhashedKey = unhashedKey;
	}
	
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public int getUnhashedKey() {
		return unhashedKey;
	}
	public void setUnhashedKey(int unhashedKey) {
		this.unhashedKey = unhashedKey;
	}
	
}
