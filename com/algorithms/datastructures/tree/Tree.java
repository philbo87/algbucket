package com.algorithms.datastructures.tree;

public class Tree {

	public static void main(String[] args){
			
//		TreeNode twenty = new TreeNode(20);//Root
//		TreeNode ten = new TreeNode(10);
//		TreeNode five = new TreeNode(5);
//		TreeNode three = new TreeNode(3);
//		TreeNode seven = new TreeNode(7);
//		TreeNode fifteen = new TreeNode(15);
//		TreeNode seventeen = new TreeNode(17);
//		TreeNode thirty = new TreeNode(30);
//		
//		five.setLeft(three);
//		five.setRight(seven);
//		
//		fifteen.setRight(seventeen);
//		
//		ten.setLeft(five);
//		ten.setRight(fifteen);
//		
//		twenty.setLeft(ten);
//		twenty.setRight(thirty);
		
		//Simple tree
		//      99
		//      / \
		//     100 101
		//		/\
		//	102	 103
		TreeNode n99 = new TreeNode(99);
		TreeNode n100 = new TreeNode(100);
		TreeNode n101 = new TreeNode(101);
		TreeNode n102 = new TreeNode(102);
		TreeNode n103 = new TreeNode(103);
		
		n99.setLeft(n100);
		n99.setRight(n101);
		n100.setLeft(n102);
		n100.setRight(n103);
		System.out.println("Pre-Order Traversal");
		preOrder(n99);
		
		System.out.println("In order traversal:");
		inOrder(n99);
		
		System.out.println("Post order traversal:");
		postOrder(n99);
		
//		System.out.println("isBST: " + isBST(twenty));
//		System.out.println("LCA " + findCommonAncestor(n99,n102,n103).getV());
	}
	
	public static void preOrder(TreeNode node){
		if(node != null){
			printNode(node);
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}
	
	public static void inOrder(TreeNode node){
		if(node != null){
			inOrder(node.getLeft());
			printNode(node);
			inOrder(node.getRight());
		}
	}
	
	public static void postOrder(TreeNode node){
		if(node != null){
			postOrder(node.getLeft());
			postOrder(node.getRight());
			printNode(node);
		}
	}
	public static void printNode(TreeNode node){
		System.out.println(node.getV());
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
	
	/**
	 * Root changes as recursion occurs. n1/n2 do not
	 * 
	 * Runtime O(n)
	 * http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
	 * @param root
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static TreeNode findCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2)
	{
		/*Special Case 1*/
		//If the passed in root is null, the parent node had no left/right child to pass in
		if(root== null){
			return null;
		}
		
		/*Special Case 2*/
		//If the root is the same value as n1 or n2, we are on that level in the tree of one of our target values. 
		//Stop going deeper, return this root
		if(root.getV() == n1.getV() || root.getV() == n2.getV()){
			return root;
		}
		
		//The recursive calls to find the common ancestor. Could be null if there is no left/right children
		TreeNode leftCA = findCommonAncestor(root.getLeft(), n1,n2);
		TreeNode rightCA = findCommonAncestor(root.getRight(),n1,n2);
		
		//When leftCA and rightCA are not null, then we've found the common ancestor, return the current value of root
		if(leftCA != null && rightCA!=null){
			return root;
		}
		
		//If only one of these is not null, then it is the common ancestor. Note they could both also be null and thus we'd return null.
		if(leftCA != null) 
			return leftCA;
		else 
			return rightCA;
	}
}
