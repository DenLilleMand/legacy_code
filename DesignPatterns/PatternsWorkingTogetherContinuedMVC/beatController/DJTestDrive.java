package beatController;
import interfaces.BeatModelInterface;
import interfaces.ControllerInterface;


public class DJTestDrive {
	public static void main(String [] args)
	{
		BeatModelInterface model = new BeatModel();
		ControllerInterface controller = new BeatController(model);
	}
}
