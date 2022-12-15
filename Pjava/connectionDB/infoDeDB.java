package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class infoDeDB {

	public static void showSQLExceptionInfo(SQLException e) {
		System.err.printf("SQL Exception        : %s%n", e.getClass().getSimpleName());
		System.err.printf("SQL ERROR mensaje    : %s%n", e.getMessage());
		System.err.printf("SQL Estado           : %s%n", e.getSQLState());
		System.err.printf("SQL Código específico: %s%n", e.getErrorCode());
	}
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/baseDeDatos?allowPublicKeyRetrieval=true&useSSL=false";
		//String urlSQLite = "jdbc:sqlite:/home/alan/eclipse-workspace/Dam/src/connectionDB/baseDeDatos.sqlite";
		// Para SQLite
		String user = "root", pass = "";
		String sql = "SELECT * FROM personas";
		System.out.println("Estableciendo conexión");
		try(Connection conn = DriverManager.getConnection(url,user,pass);){
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql);
			System.out.println("Conexión establecida con éxito");
			int counter =0;
			int index = 0;
			while(rs.next()) {
				if(rs.getInt("nacido") % 10 == 0) {
					System.out.printf("%d[%s,%s,%s,%s]%n",index, rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
					counter++;
				}
				index++;
			}
			System.out.printf("Elementos mostrados: %d%n", counter);
		
		} catch (SQLException e) {
			showSQLExceptionInfo(e);
		}
			System.out.println("bye");
	}
		
	
	
	
	
}
