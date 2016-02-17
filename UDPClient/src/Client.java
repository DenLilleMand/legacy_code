import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class Client 
{
	private final static int PORT = 1048;
    private static DatagramSocket sock = null;
    private static InetAddress host;
	
	
	
	public static void main(String[] args) throws Exception 
	{
		sock = new DatagramSocket();       
		host = InetAddress.getByName("localhost");	
		String data = "hej";
		byte[] byteArray = new byte[2048];
		byteArray = data.getBytes();
		
		
		DatagramPacket packet = new DatagramPacket(byteArray, byteArray.length,host,PORT);
		sock.send(packet);
		
		DatagramPacket request = new DatagramPacket(byteArray,byteArray.length);
		sock.receive(request);
		
		data = new String(byteArray, 0, byteArray.length,"UTF-8");
		System.out.println(data);
		
	}

}
