package connectionDB;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
	public static void main(String[] args) {
		
		String urlSqlLite = "jdbc:sqlite:C:\\Users\\Mañana\\AppData\\Roaming\\DBeaverData\\workspace6\\.metadata\\sample-database-sqlite-1\\Chinook.db";
		String urlMysql = "jdbc:mysql://localhost:3306/baseDeDatos?useSSL=false";
		
		String user = "root", pass = "";
		try {
			System.out.println("Estableciendo conexión");
			Connection conn = DriverManager.getConnection(urlSqlLite,user,pass);
			System.out.println("Conexión establecida con éxito");
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("bye");
	}
}
