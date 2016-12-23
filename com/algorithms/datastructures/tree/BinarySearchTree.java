package com.algorithms.datastructures.tree;

//BST has left nodes < parent, and right nodes > parent
public class BinarySearchTree extends Tree{

	private static TreeNode root = null;
	
	public static void main(String[] args){
		insert(new TreeNode(3),root);
		insert(new TreeNode(1),root);
		insert(new TreeNode(5),root);
		insert(new TreeNode(7),root);
		insert(new TreeNode(95),root);
		inOrder(root);
	}
	
	/**
	 * Inserts a node into binary search tree, ensuring the BST has left nodes < parent, and right nodes > parent property holds.
	 * Does not ensure balanced tree, that will be in an AVL tree impl
	 * 
	 * @param root
	 * @param nodeToInsert
	 */
	private static void insert(TreeNode nodeToInsert, TreeNode currentNode){
		//Have to traverse the tree and find the appropriate place to insert
		//Essentially doing a binary search here.
		if(currentNode == null){
			//Initializing the tree
			currentNode = nodeToInsert;
			root = currentNode;
			return;
		}else{
			//Tree has at least one node
			if(nodeToInsert.getV() < currentNode.getV()){
				//Going to go left
				if(currentNode.getLeft() != null){
					insert(nodeToInsert, currentNode.getLeft());
				}else{
					//Found our place to insert
					currentNode.setLeft(nodeToInsert);
				}
			}else{
				//Going to go right
				if(currentNode.getRight() != null){
					insert(nodeToInsert, currentNode.getRight());
				}else{
					//Found out place to insert
					currentNode.setRight(nodeToInsert);
				}
			}
		}
	}
	
}
