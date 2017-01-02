package com.algorithms.datastructures.graph.old;

import java.util.HashSet;
import java.util.Set;

public class GraphNode {
	private int val;
	private Set<GraphNode> immediateConnections;
	private boolean visited;
	
	public GraphNode(int val){
		this.val = val;
		immediateConnections = new HashSet<GraphNode>();
	}
	
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public void addConnection(GraphNode n) {
		this.immediateConnections.add(n);
		
	}
	
	public Set<GraphNode> getConnections(){
		return immediateConnections;
	}
	
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}
