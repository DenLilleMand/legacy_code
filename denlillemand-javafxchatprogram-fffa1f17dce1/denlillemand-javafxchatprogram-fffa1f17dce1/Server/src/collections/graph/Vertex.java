package collections.graph;

import java.util.ArrayList;

public class Vertex<T> {
	ArrayList<T> edges = new ArrayList<T>();
	T key;
	String visitOrder;

	public Vertex(T key, ArrayList<T> edges, int i) {
		this.key = key;
		this.edges = edges;
		this.visitOrder = "" + i;
	}

	public void setVisitorder(int order) {
		this.visitOrder = "" + order;
	}

	public String getVisitorder() {
		return visitOrder;
	}

	public T getEdgeForColumnAt(int index) {
		if (index < edges.size()) {
			return edges.get(index);
		}
		return null;
	}
}
