package opg6.Graph;

public interface IMyGraph<T> {

	public void addEdge(Edge<T> edge);
	public boolean edgeExists(T fromVertex, T toVertex);

}
