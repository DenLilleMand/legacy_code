package stackUndoRedoImplementation;

import exceptions.StackIsEmptyException;

public interface UndoRedoForTreeAlgorithms 
{
	public void pushCommand(StrategyCommandForStack command);
	public void redo();
	public void undo();
	public void pushRedoCommand(StrategyCommandForStack command);
	public boolean isEmpty();
	public StrategyCommandForStack peek() throws StackIsEmptyException;	
}
