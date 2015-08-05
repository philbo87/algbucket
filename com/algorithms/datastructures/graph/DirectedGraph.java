package com.algorithms.datastructures.graph;

import java.util.LinkedList;

/**
 * Class use to hold directed graph methods
 * http://www.programmerinterview.com/index.php/data-structures/dfs-vs-bfs/
 * http://www.quora.com/What-are-the-advantages-of-using-BFS-over-DFS-or-using-DFS-over-BFS-What-are-the-applications-and-downsides-of-each
 * @author Phil
 *
 */
public class DirectedGraph {
	public static void main(String[] args) {
		GraphNode one = new GraphNode(1);
		GraphNode two = new GraphNode(2);
		GraphNode three = new GraphNode(3);
		GraphNode four = new GraphNode(4);
		GraphNode five = new GraphNode(5);
		GraphNode six = new GraphNode(6);

		one.addConnection(six);
		one.addConnection(two);
		one.addConnection(three);
		one.addConnection(four);

		two.addConnection(one);

		three.addConnection(five);

		four.addConnection(three);

		System.out.println("Route exists between these? " + isRoutable(one, five, Mode.BFS));

	}

	public enum Mode {
		BFS, DFS
	}

	public static boolean isRoutable(GraphNode source, GraphNode destination, Mode mode) {
		if (mode == Mode.BFS) {
			return isRoutableWithBFS(source, destination);
		} else {
			return isRoutableWithDFS(source, destination);
		}
	}

	/**
	 * This solution uses a variation of DFS to determine if there is a path
	 * between nodes. We mark nodes as visited so we don't go down the same path
	 * multiple times.
	 * 
	 * Once source == dest, we've found a route.
	 * 
	 * @param source
	 * @param destination
	 * @return
	 */
	public static boolean isRoutableWithDFS(GraphNode source, GraphNode destination) {
		if (source == null || destination == null)
			return false;

		source.setVisited(true);

		if (source.getVal() == destination.getVal())
			return true;

		for (GraphNode n : source.getConnections()) {
			if (n.isVisited() == false) {
				boolean routeExists = isRoutableWithDFS(n, destination);
				if (routeExists)
					return true;
			}
		}

		return false;

	}

	/**
	 * Uses BFS to see if there is a route between two nodes. Roughly based on
	 * the solution to problem 4.2 in Cracking the Coding Interview 
	 * 
	 * Assume that all nodes are not visited when this is called
	 * 
	 * @param source
	 * @param destination
	 * @return
	 */
	public static boolean isRoutableWithBFS(GraphNode source, GraphNode destination) {
		if (source.getVal() == destination.getVal())
			return true;

		LinkedList<GraphNode> q = new LinkedList<GraphNode>();

		source.setVisited(true);

		q.add(source);
		GraphNode u;
		while (!q.isEmpty()) {
			u = q.removeFirst();
			if(u!=null){
				for(GraphNode v : u.getConnections()){
					if(!v.isVisited()){
						if(v.getVal()==destination.getVal()){
							return true;
						}else{
							v.setVisited(true);
							q.add(v);
						}
					}
				}
				u.setVisited(true);
			}
		}
		return false;
	}
}
