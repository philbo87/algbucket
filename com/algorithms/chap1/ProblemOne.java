package com.algorithms.chap1;

public class ProblemOne {
	public static void main(String[] args) {
		String str = "abca";
		isUniqueChars2(str);
	}
	
	public static boolean isUniqueChars2(String str){
		if(str.length() > 128) return false;
		
		boolean[] char_set = new boolean[256];
		for(int i=0; i < str.length(); i++){
			int val = str.charAt(i);
			if(char_set[val]){
				return false;
			}
			char_set[val]=true;
		}
		
		return true;
	}
}
