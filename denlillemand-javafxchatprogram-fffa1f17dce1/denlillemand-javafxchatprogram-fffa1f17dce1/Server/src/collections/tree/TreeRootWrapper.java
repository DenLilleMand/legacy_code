package collections.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;

import collections.queues.LinkedQueue;
import javafx.application.Platform;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import entities.MessageEvent;
import entities.MessageWrapper;


public class TreeRootWrapper implements Observer 
{
	private static TreeRootWrapper instance;
	TreeTableView<TreeNode> treeView;
	TreeNode root;
	
	

	public static TreeRootWrapper getInstance(TreeTableView<TreeNode> treeView) 
	{
		if (instance == null) {
			instance = new TreeRootWrapper(treeView);
		}
		return instance;
	}

	
	
	
	private TreeRootWrapper(TreeTableView<TreeNode> treeView) {
		if (instance != null) {
			throw new IllegalStateException("This object is a singelton!");
		}
		if(treeView != null)
		{
			this.treeView = treeView;			
		}
	}

	public void setRoot(MessageEvent searchEvent) 
	{
		root = new TreeNode(searchEvent);
	}

	public void publicAttachNode(MessageEvent searchEvent) {
		root.attachNode(searchEvent);
	}
	

	public void updateTree() 
	{
		Platform.runLater(new Runnable() 
		{
			@Override
			public void run() {
				for (TreeTableColumn<TreeNode, ?> column : treeView.getColumns()) 
				{
					column.setVisible(false);
					column.setVisible(true);
				}
			}
		});
	}

	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void update(Observable observable, Object inputObject) 
	{
		if (observable instanceof MessageWrapper) {
			MessageEvent event = (MessageEvent) inputObject;
			Platform.runLater(new Runnable() 
			{
				@Override
				public void run() {
						publicAttachNode(event);
						createTreeTableView();
						updateTree();
				}
			});
		}

	}

	    public void print() 
	    {
	        root.print(0);
	    }
	
	public void createTreeTableView() {
		treeView.setRoot(root.createTree(root));
	}
	
	
	
	
	public void printIterator(Iterable<TreeNode>  iterable, int whatToDo)
	{
		if(whatToDo == 1)
		{
			Integer visit = 1;
			for(TreeNode treenode : iterable)
			{
				treenode.setVisitOrder(visit);
				System.out.println(visit +":"+treenode.data.getSubject());
				visit++;
			}
		}
		else
		{
			for(TreeNode treenode : iterable)
			{
				treenode.setVisitOrder(0);
				System.out.println(0 +":"+treenode.data.getSubject());
			}
		}
		
	}
	
	

	/**
	 * postorder
	 * @return
	 */
	public Iterable<TreeNode> postorder() 
	{
		System.out.println("postorder:");
		List<TreeNode> snapshot = new ArrayList<>();
		if (!isEmpty())
			postorderSubtree(root, snapshot); 
		return snapshot;
	}

	private void postorderSubtree(TreeNode p, List<TreeNode> snapshot) {
		for (String c : p.getChildren().keySet())
			postorderSubtree(p.getChildren().get(c), snapshot);
		snapshot.add(p); 
	}
	
	
	
	/**
	 * preorder
	 * @return
	 */
	public Iterable<TreeNode> preorder() {
		System.out.println("preorder:");
		ArrayList<TreeNode> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			preorderSubtree(root, snapshot); 
		}
		return snapshot;
	}

	private void preorderSubtree(TreeNode p, List<TreeNode> snapshot) {
		snapshot.add(p); 
		for (String c : p.getChildren().keySet())
			preorderSubtree(p.getChildren().get(c), snapshot);
	}
	
	/**
	 * BreadthFirst
	 * @return
	 */
	public Iterable<TreeNode> breadthfirst() 
	{
		System.out.println("breadthFirst:");
		List<TreeNode> snapshot = new ArrayList<>();
		if (!isEmpty()) 
		{
			LinkedQueue<TreeNode> queue = new LinkedQueue<TreeNode>();
			queue.enqueue(root); 
			while (!queue.isEmpty()) 
			{
				TreeNode p = queue.dequeue(); 
				snapshot.add(p);
				for (String key : p.getChildren().keySet())
				{
					queue.enqueue(p.getChildren().get(key));					
				}
			}
		}
		return snapshot;
	}

}
