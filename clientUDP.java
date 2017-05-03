import java.io.*;
import java.net.*;
import java.util.Scanner;


/**
 * Created by Alessandro Arosio on 27/03/2017.
 */
public class clientUDP {
    public static void main(String[] args) throws Exception {

        /** Prompt user to input a string, then split in half generating two strings */
        String firstHalf, secondHalf;
        System.out.println("Input a string to be sent to the UDP server: ");
        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();
        if ((userInput.length() % 2) == 0 ) {      // string is even
            firstHalf  = userInput.substring(0, (userInput.length()/2));
            secondHalf = userInput.substring((userInput.length()/2));
        }
        else {          // string is odd
            firstHalf = userInput.substring(0, ((userInput.length()+1)/2));
            secondHalf = userInput.substring((userInput.length()+1)/2);
        }

        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPaddress = InetAddress.getByName("localhost");
        byte[] sendData1 = new byte[1024];
        byte[] sendData2 = new byte[1024];
        byte[] receiveData = new  byte[2048];
        sendData1 = firstHalf.getBytes();
        sendData2 = secondHalf.getBytes();
        DatagramPacket sendPacket1 = new DatagramPacket(sendData1, sendData1.length, IPaddress, 9876);
        DatagramPacket sendPacket2 = new DatagramPacket(sendData2, sendData2.length, IPaddress, 9876);

        clientSocket.send(sendPacket1);
        clientSocket.send(sendPacket2);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String receivedString = new String(receivePacket.getData(), receivePacket.getOffset(),receivePacket.getLength());
        System.out.println("Received from my server : " + receivedString);
        clientSocket.close();
    }
}
