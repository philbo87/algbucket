package com.algorithms.chap11.problem8.bookversion;

public class RankNode {
	public int leftSize = 0;
	public RankNode left, right;
	public int data = 0;
	
	public RankNode(int d){
		data = d;
	}
	
	public void insert(int d){
		if(d <= data){
			if(left != null){
				left.insert(d);
			}
			else{
				left = new RankNode(d);
				
			}
			leftSize++;
		}else{
			if(right != null){
				right.insert(d);
			}else{
				right = new RankNode(d);
			}
		}
	}
	
	public int getRank(int d){
		if(d == data){
			return leftSize;
		}else if(d < data){
			if(left == null){
				return -1;
			}else{
				return left.getRank(d);
			}
		}else{
			int rightRank = right==null ? -1 : right.getRank(d);
			if(rightRank == -1){
				return -1;
			} else{
				return leftSize + 1 + rightRank;
			}
		}
	}
	
	public void inOrder(){
		//Traverse left
		if(this.left != null) this.left.inOrder();
		
		printNode(this);
		
		if(this.right != null) this.right.inOrder();
	}

	public void preOrder(){
		printNode(this);
		
		if(this.left!=null) this.left.preOrder();
		
		if(this.right!=null) this.right.preOrder();
	}
	
	public void postOrder(){
		if(this.left != null) this.left.postOrder();
		
		if(this.right != null) this.right.postOrder();
		
		printNode(this);
	}
	private void printNode(RankNode rankNode) {
		System.out.print(" " + rankNode.data);
	}
}
