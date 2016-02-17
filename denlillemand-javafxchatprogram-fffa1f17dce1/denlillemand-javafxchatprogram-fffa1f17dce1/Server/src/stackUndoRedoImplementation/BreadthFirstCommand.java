package stackUndoRedoImplementation;

import collections.tree.TreeRootWrapper;

public class BreadthFirstCommand implements StrategyCommandForStack{
	private TreeRootWrapper tree;
	private StrategyCommandForStack lastState;
	
	public BreadthFirstCommand(TreeRootWrapper tree, StrategyCommandForStack lastState)
	{
		this.tree = tree;
		this.lastState = lastState;
	}
	
	@Override
	public void undo() 
	{
		lastState.execute();
	}

	@Override
	public void execute() 
	{
		tree.printIterator(tree.breadthfirst(),1);	
		tree.updateTree();
	}
}
