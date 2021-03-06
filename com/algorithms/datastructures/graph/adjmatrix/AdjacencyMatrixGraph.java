package com.algorithms.datastructures.graph.adjmatrix;

import java.util.LinkedList;
import java.util.Queue;

public class AdjacencyMatrixGraph {

	//1---2---5
	//|	  |   /
	//|   |  /
	//|   | /
	//3---4
	//
	// 0
	
	public static int[][] graph;
	private static Integer[] parent;
	public static void main(String[] args){
	
		
		//Construct Undirected Graph as Adj Matrix
		//1 = has an edge
		//0 = does not
		int[][] adjMatrix =  {{0,0,0,0,0,0},
		                     {0,0,1,1,0,0},
		                     {0,1,0,0,1,1},
		                     {0,1,0,0,1,0},
		                     {0,0,1,1,0,1},
		                     {0,0,1,0,1,0}};
		
		graph = adjMatrix;
		
		bfs(1);
		
		dfs(1);
		
		
	}
	
	public static void dfs(int rootVertex){
		parent = new Integer[graph.length];
		for(int i=0;i<parent.length;i++){
			parent[i]=null;
		}
		parent[rootVertex]=-1;
		dfsVisit(rootVertex);
		
	}
	public static void dfsVisit(int current){
		System.out.println("Visiting neighbors of: " + current);
		for(int i=0; i<graph[current].length;i++){
			//See if the current node has neighbors
			if(graph[current][i]==1){
				//It has a neighbor. Does the neighbor have a parent yet?
				if(parent[i] == null){
					
					//Set the parent and visit this neighbor
					System.out.println("Vertex "+current + " has neighbor " + i);
					parent[i]=current;
					dfsVisit(i);
				}
				
			}
		}
		System.out.println("DONE Visiting neighbors of: " + current);

	}
	public static void bfs(int vertex){
		boolean[] visited = new boolean[graph.length];
		int level = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		visited[vertex] = true;
		print(vertex,level);
		q.add(vertex);
		
		while(!q.isEmpty()){
			level++;
			Integer current = q.remove();
			for(int i = 0; i < graph[current].length; i++){
				//Check if we have a neighbor, and enqueue it for visit if not yet visited
				if(graph[current][i]==1){
					boolean isVisited = visited[i];
					if(!isVisited){
						visited[i]=true;
						print(i,level);
						q.add(i);
					}
				}
			}
		}
		
	}
	
	
	
	public static void print(int value, int level) {
		System.out.println(value + " at level: " + level);
	}
	
}
