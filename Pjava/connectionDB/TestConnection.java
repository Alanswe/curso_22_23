package connectionDB;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
	public static void main(String[] args) {
		
		String urlSqlite = "jdbc:sqlite:C:\\Users\\Mañana\\eclipse-workspace\\DB\\baseDedatos.sqlite";
		String urlMysql = "jdbc:mysql://localhost:3306/baseDeDatos?useSSL=false";
		
		String user = "root", pass = "";
		try {
			System.out.println("Estableciendo conexión");
			Connection conn = DriverManager.getConnection(urlSqlite,user,pass);
			System.out.println("Conexión establecida con éxito");
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("bye");
	}
}
