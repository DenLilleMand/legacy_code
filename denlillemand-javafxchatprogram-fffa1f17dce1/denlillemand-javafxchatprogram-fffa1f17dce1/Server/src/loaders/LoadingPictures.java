package loaders;

import javafx.scene.image.Image;



public class LoadingPictures 
{
	//mutiple selections
	protected static Image checkedImage;
	protected static Image uncheckedImage;
	protected static Image messageImage;
	protected static Image subjectImage;
	private static LoadingPictures instance;
	
	private LoadingPictures()
	{
		//handle reflection
	}


	static
	{
		try 
		{
			uncheckedImage = new Image("/ressources/unchecked.png");
			checkedImage = new Image("/ressources/checked.png");
			messageImage = new Image("/ressources/message.png");
			subjectImage = new Image("/ressources/subject.png");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static Image getMessageImage() 
	{
		return messageImage;
	}
	
	public static Image getSubjectImage() 
	{
		return subjectImage;
	}
	
	public static Image getCheckedImage() 
	{
		return checkedImage;
	}

	public static Image getUncheckedImage() 
	{
		return uncheckedImage;
	}

	public static LoadingPictures getInstance() 
	{
		if(instance == null)
		{
			instance = new LoadingPictures();
		}
		return instance;
	}

}
