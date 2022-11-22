package connectionDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnectionMejorado {
	
	public static void showSQLExceptionInfo(SQLException e) {
		System.err.printf("SQL Exception        : %s%n", e.getClass().getSimpleName());
		System.err.printf("SQL ERROR mensaje    : %s%n", e.getMessage());
		System.err.printf("SQL Estado           : %s%n", e.getSQLState());
		System.err.printf("SQL Código específico: %s%n", e.getErrorCode());
	}
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/baseDeDatos?allowPublicKeyRetrieval=true&useSSL=false";
		String user = "root", pass = "";
		System.out.println("Estableciendo conexión");
		try(Connection conn = DriverManager.getConnection(url,user,pass);){
			System.out.println("Conexión establecida con éxito");
		} catch (SQLException e) {
			showSQLExceptionInfo(e);
		}
		System.out.println("bye");
	}
	
}