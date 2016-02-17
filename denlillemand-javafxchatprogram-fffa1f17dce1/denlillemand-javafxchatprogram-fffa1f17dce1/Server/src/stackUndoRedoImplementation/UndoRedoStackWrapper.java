package stackUndoRedoImplementation;

import collections.stacks.ArrayStack;
import exceptions.StackIsEmptyException;

public class UndoRedoStackWrapper implements UndoRedoForTreeAlgorithms
{
	private static final UndoRedoStackWrapper instance = new UndoRedoStackWrapper();
	ArrayStack<StrategyCommandForStack> redoStack = new ArrayStack<StrategyCommandForStack>(50);
	ArrayStack<StrategyCommandForStack> undoStack = new ArrayStack<StrategyCommandForStack>(50);
	
	//forfærdelig brug af Singleton.
	private UndoRedoStackWrapper()
	{
		if(instance != null)
		{
			throw new IllegalStateException();
		}
	}
	
	public static UndoRedoStackWrapper getInstance()
	{
		return instance;
	}
	
	public void pushCommand(StrategyCommandForStack command)
	{
		undoStack.push(command);
	}
	
	public void redo()
	{
		StrategyCommandForStack command = redoStack.pop();
		command.execute();
		undoStack.push(command);
	}
	
	
	public void undo()
	{
		StrategyCommandForStack command = undoStack.pop();
		command.undo();
		redoStack.push(command);
	}
	
	
	public void pushRedoCommand(StrategyCommandForStack command)
	{
		redoStack.push(command);
	}

	public boolean isEmpty() {
		return undoStack.isEmpty();
	}

	public StrategyCommandForStack peek() throws StackIsEmptyException {
		return undoStack.peek();
	}
	
	
	
	
}
