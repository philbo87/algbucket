package com.algorithms.chap11.problem8.bookversion;

public class Question {
	private static RankNode root = null;
	
	public static void main(String[] args){
		track(20);
		track(15);
		track(10);
		track(5);
		track(13);
		track(25);
		track(23);
		track(24);
		
		int num = 25;
		System.out.println("Rank of " + num + " :" + getRankOfNumber(num));
		System.out.println("\nIn Order Traversal: "); 
		root.inOrder();
		
		System.out.println("\nPre Order Traversal: ");
		root.preOrder();
		
		System.out.println("\nPost Order Traversal");
		root.postOrder();
	}
	
	public static void track(int number){
		if(root == null){
			root = new RankNode(number);
		}else{
			root.insert(number);
		}
	}
	
	public static int getRankOfNumber(int number){
		return root.getRank(number);
	}
}
