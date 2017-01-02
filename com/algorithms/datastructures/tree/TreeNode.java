package com.algorithms.datastructures.tree;


public class TreeNode {
	private int v;
	private TreeNode left;
	private TreeNode right;
	private TreeNode parent;
	private boolean isVisited;
	
	//Augment the Data structure for AVL trees where we cannot afford to always compute the height 
	private int height = 0; 
	
	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public TreeNode(int val){
		setV(val);
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	
	
}
