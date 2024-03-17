import java.io.IOException;
import java.net.*;

public class UDPPeerToPeer {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        // Create two threads, one for sending messages and another for receiving messages
        new Thread(new Sender()).start();
        new Thread(new Receiver()).start();
    }

    static class Sender implements Runnable {
        @Override
        public void run() {
            try (DatagramSocket socket = new DatagramSocket()) {
                InetAddress receiverAddress = InetAddress.getLocalHost();
                while (true) {
                    // Read message from user
                    String message = System.console().readLine();
                    byte[] sendData = message.getBytes();

                    // Send message to the receiver
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receiverAddress, PORT);
                    socket.send(sendPacket);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class Receiver implements Runnable {
        @Override
        public void run() {
            try (DatagramSocket socket = new DatagramSocket(PORT)) {
                byte[] receiveData = new byte[1024];
                while (true) {
                    // Receive message from sender
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    socket.receive(receivePacket);
                    String message = new String(receivePacket.getData(), 0, receivePacket.getLength());

                    // Print received message
                    System.out.println("Received: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
