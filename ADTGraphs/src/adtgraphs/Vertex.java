package adtgraphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

class Vertex<T> implements VertexInterface<T> {
	private T label;
	private List<Edge> edgeList; // edges to
	// neighbors
	private boolean visited; // true if visited
	private VertexInterface<T> previousVertex; // on path to this vertex
	private double cost; // of path to this vertex

	public Vertex(T vertexLabel) {
		label = vertexLabel;
		edgeList = new LinkedList<Edge>();
		visited = false;
		previousVertex = null;
		cost = 0;
	} // end constructor

	public QueueInterface<T> getBreadthFirstTraversal(T origin) {
		resetVertices();
		QueueInterface<T> traversalOrder = new LinkedQueue<T>();
		QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<VertexInterface<T>>();
		VertexInterface<T> originVertex = vertices.getValue(origin);
		originVertex.visit();
		traversalOrder.enqueue(origin); // enqueue vertex label
		vertexQueue.enqueue(originVertex); // enqueue vertex
		while (!vertexQueue.isEmpty()) {
			VertexInterface<T> frontVertex = vertexQueue.dequeue();
			Iterator<VertexInterface<T>> neighbors = frontVertex
					.getNeighborIterator();
			while (neighbors.hasNext()) {
				VertexInterface<T> nextNeighbor = neighbors.next();
				if (!nextNeighbor.isVisited()) {
					nextNeighbor.visit();
					traversalOrder.enqueue(nextNeighbor.getLabel());
					vertexQueue.enqueue(nextNeighbor);
				} // end if
			} // end while
		} // end while
		return traversalOrder;
	} // end getBreadthFirstTraversal

	public int getShortestPath(T begin, T end, StackInterface<T> path) {
		resetVertices();
		boolean done = false;
		QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<VertexInterface<T>>();
		VertexInterface<T> originVertex = vertices.getValue(begin);
		VertexInterface<T> endVertex = vertices.getValue(end);
		originVertex.visit();
		// Assertion: resetVertices() has executed setCost(0)
		// and setPredecessor(null) for originVertex
		vertexQueue.enqueue(originVertex);
		while (!done && !vertexQueue.isEmpty()) {
			VertexInterface<T> frontVertex = vertexQueue.dequeue();
			Iterator<VertexInterface<T>> neighbors = frontVertex
					.getNeighborIterator();
			while (!done && neighbors.hasNext()) {
				VertexInterface<T> nextNeighbor = neighbors.next();
				if (!nextNeighbor.isVisited()) {
					nextNeighbor.visit();
					nextNeighbor.setCost(1 + frontVertex.getCost());
					nextNeighbor.setPredecessor(frontVertex);
					vertexQueue.enqueue(nextNeighbor);
				} // end if
				if (nextNeighbor.equals(endVertex))
					done = true;
			} // end while
		} // end while
			// traversal ends; construct shortest path
		int pathLength = (int) endVertex.getCost();
		path.push(endVertex.getLabel());
		VertexInterface<T> vertex = endVertex;
		while (vertex.hasPredecessor()) {
			vertex = vertex.getPredecessor();
			path.push(vertex.getLabel());
		} // end while
		return pathLength;
	} // end getShortestPath

	protected void resetVertices() {
		Iterator<VertexInterface<T>> vertexIterator = vertices
				.getValueIterator();
		while (vertexIterator.hasNext()) {
			VertexInterface<T> nextVertex = VertexIterator.next();
			nextVertex.unvisit();
			nextVertex.setCost(0);
			nextVertex.setPredecessor(null);
		} // end while
	} // end resetVertices

	public VertexInterface<T> getUnvisitedNeighbor() {
		VertexInterface<T> result = null;
		Iterator<VertexInterface<T>> neighbors = getNeighborIterator();
		while ((neighbors.hasNext()) && (result == null)) {
			VertexInterface<T> nextNeighbor = neighbors.next();
			if (!nextNeighbor.isVisited())
				result = nextNeighbor;
		} // end while
		return result;
	} // end getUnvisitedNeighbor

	public boolean equals(Object other) {
		boolean result;
		if ((other == null) || (getClass() != other.getClass()))
			result = false;
		else {
			Vertex<T> otherVertex = (Vertex<T>) other;
			result = label.equals(otherVertex.label);
		} // end if
		return result;
	} // end equals

	public boolean hasNeighbor() {
		return !edgeList.isEmpty();
	} // end hasNeighbor

	public Iterator<VertexInterface<T>> getNeighborIterator() {
		return new neighborIterator();
	} // end getNeighborIterator

	protected class Edge {
		private VertexInterface<T> vertex; // end vertex
		private double weight;

		protected Edge(VertexInterface<T> endVertex, double edgeWeight) {
			vertex = endVertex;
			weight = edgeWeight;
		} // end constructor

		protected VertexInterface<T> getEndVertex() {
			return vertex;
		} // end getEndVertex

		protected double getWeight() {
			return weight;
		} // end getWeight
	} // end Edge

	private class neighborIterator implements Iterator<VertexInterface<T>> {
		private Iterator<Edge> edges;

		private neighborIterator() {
			edges = edgeList.iterator();
		} // end default constructor

		public boolean hasNext() {
			return edges.hasNext();
		} // end hasNext

		public VertexInterface<T> next() {
			VertexInterface<T> nextNeighbor = null;
			if (edges.hasNext()) {
				Edge edgeToNextNeighbor = edges.next();
				nextNeighbor = edgeToNextNeighbor.getEndVertex();
			} else
				throw new NoSuchElementException();
			return nextNeighbor;
		} // end next

		public void remove() {
			throw new UnsupportedOperationException();
		} // end remove
	} // end neighborIterator

	@Override
	public T getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void visit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void unvisit() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isVisited() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean connect(VertexInterface<T> endVertex, double edgeWeight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean connect(VertexInterface<T> endVertex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Double> getWeightIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPredecessor(VertexInterface<T> predecessor) {
		// TODO Auto-generated method stub

	}

	@Override
	public VertexInterface<T> getPredecessor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasPredecessor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCost(double newCost) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 0;
	}
} // end Vertex
