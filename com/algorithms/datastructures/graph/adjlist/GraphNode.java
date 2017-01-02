package com.algorithms.datastructures.graph.adjlist;

import java.util.List;

public class GraphNode {

	private int value;
	private List<Integer> neighbors;
	private boolean isVisited;
	
	public GraphNode(int value, List<Integer> neighbors){
		this.value = value;
		this.neighbors = neighbors;
		this.isVisited = false;
	}

	public int getValue() {
		return value;
	}
	
	public List<Integer> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<Integer> neighbors) {
		this.neighbors = neighbors;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void visit() {
		this.isVisited = true;
	}
	
	public int degree(){
		return neighbors.size();
	}
}
