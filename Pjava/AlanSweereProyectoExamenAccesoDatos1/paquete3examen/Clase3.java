package paquete3examen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Clase3 {

	public static void punto10(String urlScript, String urlPares, String urlNones) {
		
		try(BufferedWriter brW = new BufferedWriter(new FileWriter(urlScript)); 
			BufferedReader brp = new BufferedReader(new FileReader(urlPares));
			BufferedReader brn = new BufferedReader(new FileReader(urlNones));) {
			
		            brW.append("CREATE DATABASE numeros;");
		            brW.append("CREATE TABLE numeros.pares (ID int auto_increment PRIMARY KEY,numero INT,cuadrado INT);");
		            brW.append("CREATE TABLE numeros.nones (ID int auto_increment PRIMARY KEY,numero INT,cuadrado INT);");  

		            // creo las dos array para facilitarme el manejo
			        ArrayList<String> LineasPares = new ArrayList<>();
			        ArrayList<String> LineasNones = new ArrayList<>();
		            String lineap = "";
    		        while ((lineap = brp.readLine()) != null) {   	     
    		        	LineasPares.add(lineap);
    		        }
    		        String linean = "";
    		        while ((linean = brn.readLine()) != null) {   	     
    		        	LineasNones.add(linean);
    		        }
		            
		            // Los pares
		            brW.append("INSERT INTO numeros.pares VALUES ");
		            		 
					for (int i = 0; i < LineasPares.size()-2; i++) {
		                String[] arraylineap = LineasPares.get(i).split("\\|");
		                
		                brW.append(	"(" + null + "," + cambiaNumeric(arraylineap[1]) + "," + cambiaNumeric(arraylineap[2]) + ")," );
					}
					// La final con el ; en vez de la ,
	                String[] arrayUltimalineap = LineasPares.get(LineasPares.size()-1).split("\\|");
	                
	                brW.append(	"(" + null + "," + cambiaNumeric(arrayUltimalineap[1]) + "," + cambiaNumeric(arrayUltimalineap[2]) + ");" );	

                	//Los nones
					 brW.append("\n INSERT INTO numeros.nones VALUES ");
	 		            
					for (int i = 0; i < LineasNones.size()-2; i++) {
		                String[] arraylinean = LineasNones.get(i).split("\\|");
		                brW.append(	"(" + null + "," + cambiaNumeric(arraylinean[1]) + "," + cambiaNumeric(arraylinean[2]) + ")," );
					}
					
					// La final con el ; en vez de la ,
	                String[] arrayUltimalinean = LineasNones.get(LineasNones.size()-1).split("\\|");
	                brW.append(	"(" + null + "," + cambiaNumeric(arrayUltimalinean[1]) + "," + cambiaNumeric(arrayUltimalinean[2]) + ");" );	
	                
		        } catch (FileNotFoundException ex){
		            System.out.println("FileNotFound");
		        } catch (IOException ex) {
		            System.out.println("IOException");
		        }
		System.out.println("Script sql creado con exito");
	} // punto10

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
	
	public static void main(String[] args) {
		Clase3.punto10("C:\\Users\\Mañana\\eclipse-workspace\\ProyectoExamenAccesoDatos1\\src\\paquete3examen\\mi_script.txt", 
				"C:\\Users\\Mañana\\eclipse-workspace\\ProyectoExamenAccesoDatos1\\src\\paquete2examen\\pares.txt",
				"C:\\Users\\Mañana\\eclipse-workspace\\ProyectoExamenAccesoDatos1\\src\\paquete2examen\\nones.txt");		
	}
}
