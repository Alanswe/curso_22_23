package ficheros;
import java.io.FileWriter;
import java.io.IOException;

public class PocoAPocoWrite {
	public static void main(String[] args) {
		// Preparando los datos a escribir
		String linea01 = "¡Hola mundo!";
		String linea02 = "¡Adios mundo!";
		String[] lineas = {linea01, linea02}; 
		try(FileWriter fw = new FileWriter("/home/alan/Descargas/out.txt");){
			for (int i=0; i < lineas.length; i++) {
					fw.append(lineas[i]);
					if (i != lineas.length -1) fw.append("\n");
			}
		} catch (IOException e) {
			System.out.println("Problemas creando el archivo");
		} finally {
			System.out.println("Gracias por su confianza");
		}
	}
}