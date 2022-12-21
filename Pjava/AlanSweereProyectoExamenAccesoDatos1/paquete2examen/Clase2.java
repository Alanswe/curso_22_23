package paquete2examen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Clase2 {

	public static void puntoSiete(String urlRead,String urlPares,String urlNones) {
	        int indicePares = 1;
	        int indiceNones = 1;
	        
			try(BufferedReader br = new BufferedReader(new FileReader(urlRead)); 
				BufferedWriter wrp = new BufferedWriter(new FileWriter(urlPares));
				BufferedWriter wrn = new BufferedWriter(new FileWriter(urlNones));){
			
				String linea = "";
				while((linea = br.readLine())!= null) {
					if(Clase2.isNumeric(linea)) {
						
						int numero = (Clase2.cambiaNumeric(linea));
						
						if(Clase2.cambiaNumeric(linea) % 2 == 0) {
							wrp.append(indicePares + "|" + numero + "|" + (numero * numero) + "\n");
							indicePares++;
						} else {
							wrn.append(indiceNones + "|" + numero + "|" + (numero * numero) + "\n");
					        indiceNones++;
						}
					}else {System.err.println("No se puede cambiar a entero el dato introducido");}
				}
			 } catch (FileNotFoundException ex){
				 System.out.println("FileNotFound");
			 } catch (IOException ex) {
				 System.out.println("IOException");
			 }		
	} // puntoSiete
	
	private static int cambiaNumeric(String cadena) {
        int resultado = 0;
        try {
            resultado = Integer.parseInt(cadena);
        } catch (NumberFormatException excepcion) {
        	resultado = 0;
        	System.err.println("Error en parse a INT (Determinado a 0)");
        }
        return resultado;
    }
	
	private static boolean isNumeric(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
	
	public static void main(String[] args) {
		Clase2.puntoSiete("C:\\Users\\Mañana\\eclipse-workspace\\ProyectoExamenAccesoDatos1\\src\\paquete1examen\\archivo1.txt",
				"C:\\Users\\Mañana\\eclipse-workspace\\ProyectoExamenAccesoDatos1\\src\\paquete2examen\\pares.txt",
				"C:\\Users\\Mañana\\eclipse-workspace\\ProyectoExamenAccesoDatos1\\src\\paquete2examen\\nones.txt");
	}
}
