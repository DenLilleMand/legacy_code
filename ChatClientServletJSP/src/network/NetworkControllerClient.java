package network;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

import messageWrapper.Observable;
import messageWrapper.Observer;
import javafx.concurrent.Task;
import state.State;

public class NetworkControllerClient implements Observable 
{
	final int BARELY_LEGAL = 1025;
	private DatagramSocket clientSocket = null;
	InetAddress IPAddress; 
	
	private static NetworkControllerClient instance = null;
	private byte[] receiveData;
	private ArrayList<Observer> observerList = new ArrayList<Observer>();
	private boolean observerFlag = false;

	private NetworkControllerClient(Observer observer) {
		if (instance != null) {
			throw new IllegalStateException();
		}
		registerObserver(observer);
	}

	public static NetworkControllerClient getInstance(Observer observer) throws Exception{
		if (instance == null) {
			instance = new NetworkControllerClient(observer);
		}
		return instance;

	}
	
	public void connectToServer() throws Exception
	{
		setupStreams();
		whileReceiving();
	}

	private void setupStreams() throws Exception 
	{
		clientSocket = new DatagramSocket(BARELY_LEGAL);
//		clientSocket.setReceiveBufferSize(2048);
//		clientSocket.setSoTimeout(1);
		IPAddress = InetAddress.getByName("localhost");
	}

	private void whileReceiving()
	{
		Task<Void> task = new Task<Void>() 
				{
			@Override
			public void run() 
			{
					while(true)
					{
					receiveData = new byte[2048];
					DatagramPacket recvPacket = new DatagramPacket(receiveData,
							receiveData.length);
					try 
					{
						clientSocket.receive(recvPacket);
					} catch (IOException e) 
					{
						
					}
					try {
						String data = new String(receiveData, 0, receiveData.length);
						//String received = deserializeByteArrayToString(receiveData);
						System.out.println("received:" + data);
						handleInput(data);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
			}

			@Override
			protected Void call() throws Exception {
				return null;
			}
		};
		new Thread(task).start();

	}

	private void handleInput(Object object) 
	{
			setChanged();
			notifyAll(NetworkControllerClient.this, object);
	}

	public String deserializeByteArrayToString(byte[] data) {
		try {
			
			ObjectInputStream iStream = new ObjectInputStream(new ByteArrayInputStream(data));
			String obj = (String) iStream.readObject();
			iStream.close();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void registerObserver(Observer obs) {
		observerList.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		observerList.remove(obs);
	}

	@Override
	public void notifyAll(Observable observable, Object output) {
		if (observerFlag == true) {
			for (Observer obs : observerList) {
				obs.update(observable, output);
			}
			observerFlag = false;
		}
	}

	@Override
	public void setChanged() {
		observerFlag = true;
	}

	@Override
	public int countObservers() {
		return observerList.size();
	}
}
