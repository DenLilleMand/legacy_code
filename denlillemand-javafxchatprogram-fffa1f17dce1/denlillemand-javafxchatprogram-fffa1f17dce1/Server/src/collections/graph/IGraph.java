package collections.graph;

import java.util.ArrayList;

public interface IGraph<T> 
{
	public int returnAmountOfVertexes();
	public int returnAmountOfEdges();
	public void setEdge(T fromVertex, T toVertex, int weight);
	public void deleteEdge(T i, T j);
	public boolean edgeExist(T i, T j);
	public int weight(T i, T j);
	void setMark(T toVertex, ArrayList<T> visitedVertices);
	boolean isMarked(T v, ArrayList<T> visitedVertices);
}