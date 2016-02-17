package messageWrapper;

public interface Observable 
{
	public void registerObserver(Observer obs);
	public void removeObserver(Observer obs);
	public void notifyAll(Observable observable, Object output);
	public void setChanged();
	public int countObservers();
}
