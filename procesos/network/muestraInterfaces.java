package network;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class muestraInterfaces {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();
                System.out.println("Interface: " + ni.getName());
                System.out.println("Display Name: " + ni.getDisplayName());
                System.out.println("Is up: " + ni.isUp());
                System.out.println("Is loopback: " + ni.isLoopback());
                System.out.println("Is virtual: " + ni.isVirtual());
                System.out.println();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}