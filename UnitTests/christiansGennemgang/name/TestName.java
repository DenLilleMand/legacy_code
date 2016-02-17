package name;

import java.net.UnknownHostException;

public class TestName 
{

	public static void main(String[] args) 
	{
		String name  ="Jens jensen herpderplastname";
		
		printFirstNameAndLastName(name);
	}
	
	private static void printFirstNameAndLastName(String name)
	{
		
		try {
			java.net.InetAddress localMachine = java.net.InetAddress.getLocalHost();
			System.out.println(localMachine.getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
