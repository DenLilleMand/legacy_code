package stackUndoRedoImplementation;

import collections.tree.TreeRootWrapper;

public class PreorderCommand implements StrategyCommandForStack{
	private TreeRootWrapper tree;
	private StrategyCommandForStack lastState;
	public PreorderCommand(TreeRootWrapper tree, StrategyCommandForStack lastState)
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
		tree.printIterator(tree.preorder(), 1);
		tree.updateTree();
	}

}
