package contactskeeper.achaturvedi.com.udpclient;

import android.util.Log;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by achaturvedi on 11/19/2015.
 */
public class Second implements Runnable {
    Second()
    {
        run();
    }
    public void run() {
        // TODO Auto-generated method stub
        try {

            String messageStr = "Hello from Android!";
            int server_port = 53359;
            DatagramSocket s = new DatagramSocket();
            //InetAddress local = InetAddress.getByName("172.26.102.171");
            InetAddress local = InetAddress.getByName("192.168.0.13");
            int msg_length = messageStr.length();
            byte[] message = messageStr.getBytes();
            DatagramPacket p = new DatagramPacket(message, msg_length, local,
                    server_port);
            s.send(p);

            //receive stream of UDP data from the server
            byte[] buffer = new byte[65536];
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            s.receive(receivePacket);
            System.out.println("3");
            String sentence = new String(receivePacket.getData(),0,receivePacket.getLength());

            Log.i("UDPClient", "Received this data from the server..... \n " + sentence);

        } catch (Exception e) {

        }
    }
}
