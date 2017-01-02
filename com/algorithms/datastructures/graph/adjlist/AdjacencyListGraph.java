package com.algorithms.datastructures.graph.adjlist;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AdjacencyListGraph {
	private static HashMap<Integer, GraphNode> adjList;

	public static void main(String[] args) {
		// 1---2---5
		// | | /
		// | | /
		// | | /
		// 3---4
		//
		// 0

		AdjacencyListGraph g = new AdjacencyListGraph();
		g.addNode(0, null);
		g.addNode(1, Arrays.asList(2, 3));
		g.addNode(2, Arrays.asList(1, 5, 4));
		g.addNode(3, Arrays.asList(1, 4));
		g.addNode(4, Arrays.asList(3, 2, 5));
		g.addNode(5, Arrays.asList(2, 4));
		
		System.out.println("BFS:");
		g.bfs(1);
		
		System.out.println("Degrees");
		g.degree(0);
		g.degree(1);
		g.degree(2);
		g.degree(3);
		g.degree(4);
		g.degree(5);
		
		dfsStartingAt(1);
	}

	public AdjacencyListGraph() {
		adjList = new HashMap<Integer, GraphNode>();
	}
	
	public void degree(int vertex){
		System.out.println(vertex +  ": " + adjList.get(vertex).degree());
	}

	public void bfs(int vertex) {
		int level = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		GraphNode node = adjList.get(vertex);
		node.visit();
		print(node.getValue(),level);
		q.add(node.getValue());
		
		while(!q.isEmpty()){
			level++;
			Integer current = q.remove();
			List<Integer> neighbors = adjList.get(current).getNeighbors();
			
			//Visit the neighbors and add to the queue
			for(Integer neighbor : neighbors){
				GraphNode neighborNode = adjList.get(neighbor);
				if(!neighborNode.isVisited()){
					neighborNode.visit();
					print(neighbor,level);
					q.add(neighbor);
				}
			}
		}
	}
	
	private static HashMap<Integer,Integer> parent = new HashMap<Integer,Integer>();

	public static void dfsStartingAt(int vertex){
		System.out.println("Visiting neighbors of: " + vertex);
		
		if(parent.get(vertex) == null){
			//Dis be the root
			parent.put(vertex, -1);
		}
		GraphNode node = adjList.get(vertex);
		for(Integer neighbor : node.getNeighbors()){
			if(parent.get(neighbor) == null){
				System.out.println("Vertex "+vertex + " has neighbor " + neighbor);
				parent.put(neighbor, vertex);
				dfsStartingAt(neighbor);
			}	
		}
		
		System.out.println("DONE Visiting neighbors of: " + vertex);

	}

	// This isn't smart enough to manage neighbors. You will have to do that
	// manually
	public void addNode(Integer vertex, List<Integer> neighbors) {
		if (neighbors != null) {
			GraphNode node = new GraphNode(vertex, neighbors);
			adjList.put(vertex, node);
		} else {
			GraphNode node = new GraphNode(vertex, new LinkedList<Integer>());
			adjList.put(vertex, node);
		}
	}

	public List<Integer> getNeighbors(Integer vertex) {
		return adjList.get(vertex).getNeighbors();
	}

	public void print(int value, int level) {
		System.out.println(value + " at level: " + level);
	}
}