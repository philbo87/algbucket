package com.algorithms.datastructures.graph;

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

		System.out.println("Route exists between these? " + isRoutable(one, two));

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
	public static boolean isRoutable(GraphNode source, GraphNode destination) {
		if (source == null || destination == null)
			return false;

		source.setVisited(true);

		if (source.getVal() == destination.getVal())
			return true;

		for (GraphNode n : source.getConnections()) {
			if (n.isVisited() == false) {
				boolean routeExists = isRoutable(n, destination);
				if (routeExists)
					return true;
			}
		}

		return false;

	}
}
