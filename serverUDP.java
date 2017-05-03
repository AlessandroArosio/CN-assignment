import java.net.*;

/**
 * Created by Alessandro Arosio on 27/03/2017.
 */
public class serverUDP {
    public static void main(String[] args) throws Exception {
        String mergeMessage;
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData1 = new byte[1024];
        byte[] receiveData2 = new byte[1024];
        byte[] sendData = new byte[2048];

        while (true) {

            DatagramPacket receivePacket1 = new DatagramPacket(receiveData1, receiveData1.length);
            serverSocket.receive(receivePacket1);

            String message1 = new String(receivePacket1.getData(), 0, receivePacket1.getLength());

            DatagramPacket receivePacket2 = new DatagramPacket(receiveData2, receiveData2.length);
            serverSocket.receive(receivePacket2);
            String message2 = new String(receivePacket2.getData(), 0, receivePacket2.getLength());

            System.out.println("Received from client: " + message1 + " + " + message2);
            InetAddress IPAddress = receivePacket1.getAddress();
            int port = receivePacket1.getPort();
            mergeMessage = message1.toString() + message2.toString();
            System.out.println("Strings merged: " + mergeMessage);
            String replyFromServer = new String(new StringBuilder(mergeMessage).reverse());
            System.out.println("String reversed: " + replyFromServer);
            sendData = replyFromServer.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}
