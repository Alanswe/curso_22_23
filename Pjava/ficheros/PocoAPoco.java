
package ficheros;

import java.io.FileWriter;
import java.io.IOException;


public class PocoAPoco {
   
    public static void main(String[] args) {
        String prueba = "Hola, esto es una prueba para escribir en un archivo de texto";

        try (FileWriter fw = new FileWriter("/home/alan/Descargas/out.txt");) {
            fw.append(prueba);
        } catch (IOException ex) {
            System.out.println("Problemas creando el archivo");
        } finally {
            System.out.println("Se acabo");
        }
    }
    
     
}
