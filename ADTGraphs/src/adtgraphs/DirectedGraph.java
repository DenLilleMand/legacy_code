package adtgraphs;

public class DirectedGraph<T> implements GraphInterface<T> {
	private DictionaryInterface<T, VertexInterface<T>> vertices;
	private int edgeCount;

	public DirectedGraph() {
		vertices = new LinkedDictionary<T, VertexInterface<T>>();
		edgeCount = 0;
	} // end default constructor

	public boolean hasEdge(T begin, T end) {
		boolean found = false;
		VertexInterface<T> beginVertex = vertices.getValue(begin);
		VertexInterface<T> endVertex = vertices.getValue(end);
		if ((beginVertex != null) && (endVertex != null)) {
			Iterator<VertexInterface<T>> neighbors = beginVertex
					.getNeighborIterator();
			while (!found && neighbors.hasNext()) {
				VertexInterface<T> nextNeighbor = neighbors.next();
				if (endVertex.equals(nextNeighbor))
					found = true;
			} // end while
		} // end if
		return found;
	} // end hasEdge

	public boolean addVertex(T vertexLabel) {
		VertexInterface<T> isDuplicate = vertices.add(vertexLabel, new Vertex(
				vertexLabel));
		return isDuplicate == null; // was add to dictionary successful?
	} // end addVertex
	
	

	public boolean addEdge(T begin, T end, double edgeWeight) {
		boolean result = false;
		VertexInterface<T> beginVertex = vertices.getValue(begin);
		VertexInterface<T> endVertex = vertices.getValue(end);
		if ((beginVertex != null) && (endVertex != null))
			result = beginVertex.connect(endVertex, edgeWeight);
		if (result)
			edgeCount++;
		return result;
	} // end addEdge

	public boolean addEdge(T begin, T end) {
		return addEdge(begin, end, 0);
	} // end addEdge
	
	public boolean isEmpty()
	{
	return vertices.isEmpty();
	} // end isEmpty
	public void clear()
	{
	vertices.clear();
	edgeCount = 0;
	} // end clear
	public int getNumberOfVertices()
	{
	return vertices.getSize();
	} // end getNumberOfVertices
	public int getNumberOfEdges()
	{
	return edgeCount;
	} // end getNumberOfEdges
} // end DirectedGraph