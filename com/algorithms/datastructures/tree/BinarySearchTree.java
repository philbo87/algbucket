package com.algorithms.datastructures.tree;

//BST has left nodes < parent, and right nodes > parent
public class BinarySearchTree extends Tree {

	private static TreeNode root = null;

	public static void main(String[] args) {
		// insert(new TreeNode(3), root);
		// insert(new TreeNode(1), root);
		// insert(new TreeNode(5), root);
		// insert(new TreeNode(7), root);
		// insert(new TreeNode(95), root);
		// inOrder(root);
		//
		// printNode(max(root));
		// printNode(min(root));
		//
		// root = null;
		// insert(new TreeNode(300), root);
		// insert(new TreeNode(299), root);
		// insert(new TreeNode(298), root);
		// TreeNode two97 = new TreeNode(297);
		// insert(two97, root);
		// TreeNode last = new TreeNode(296);
		// insert(last, root);
		// printNode(successor(last));
		// printNode(predecessor(two97));
		// printNode(predecessor(last));
		//
		// root = null;
		// insert(new TreeNode(300), root);
		// insert(new TreeNode(200), root);
		// insert(new TreeNode(100), root);
		// insert(new TreeNode(101), root);
		// TreeNode last2 = new TreeNode(102);
		// insert(last2, root);
		// printNode(successor(last2));
		// printNode(predecessor(last2));

//		root = null;
//		TreeNode firstNode = new TreeNode(105);
//		insert(firstNode, root);
//		TreeNode secondNode = new TreeNode(75);
//		insert(secondNode, root);
//		TreeNode thirdNode = new TreeNode(205);
//		insert(thirdNode, root);
//		TreeNode fourthNode = new TreeNode(315);
//		insert(fourthNode, root);
//		TreeNode fifthNode = new TreeNode(170);
//		insert(fifthNode, root);
//		TreeNode sixthNode = new TreeNode(160);
//		insert(sixthNode, root);
//		TreeNode seventhNode = new TreeNode(175);
//		insert(seventhNode, root);
//		delete(firstNode);
//
//		root = null;
//		insert(new TreeNode(15), root);
//		TreeNode z = new TreeNode(5);
//		insert(z, root);
//		insert(new TreeNode(3), root);
//		insert(new TreeNode(12), root);
//		insert(new TreeNode(10), root);
//		insert(new TreeNode(6), root);
//		insert(new TreeNode(7), root);
//		insert(new TreeNode(13), root);
//		insert(new TreeNode(16), root);
//		insert(new TreeNode(20), root);
//		insert(new TreeNode(18), root);
//		insert(new TreeNode(23), root);
//		delete(z);
//		
//		root = null;
//		insert(new TreeNode(600), root);
//		TreeNode x = new TreeNode(150);
//		insert(x, root);
//		insert(new TreeNode(100), root);
//		TreeNode y = new TreeNode(250);
//		insert(y, root);
//		insert(new TreeNode(275), root);
//		insert(new TreeNode(225), root);
//		inOrder(root);
//		leftRotate(x);
//		inOrder(root);
//		rightRotate(y);
//		inOrder(root);
		
		root = null;
		insertAVL(new TreeNode(600), root);
		insertAVL(new TreeNode(333), root);
		insertAVL(new TreeNode(700), root);
		insertAVL(new TreeNode(750), root);
		insertAVL(new TreeNode(770), root);
		insertAVL(new TreeNode(725), root);
		insertAVL(new TreeNode(605), root);
		insertAVL(new TreeNode(601), root);
		insertAVL(new TreeNode(602), root);
		inOrderHeightPrint(root);
	}

	private static TreeNode leftRotate(TreeNode x){
		TreeNode y = x.getRight();
		x.setRight(y.getLeft());
		y.setLeft(x);
		y.setParent(x.getParent());
		
		if(x.getParent() == null){
			root = y;
		}else{
			if(x.equals(x.getParent().getLeft())){
				x.getParent().setLeft(y);
			}else{
				x.getParent().setRight(y);
			}
		}
		
		y.setLeft(x);
		x.setParent(y);
		
		x.setHeight(calculateHeight(x));
		y.setHeight(calculateHeight(y));
		
		//Returns the new root
		return y;
	}
	
	private static TreeNode rightRotate(TreeNode y){
		TreeNode x = y.getLeft();
		y.setLeft(x.getRight());
		x.setRight(y);
		x.setParent(y.getParent());
		
		if(y.getParent() == null){
			root = x;
		}else{
			if(y.equals(y.getParent().getLeft())){
				y.getParent().setLeft(x);
			}else{
				y.getParent().setRight(x);
			}
		}
		
		x.setRight(y);
		y.setParent(x);
		
		y.setHeight(calculateHeight(y));
		x.setHeight(calculateHeight(x));

		return x;//returns the new root
	}
	
