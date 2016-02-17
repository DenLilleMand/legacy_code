package clientHerpderp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client 
{
	int port;
	InetAddress address;
	static String hostName;
	DatagramSocket socket = null;
	DatagramPacket packet;
	byte[] sendBuf = new byte[256];
	
	
	public static void main(String[] args) throws Exception
	{
		int port = Integer.parseInt(args[0]);
//		hostName = InetAddress.getLocalHost().getHostName();
		InetAddress address = InetAddress.getByName(args[1]);
		System.out.println("Client is requesting, with port: " + port + " And address:" + address);
		
		@SuppressWarnings("resource")
		DatagramSocket socket = new DatagramSocket();
		
		for(int i = 0; i < 10; i++)
		{
			byte[] buf = new byte[256];
			DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
			socket.send(packet);
			Thread.sleep(1000);
			packet = new DatagramPacket(buf, buf.length);
			//System.out.println("Going to wait:client");
			socket.receive(packet);
			System.out.println("ping: " + packet.getAddress());
			System.out.flush();
		}
	}
}
