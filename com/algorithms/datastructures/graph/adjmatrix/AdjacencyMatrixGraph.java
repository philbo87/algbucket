package com.algorithms.datastructures.graph.adjmatrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class AdjacencyMatrixGraph {

	//1---2---5
	//|	  |   /
	//|   |  /
	//|   | /
	//3---4
	//
	// 0
	
	public static void main(String[] args){
		//Construct Undirected graph as Adj List
		HashMap<Integer,LinkedList<Integer>> adjList = new HashMap<Integer,LinkedList<Integer>>();
		adjList.put(0, new LinkedList<Integer>());
		adjList.put(1, new LinkedList<Integer>(Arrays.asList(2,3)));
		adjList.put(2, new LinkedList<Integer>(Arrays.asList(1,5,4)));
		adjList.put(3, new LinkedList<Integer>(Arrays.asList(1,4)));
		adjList.put(4, new LinkedList<Integer>(Arrays.asList(3,2,5)));
		adjList.put(5, new LinkedList<Integer>(Arrays.asList(2,4)));
		
		//Construct Undirected Graph as Adj Matrix
		//1 = has an edge
		//0 = does not
		int[][] adjMatrix = {{0,0,0,0,0,0},
		                     {0,0,1,1,0,0},
		                     {0,1,0,0,1,1},
		                     {0,1,0,0,1,0},
		                     {0,0,1,1,0,1},
		                     {0,0,1,0,1,0}};
		
		
		
		
	}
	
}
