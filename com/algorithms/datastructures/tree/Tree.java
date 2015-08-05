package com.algorithms.datastructures.tree;

public class Tree {

	public static void main(String[] args){
			
		TreeNode twenty = new TreeNode(20);//Root
		TreeNode ten = new TreeNode(10);
		TreeNode five = new TreeNode(5);
		TreeNode three = new TreeNode(3);
		TreeNode seven = new TreeNode(7);
		TreeNode fifteen = new TreeNode(15);
		TreeNode seventeen = new TreeNode(17);
		TreeNode thirty = new TreeNode(30);
		
		five.setLeft(three);
		five.setRight(seven);
		
		fifteen.setRight(seventeen);
		
		ten.setLeft(five);
		ten.setRight(fifteen);
		
		twenty.setLeft(ten);
		twenty.setRight(thirty);
		
		System.out.print("isBST: " + isBST(twenty));
	}
	
	
	/**
	 * Checks to see if this is a Binary Search Tree. Uses an In order Traversal. Takes O(N) time since you've gotta visit
	 * all the nodes
	 * @param root
	 * @return if it is a BST
	 */
	public static Integer last;
	public static boolean isBST(TreeNode root){
		if(root == null) return true;
		
		if(!isBST(root.getLeft())) return false;
		
		if(last != null && root.getV() <= last) return false;
		
		last = root.getV();
		
		if(!isBST(root.getRight())) return false;
		
		return true;
	}

}
