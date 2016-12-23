package com.algorithms.datastructures.tree;

//BST has left nodes < parent, and right nodes > parent
public class BinarySearchTree extends Tree {

	private static TreeNode root = null;

	public static void main(String[] args) {
		insert(new TreeNode(3), root);
		insert(new TreeNode(1), root);
		insert(new TreeNode(5), root);
		insert(new TreeNode(7), root);
		insert(new TreeNode(95), root);
		inOrder(root);

		printNode(max(root));
		printNode(min(root));
		
		root = null;
		insert(new TreeNode(300), root);
		insert(new TreeNode(299), root);
		insert(new TreeNode(298), root);
		insert(new TreeNode(297), root);
		TreeNode last = new TreeNode(296);
		insert(last, root);
		printNode(successor(last));
		
		root = null;
		insert(new TreeNode(300), root);
		insert(new TreeNode(200), root);
		insert(new TreeNode(100), root);
		insert(new TreeNode(101), root);
		TreeNode last2 = new TreeNode(102);
		insert(last2, root);
		printNode(successor(last2));
		
	}

	//Get successor node O(h)
	//Successor is the next largest node
	private static TreeNode successor(TreeNode node) {
		if (node.getRight() != null) {
			return min(node.getRight());
		} else {
			TreeNode y = node.getParent();
			while (y != null && y.getParent() != null && y.getLeft() == null) {
				y = y.getParent();
			}
			return y;
		}
	}
	
	//Get predecessor node O(h)
	//Predecessor is the next smallest node
	private static TreeNode predecessor(TreeNode node){
		return null;
	}

	// To find the max, just go all the way down the right path of the tree
	// O(height)
	private static TreeNode max(TreeNode root) {
		TreeNode current = root;
		while (current.getRight() != null) {
			current = current.getRight();
		}
		return current;
	}

	// To find the min, go all the way down the left path of the tree
	// O(height)
	private static TreeNode min(TreeNode root) {
		TreeNode current = root;
		while (current.getLeft() != null) {
			current = current.getLeft();
		}
		return current;
	}

	/**
	 * Inserts a node into binary search tree, ensuring the BST has left nodes <
	 * parent, and right nodes > parent property holds. Does not ensure balanced
	 * tree, that will be in an AVL tree impl
	 * 
	 * @param root
	 * @param nodeToInsert
	 */
	private static void insert(TreeNode nodeToInsert, TreeNode currentNode) {
		// Have to traverse the tree and find the appropriate place to insert
		// Essentially doing a binary search here.
		if (currentNode == null) {
			// Initializing the tree
			currentNode = nodeToInsert;
			root = currentNode;
			return;
		} else {
			// Tree has at least one node
			if (nodeToInsert.getV() < currentNode.getV()) {
				// Going to go left
				if (currentNode.getLeft() != null) {
					insert(nodeToInsert, currentNode.getLeft());
				} else {
					// Found our place to insert
					currentNode.setLeft(nodeToInsert);
					nodeToInsert.setParent(currentNode);
				}
			} else {
				// Going to go right
				if (currentNode.getRight() != null) {
					insert(nodeToInsert, currentNode.getRight());
				} else {
					// Found out place to insert
					currentNode.setRight(nodeToInsert);
					nodeToInsert.setParent(currentNode);
				}
			}
		}
	}

}
