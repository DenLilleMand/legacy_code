package control;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Observable;
import java.util.Observer;

import entities.MessageEvent;
import entities.MessageWrapper;

public class UDPController implements Observer
{
	public static UDPController instance = null;
	final int BARELY_LEGAL = 1025;
    private DatagramSocket sock = null;
    private InetAddress host;
	
	public static UDPController getInstance()
	{
		if(instance == null)
		{
			instance = new UDPController();
		}
		return instance;
	}
	
	private UDPController()
	{
		if(instance != null)
		{
			throw new IllegalStateException();
		}
		try
		{
			sock = new DatagramSocket();   
			host = InetAddress.getByName("localhost");			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	private byte[] serializeString(String inputString)
	{
	    try
	    {
	      ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream(2048);
	      ObjectOutputStream objectOut = new ObjectOutputStream(byteArrayOutput);
	      objectOut.writeObject(inputString);
	      objectOut.close();

	      byte[] obj= byteArrayOutput.toByteArray();
	      byteArrayOutput.close();
	      return obj;
	    }
	    catch(Exception e) {
	        e.printStackTrace();
	    }

	    return null;

	}
	
	
	
	@Override
	public void update(Observable observable, Object inputObject) 
	{
		System.out.println("herpeprperpeprperpepr");
		if(observable instanceof MessageWrapper)
		{
			String readyToSend =  ((MessageEvent) inputObject).getMessage();
			 byte[] data = serializeString(readyToSend);

		     //send
		     try
		     {
		    	 System.out.println("sending this: " + readyToSend);
		                DatagramPacket  dataPacket = new DatagramPacket(data , data.length,host,BARELY_LEGAL);
		                sock.send(dataPacket);     
		     }
		     catch(Exception e)
		     {
		    	 e.printStackTrace();
		     }
		}
		
	}

}
