package com.algorithms.chap1;

public class ProblemSix {

	public static void main(String[] args){
		String[][] original = {{"A","B","C"},{"D","E","F"},{"G","H","I"}};
		
		String[][] rotated = new String[3][3];
		
		int newCol=original.length-1;
		for(int row=0; row<original.length; row++){
			for(int col=0; col< original[row].length; col++){
				rotated[col][newCol] = original[row][col];
			}
			
			newCol--;
		}
		
		
		
		System.out.println("dgsf");
		
	}
}
