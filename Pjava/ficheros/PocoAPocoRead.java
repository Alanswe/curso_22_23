package ficheros;
import java.io.FileReader;
import java.io.IOException;

public class PocoAPocoRead {
	public static void main(String[] args) {
		try(FileReader fr = new FileReader("/home/alan/Descargas/out.txt");){
			System.out.printf("Encoding: %s%n", fr.getEncoding());
			int c = 0;
			while((c = fr.read()) != -1) {
				System.out.print((char)c);
			}
			System.out.println();
		} catch (IOException e) {
			System.out.println("Problemas abriendo el archivo");
		} finally {
			System.out.println("Gracias por su confianza");
		}
	}
}