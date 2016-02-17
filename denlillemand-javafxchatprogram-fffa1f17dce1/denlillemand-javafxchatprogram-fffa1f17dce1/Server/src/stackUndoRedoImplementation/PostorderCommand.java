package stackUndoRedoImplementation;

import collections.tree.TreeRootWrapper;

public class PostorderCommand implements StrategyCommandForStack{
	private TreeRootWrapper tree;
	private StrategyCommandForStack lastState;
	public PostorderCommand(TreeRootWrapper tree, StrategyCommandForStack lastState)
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
		tree.printIterator(tree.postorder(),1);
		tree.updateTree();		
	}

}
