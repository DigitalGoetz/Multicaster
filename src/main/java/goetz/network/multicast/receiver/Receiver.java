package goetz.network.multicast.receiver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Receiver {
	
	MulticastSocket socket;
	InetAddress group;
	
	public Receiver() throws IOException{
		socket = new MulticastSocket(4222);
		group = InetAddress.getByName("239.1.2.3");
		socket.joinGroup(group);
	}
	
	public void receive() throws IOException{
		DatagramPacket packet;
		
		while(true){
			byte[] buffer = new byte[256];
			packet = new DatagramPacket(buffer, buffer.length);
			socket.receive(packet);
			
			System.out.println("RECV: " + new String(packet.getData()));
		}
	}
	
	public static void main(String[] args) throws IOException {
		Receiver receiver = new Receiver();
		receiver.receive();
	}

}
