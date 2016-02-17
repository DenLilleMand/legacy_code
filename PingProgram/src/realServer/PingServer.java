package realServer;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class PingServer 
{
	private static final double LOSS_RATE = 0.0;
	private static final int AVERAGE_DELAY = 100; // milliseconds

	public static void main(String[] args) throws Exception 
	{

		int port = Integer.parseInt(args[0]);
		System.out.println(port);

		Random random = new Random();

		@SuppressWarnings("resource")
		DatagramSocket socket = new DatagramSocket(port);
		
		while (true) 
		{
			DatagramPacket request = new DatagramPacket(new byte[1024], 1024);

			socket.receive(request);

			printData(request);

			if (random.nextDouble() < LOSS_RATE) {
				System.out.println("   Reply not sent.");
				continue;
			}

			Thread.sleep(2000);

			InetAddress clientHost = request.getAddress();
			int clientPort = request.getPort();
			byte[] buf = request.getData();
			DatagramPacket reply = new DatagramPacket(buf, buf.length,clientHost, clientPort);
			socket.send(reply);
			System.out.println("   Reply sent.");
		}

	}

	private static void printData(DatagramPacket request) throws Exception
	{
		byte[] buf =request.getData();
		ByteArrayInputStream bais = new ByteArrayInputStream(buf);
		InputStreamReader isr = new InputStreamReader(bais);
		BufferedReader br = new BufferedReader(isr);
		String line = br.readLine();
		System.out.println("Received from " +  request.getAddress().getHostAddress() +  ": " + new String(line));
	}
}