	// O(h)
	private static void delete(TreeNode node) {
		if (node.getLeft() == null && node.getRight() == null) {
			// No children --> Just delete this
			// Figure out if this is left or right child of parent
			if (node.getParent() == null) {
				// This is the root, null the root
				root = null;
			} else if (node.getParent().getLeft() != null && node.getParent().getLeft().equals(node)) {
				node.getParent().setLeft(null);
			} else if (node.getParent().getRight() != null && node.getParent().getRight().equals(node)) {
				node.getParent().setRight(null);
			}

			node.setParent(null);

		} else if (node.getLeft() != null && node.getRight() == null) {
			// One child, and it is the left node. Just need to move pointers to
			// remove this node and point parent/child at each other
			TreeNode child = node.getLeft();
			TreeNode parent = node.getParent();
			child.setParent(parent);

			if (parent != null) {
				if (parent.getRight() != null && parent.getRight().equals(node)) {
					// The removed node is the right child of the parent, set
					// the removed child to be the parent's right child
					parent.setRight(child);
				}else{
					parent.setLeft(child);
				}
			} else {
				// This was root
				root = child;
			}

			// Not sure if this is really necessary
			node.setLeft(null);
			node.setParent(null);
		} else if (node.getRight() != null && node.getLeft() == null) {
			// One child, and it is the right node
			TreeNode child = node.getRight();
			TreeNode parent = node.getParent();
			child.setParent(parent);

			if (parent != null) {
				if (parent.getRight() != null && parent.getRight().equals(node)) {
					// The removed node is the right child of the parent, set
					// the removed child to be the parent's right child
					parent.setRight(child);
				}else{
					parent.setLeft(child);
				}
			} else {
				root = child;
			}

			// Not sure if this is really necessary
			node.setRight(null);
			node.setParent(null);
		} else {
			// Node has a L and R child
			// Worst case. Find successor y of node x,
			// Set value of x to y.val
			// Delete y, keeping in mind it could have right subtree and be in
			// same scenario
			// No need to change root pointer in this scenario as we are only
			// manipulating values
			TreeNode successor = successor(node);
			node.setV(successor.getV());
			delete(successor);
		}
	}

	// Get successor node O(h)
	// Successor is the next largest node
	private static TreeNode successor(TreeNode node) {
		if (node.getRight() != null) {
			return min(node.getRight());
		} else {
			TreeNode parent = node.getParent();
			while (parent != null && parent.getParent() != null && parent.getLeft() == null
					&& parent.getRight() != null) {
				parent = parent.getParent();
			}
			return parent;
		}
	}

	// Get predecessor node O(h)
	// Predecessor is the next smallest node
	private static TreeNode predecessor(TreeNode node) {
		if (node.getLeft() != null) {
			return max(node.getLeft());
		} else {
			TreeNode parent = node.getParent();
			while (parent != null && parent.getParent() != null && parent.getRight() == null
					&& parent.getLeft() != null) {
				parent = parent.getParent();
			}

			return parent;
		}
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
	private static TreeNode insert(TreeNode nodeToInsert, TreeNode currentNode) {
		// Have to traverse the tree and find the appropriate place to insert
		// Essentially doing a binary search here.
		if (currentNode == null) {
			currentNode = nodeToInsert;
			root = currentNode;
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
		
		return nodeToInsert;
	}
	
	public static void insertAVL(TreeNode nodeToInsert, TreeNode root){
		TreeNode insertedNode = insert(nodeToInsert, root);
		rebalanceAVL(insertedNode);
	}

	public static void rebalanceAVL(TreeNode insertedNode){
		TreeNode node = insertedNode;
		while(node != null){
			node.setHeight(calculateHeight(node));
			if(height(node.getLeft()) >= (2 + height(node.getRight()))){
				if(height(node.getLeft().getLeft()) >= height(node.getLeft().getRight())){
					node = rightRotate(node);
				}
				else{
					leftRotate(node.getLeft());
					node = rightRotate(node);
				}
			}else if(height(node.getRight()) >= (2 + height(node.getLeft()))){
				if(height(node.getRight().getRight()) >= height(node.getRight().getLeft())){
					node = leftRotate(node);
				}else{
					rightRotate(node.getRight());
					node = leftRotate(node);
				}
			}
			
			node = node.getParent();
		}
	}
	
	public static void inOrderHeightPrint(TreeNode node){
		if(node != null){
			inOrderHeightPrint(node.getLeft());
			printNodeWithHeight(node);
			inOrderHeightPrint(node.getRight());
		}
	}
	
	public static void printNodeWithHeight(TreeNode node){
		System.out.println(node.getV()+": "+node.getHeight());
	}
	private static int calculateHeight(TreeNode node){
		return (Integer.max(height(node.getLeft()), height(node.getRight())) + 1);
	}
	private static int height(TreeNode node) {
		if(node == null){
			return -1;
		}else{
			return node.getHeight();
		}
	}

}
