package network;

import java.net.*;
import java.util.Enumeration;
import java.util.*;

public class Ejercicio3_5 {
	public static void main(String[] args) {	
		try {
			// Obtenemos una enumeración de las interfaces de red disponibles en el sistema
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			// Recorremos cada interfaz en la enumeración
			for (NetworkInterface interfaz : Collections.list(interfaces)) {
				System.out.println("Nombre display" + interfaz.getDisplayName());
				System.out.println("Nombre en nuestro equipo: " + interfaz.getName() + "\n");
			}
						
		} catch (SocketException e) {
			// Si ocurre una excepción de socket, imprimimos un mensaje de error y mostramos la traza
			System.out.println("Error en la busqueda de interfaces en red");
			e.printStackTrace();
		}
			
	}
	

	
	
}
