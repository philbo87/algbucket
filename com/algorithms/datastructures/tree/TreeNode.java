package com.algorithms.datastructures.tree;


public class TreeNode {
	private int v;
	private TreeNode left;
	private TreeNode right;
	private TreeNode parent;
	
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
	
	
}
