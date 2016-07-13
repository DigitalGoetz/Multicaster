package goetz.network.multicast.sender;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {

	public void send(String message) throws IOException {
		byte[] buffer = message.getBytes();

		InetAddress group = InetAddress.getByName("239.1.2.3");
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, 4222);
		
		DatagramSocket socket = new DatagramSocket(5151);
		socket.send(packet);
		
		System.out.println("Message sent");
		
	}
	
	public static void main(String[] args) throws IOException {
		Sender sender = new Sender();
		sender.send("testmessage");
	}

}
