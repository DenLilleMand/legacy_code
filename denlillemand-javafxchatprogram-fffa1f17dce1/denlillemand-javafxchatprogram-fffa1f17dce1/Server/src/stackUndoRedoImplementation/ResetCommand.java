package stackUndoRedoImplementation;

import collections.tree.TreeRootWrapper;

public class ResetCommand implements StrategyCommandForStack{
	private TreeRootWrapper tree;
	
	public ResetCommand(TreeRootWrapper tree)
	{
		this.tree = tree;
	}
	
	@Override
	public void undo() 
	{
		System.out.println("undo was called on reset command, but we should be at the "
				+ "buttom of the stack.");
	}

	@Override
	public void execute() 
	{
		tree.printIterator(tree.breadthfirst(), 0);	
		tree.updateTree();
	}

}
