//udp server program
import java.net.*;
import java.io.*;
class udps {
	public static void main(String args[]) {
	DatagramSocket ds=null;
	DatagramPacket dp=null, reply;
	try {
		ds=new DatagramSocket(1234);
		byte[] buffer=new byte[1000];
		dp=new DatagramPacket(buffer, buffer.length);
		ds.receive(dp);
		System.out.println("From Client: "+(new String(dp.getData()).trim()));
		System.out.println("client port:"+dp.getPort());
		reply = new DatagramPacket("From Server OK". getBytes(), "From Server OK".length(),dp.getAddress(), 		dp.getPort());
		ds.send(reply); }
		catch (Exception e) {
 		System.out.println("socket:"+e.getMessage()); }
		finally {
			if(ds!=null)
			ds.close();  
		}
	     }
	 } 