package collections.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import collections.tree.TreeNode;
import decoratorImplementation.FakeAbstractClass;
import loaders.LoadingPictures;
import model.db.IMysqlDbWrapper;
import model.db.MysqlWrapper;
import entities.User;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

public class GraphWrapper extends FakeAbstractClass implements Observer
{
	private static GraphWrapper instance;
	private IMysqlDbWrapper dbWrapper;
	private Graph<String> graph = new Graph<>();
	private static final String EDGE = "EDGE";
	Button breadthFirstButton, depthFirstButton;
	TableView<Vertex<String>> graphTable;
	
	
	public static GraphWrapper getInstance(Button breadthFirstButton, Button depthFirstButton, TableView<Vertex<String>> graphTable,IMysqlDbWrapper dbWrapper) throws Exception
	{
		if(instance == null)
		{
			instance = new GraphWrapper(breadthFirstButton,depthFirstButton,graphTable,dbWrapper);
		}
		return instance;
	}
	
	private GraphWrapper(Button breadthFirstButton, Button depthFirstButton, TableView<Vertex<String>> graphTable,IMysqlDbWrapper dbWrapper) throws Exception
	{
		if(instance != null)
		{
			throw new IllegalStateException();
		}
		this.breadthFirstButton = breadthFirstButton;
		this.depthFirstButton = depthFirstButton;
		this.graphTable = graphTable;
		this.dbWrapper = dbWrapper;
		init();
	}
	
	private void init() throws Exception
	{
		breadthFirstButton.setOnAction((event) -> {
			printIterator(graph.breadthFirstTraversal("denlillemand"));
		});
		
		depthFirstButton.setOnAction((event) -> {
			printIterator(graph.depthFirstSearch("denlillemand"));
		});
		graphTable.getColumns().clear();
		initializeTheGraph();
		createColumns();			
		addDataToTableForVertices();
		updateGraph();
		
		
	}
	

	public void printIterator(Iterator<String>  iterator)
	{
			Integer visit = 1;
			while(iterator.hasNext())
			{
				System.out.println(visit +":"+iterator.next());
				visit++;
			}
	}
	
	
	private void initializeTheGraph() throws Exception
	{
		Iterator<User> userIterator = dbWrapper.retrieveAllUsers();
		while (userIterator.hasNext()) 
		{
			String userName = userIterator.next().getUserName();
			graph.addVertex(userName);
		}
			Set<String> keyset = graph.keySet();
			for(String key : keyset)
			{
				Iterator<User> friendIterator = dbWrapper.retrieveAllUserFriends(key);
				while(friendIterator.hasNext())
				{
					graph.setEdge(key, friendIterator.next().getUserName(), 0);
				}	
			}
	}
	
	private int vertexWithMostEdges()
	{
		int currentMax = 0;
		for(String key : graph.keySet())
		{
			currentMax = Math.max( currentMax,graph.amountOfEdgesOf(key));
		}
		return currentMax;
	}
	
	private void createColumns()
	{

		int amountOfColumns = vertexWithMostEdges();
		ArrayList<TableColumn<Vertex<String>,String>> columnList = new ArrayList<>();
		TableColumn<Vertex<String>, String> verticesColumn = new TableColumn<>("vertices");
		verticesColumn.setCellValueFactory((f) -> new SimpleStringProperty(f.getValue().key));
		columnList.add(verticesColumn);
		for(int i = 0; i < amountOfColumns; i++)
		{
			TableColumn<Vertex<String>, String> edgeColumn = new TableColumn<>(EDGE+i);
			final int colIndex = i;
			edgeColumn.setCellValueFactory((f) -> new SimpleStringProperty(f.getValue().getEdgeForColumnAt(colIndex)));
			columnList.add(edgeColumn);
		}
		graphTable.getColumns().addAll(columnList);
	}
	
	
	public void updateGraph() 
	{
		Platform.runLater(new Runnable() 
		{
			@Override
			public void run() 
			{
				for (TableColumn<Vertex<String>, ?> column : graphTable.getColumns()) 
				{
					column.setVisible(false);
					column.setVisible(true);
				}
			}
		});
	}
	
	private void addDataToTableForVertices()
	{	
		graphTable.setItems(dataForVertex());
	}
	
	private ObservableList<Vertex<String>> dataForVertex()
	{
		
		ObservableList<Vertex<String>> row = FXCollections.observableArrayList();
		for(String key : graph.keySet())
		{
			ArrayList<String> edges = new ArrayList<String>();
			for(String edge : graph.edgesOf(key))
			{
				edges.add(edge);
			}
			Vertex<String> vertex = new Vertex<String>(key,edges,0);	
			row.add(vertex);
		}
		return row;
	}

	@Override
	public void update(Observable observable, Object object) 
	{
		try 
		{
			init();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
