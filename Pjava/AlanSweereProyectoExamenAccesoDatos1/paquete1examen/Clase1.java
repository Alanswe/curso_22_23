package paquete1examen;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Clase1 {
	
	public static void puntoCuatro(String url) {
		 try (BufferedWriter brW = new BufferedWriter(new FileWriter(url))) {
			 
		     for (int i = 1; i < 10_001; i++) {
	             brW.append(i + "\n");
	         }// tendría una linea vacia al final (por si da problemas después)
		     
			 } catch (FileNotFoundException ex){
				 System.out.println("FileNotFound");
			 } catch (IOException ex) {
				 System.out.println("IOException");
			 }
	} // puntoCuatro
	
	public static void main(String[] args) {
		
		Clase1.puntoCuatro("C:\\Users\\Mañana\\eclipse-workspace\\ProyectoExamenAccesoDatos1\\src\\paquete1examen\\archivo1.txt");
	}
}
