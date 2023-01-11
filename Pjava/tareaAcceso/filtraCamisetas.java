package tareaAcceso;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.sql.*;

public class filtraCamisetas {
	//Windows
	/*
		static String urlWinCamisetas = "C:\\Users\\Mañana\\eclipse-workspace\\DDBB\\src\\tareaAcceso\\camisetas_2.txt";
		static String urlWinCamisetasCorrectas = "C:\\Users\\Mañana\\eclipse-workspace\\DDBB\\src\\tareaAcceso\\camisetas_sin_errores_de_linea_dos.txt";
		static String urlWinCamisetasCorrectasInCorretas = "C:\\Users\\Mañana\\eclipse-workspace\\DDBB\\src\\tareaAcceso\\camisetas_con_errores_de_linea.log"; 
		static String urlWinCamisetas_frecuencias_despues = "C:\\Users\\Mañana\\eclipse-workspace\\DDBB\\src\\tareaAcceso\\camisetas_frecuencias_despues.log";
		static String urlWinCamisetas_frecuencias_antes = "C:\\Users\\Mañana\\eclipse-workspace\\DDBB\\src\\tareaAcceso\\camisetas_frecuencias_antes.log";
		static String urlWinCamisetasCorrectasDos = "C:\\Users\\Mañana\\eclipse-workspace\\DDBB\\src\\tareaAcceso\\camisetas_sin_errores_de_linea_dos.txt";
		static String urlWinCamisetasFinales = "C:\\Users\\Mañana\\eclipse-workspace\\DDBB\\src\\tareaAcceso\\camisetas_finales.txt";
		static String urlWinScripSqlCamisetasFinales = "C:\\Users\\Mañana\\eclipse-workspace\\DDBB\\src\\tareaAcceso\\camisetas.sql";
		static String urlWincamisetasEvolucionInventarios = "C:\\Users\\Mañana\\eclipse-workspace\\DDBB\\src\\tareaAcceso\\camisetas_evolucion_inventarios.log";
		static String urlcamisetasExportadas = "C:\\Users\\Mañana\\eclipse-workspace\\DDBB\\src\\tareaAcceso\\camisetas_exportadas.txt";
	*/
	
	// Linux
		static String urlWinCamisetas = "/home/alan/eclipse-workspace/Dam/src/tareaAcceso/camisetas.txt";
		static String urlWinCamisetasCorrectas = "/home/alan/eclipse-workspace/Dam/src/tareaAcceso/camisetas_sin_errores_de_linea_dos.txt";
		static String urlWinCamisetasCorrectasInCorretas = "/home/alan/eclipse-workspace/Dam/src/tareaAcceso/camisetas_con_errores_de_linea.log";
		static String urlWinCamisetas_frecuencias_despues = "/home/alan/eclipse-workspace/Dam/src/tareaAcceso/camisetas_frecuencias_despues.log";
		static String urlWinCamisetas_frecuencias_antes = "/home/alan/eclipse-workspace/Dam/src/tareaAcceso/camisetas_frecuencias_antes.log";
		static String urlWinCamisetasCorrectasDos = "/home/alan/eclipse-workspace/Dam/src/tareaAcceso/camisetas_sin_errores_de_linea_dos.txt";
		static String urlWinCamisetasFinales = "/home/alan/eclipse-workspace/Dam/src/tareaAcceso/camisetas_finales.txt";
		static String urlWinScripSqlCamisetasFinales = "/home/alan/eclipse-workspace/Dam/src/tareaAcceso/camisetas.sql";
		static String urlWincamisetasEvolucionInventarios = "/home/alan/eclipse-workspace/Dam/src/tareaAcceso/camisetas_evolucion_inventarios.log";
		static String urlcamisetasExportadas = "/home/alan/eclipse-workspace/Dam/src/tareaAcceso/camisetas_exportadas.txt";

	public static void paso_1_a_3punto2(){
		
        ArrayList<String> LineasCorrectas = new ArrayList<>();
        ArrayList<String> LineasInCorrectas = new ArrayList<>();
        int numLineasCorrectas = 0;
        int numLineasInCorrectas= 0;
        
		 try (BufferedReader br = new BufferedReader(new FileReader 
		    (urlWinCamisetas))){
		        String linea = "";
		        while ((linea = br.readLine()) != null) {
		    	        		        	
		        	if (validaLinea(linea)) {
		            	LineasCorrectas.add(linea);
		            	numLineasCorrectas++;
		            }else {
		            	LineasInCorrectas.add(linea);
		            	numLineasInCorrectas++;
		            }
		            
		        }
		    } catch (FileNotFoundException ex){
		        System.out.println("FileNotFound");
		    } catch (IOException ex) {
		        System.out.println("IOException");
		    }

		 // crear camisetas_sin_errores_de_linea
		 try (BufferedWriter brW = new BufferedWriter(new 
			        FileWriter(urlWinCamisetasCorrectas))) {
			 
		     for (int i = 0; i < LineasCorrectas.size(); i++) {
	                brW.append(LineasCorrectas.get(i) + "\n");
	            }
		     System.out.println("Camisetas sin errores creada con exito");
			 } catch (FileNotFoundException ex){
				 System.out.println("FileNotFound");
			 } catch (IOException ex) {
				 System.out.println("IOException");
			 } 
		 
		 // crear camisetas_con_errores_de_linea
		 try (BufferedWriter brW = new BufferedWriter(new 
			        FileWriter(urlWinCamisetasCorrectasInCorretas))) {
			 brW.append("camisetas_con_errores_de_linea.log\r\n"
			 		+ "Total líneas analizadas: " + (numLineasCorrectas + numLineasInCorrectas) + "\r\n"
			 		+ "Total líneas eliminadas: "+ numLineasInCorrectas +"\r\n"
			 		+ "\r\nLas líneas eliminadas son:\r\n");
		     for (int i = 0; i < LineasInCorrectas.size(); i++) {
	                brW.append(LineasInCorrectas.get(i) + "\n");
	            }
		     System.out.println("Camisetas con errores creada con exito");
			 } catch (FileNotFoundException ex){
				 System.out.println("FileNotFound");
			 } catch (IOException ex) {
				 System.out.println("IOException");
			 }
	};
	
	public static void paso_3punto3(){
		 // leer erores_log
		 Map<String, Integer> mapCantidades = new TreeMap<String, Integer>();
		 Map<String, Integer> mapColores = new TreeMap<String, Integer>();
		 Map<String, Integer> mapMarca = new TreeMap<String, Integer>();
		 Map<String, Integer> mapModelo = new TreeMap<String, Integer>();
		 Map<String, Integer> mapTalla = new TreeMap<String, Integer>();

		 try (BufferedReader br2 = new BufferedReader(new FileReader(urlWinCamisetasCorrectas))){
		        String linea = "";
		        while ((linea = br2.readLine()) != null) {	
			        String[] arrayCampos = linea.split(",");
			        // mapCantidades
			        filtraCamisetas.generamap(arrayCampos, 1, mapCantidades);
			        // mapColores
			        filtraCamisetas.generamap(arrayCampos, 2, mapColores);
			        // mapMarca
			        filtraCamisetas.generamap(arrayCampos, 3, mapMarca);
			        // mapModelo
			        filtraCamisetas.generamap(arrayCampos, 4, mapModelo);
			        // mapTalla
			        filtraCamisetas.generamap(arrayCampos, 5, mapTalla);
       		}
		    } catch (FileNotFoundException ex){
		        System.out.println("FileNotFound");
		    } catch (IOException ex) {
		        System.out.println("IOException");
		    }
		 		 
		 // report camisetas_frecuencias_antes.log(urlWinCamisetas_frecuencias_antes) y urlWinCamisetas_frecuencias_despues
		 try (BufferedWriter brW2 = new BufferedWriter(new 
			        FileWriter(urlWinCamisetas_frecuencias_despues))) {

			 // COLORES
			 brW2.append(filtraCamisetas.getKey("\n---------------    COLORES    ---------------\n", mapColores));
			// MARCAS
			 brW2.append(filtraCamisetas.getKey("\n---------------    MARCAS    ---------------\n", mapMarca));
			// MODELOS
			 brW2.append(filtraCamisetas.getKey("\n---------------    MODELOS    ---------------\n", mapModelo));
			// TALLAS
			 brW2.append(filtraCamisetas.getKey("\n---------------    TALLAS    ---------------\n", mapTalla));
			// CANTIDADES
			 brW2.append(filtraCamisetas.getKey("\n---------------    CANTIDADES    ---------------\n", mapCantidades));

		     /*	
			 Iterator<String> color = mapColores.keySet().iterator();
		     	brW2.append("\n---------------    COLORES    ---------------\n");
		     	while(color.hasNext()){
					  String key = color.next();
					  brW2.append(key + " -> " + mapColores.get(key) + "\n" );
					  System.out.println(key + " -> " + mapColores.get(key) );	  	
					  */	  
					  
		     System.out.println("Log Camisetas frecuencias antes creada con exito");

				} catch (FileNotFoundException ex){
				 System.out.println("FileNotFound");
				} catch (IOException ex) {
				 System.out.println("IOException");
				}
	}
	
	private static void punto3punto4() {
	        ArrayList<String> LineasFinales = new ArrayList<>();

	    		 try (BufferedReader br = new BufferedReader(new FileReader 
	    		    (urlWinCamisetasFinales))){
	    		        String linea = "";
	    		        while ((linea = br.readLine()) != null) {   	     
	    		        	LineasFinales.add(linea);
	    		        }
	    		    } catch (FileNotFoundException ex){
	    		        System.out.println("FileNotFound");
	    		    } catch (IOException ex) {
	    		        System.out.println("IOException");
	    		    }
 
    		 // crear archivo sql
	        try (BufferedWriter brW = new BufferedWriter(new 
	        FileWriter(urlWinScripSqlCamisetasFinales))) {
	            brW.append("CREATE DATABASE camisetas;");
	            brW.append("CREATE TABLE camisetas.camiseta (ID int PRIMARY key auto_increment PRIMARY KEY,cantidad INT,"
	            		+ "color VARCHAR(30),marca VARCHAR(30),modelo VARCHAR(30), talla VARCHAR(10));");          
	            brW.append("INSERT INTO camisetas.camiseta VALUES ");
	            for (int i = 0; i < LineasFinales.size()-2; i++) {
	                String[] arraylinea = LineasFinales.get(i).split(",");
	                brW.append(	"("+null+","
	                		+ filtraCamisetas.cambiaNumeric(arraylinea[1]) + ","
	                        + 	" '"+ arraylinea[2]+"',"
	                        + 	" '"+ arraylinea[3]+"',"
                    		+ 	" '"+ arraylinea[4]+"',"
                        	+ 	" '"+ arraylinea[5]+"'),");
	            }
	                String[] arrayUltimalinea = LineasFinales.get(LineasFinales.size()-1).split(",");
	             // La final con el ; en vez de la ,
                	brW.append(	"("+null+","
            				+ filtraCamisetas.cambiaNumeric(arrayUltimalinea[1]) + ","
                            + 	" '"+ arrayUltimalinea[2]+"',"
                            + 	" '"+ arrayUltimalinea[3]+"',"
                    		+ 	" '"+ arrayUltimalinea[4]+"',"
                        	+ 	" '"+ arrayUltimalinea[5]+"');");
	        } catch (FileNotFoundException ex){
	            System.out.println("FileNotFound");
	        } catch (IOException ex) {
	            System.out.println("IOException");
	        }
	}
	
	// Punto B -------------------------------------------------------
	public static void showSQLExceptionInfo(SQLException e) {
		System.err.printf("SQL Exception        : %s%n", e.getClass().getSimpleName());
		System.err.printf("SQL ERROR mensaje    : %s%n", e.getMessage());
		System.err.printf("SQL Estado           : %s%n", e.getSQLState());
		System.err.printf("SQL Código específico: %s%n", e.getErrorCode());
	}
	
	private static int getSqlInt(String consulta) {
		String url = "jdbc:mysql://localhost:3306/camisetas?allowPublicKeyRetrieval=true&useSSL=false";
		String user = "root", pass = "";
		String sql = consulta;
		int resultado = 0;
		try(Connection conn = DriverManager.getConnection(url,user,pass);){
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				resultado = rs.getInt(1);
			}		
		} catch (SQLException e) {
			showSQLExceptionInfo(e);
		}
		return resultado;
	}
	
	private static void puntoB() {
		int consulta_1 = getSqlInt("SELECT COUNT(*) FROM camiseta");
		int consulta_2 = getSqlInt("SELECT COUNT(*) FROM camiseta WHERE talla = 'S';");
		int consulta_3 = getSqlInt("SELECT COUNT(*) FROM camiseta WHERE color  = 'rosa';");
		int consulta_4 = getSqlInt("SELECT COUNT(*) FROM camiseta WHERE marca  = 'Lacoste';");
		int consulta_5 = getSqlInt("SELECT COUNT(*) FROM camiseta WHERE modelo LIKE '%manga corta%';");
		int consulta_6 = getSqlInt("SELECT COUNT(*) FROM camiseta WHERE modelo LIKE '%mujer%' OR modelo LIKE '%Unisex%';");

		try (BufferedWriter brW = new BufferedWriter(new 
		        FileWriter(urlWincamisetasEvolucionInventarios))) {
			
				brW.append("Consultando en la base de datos:\n");
		            brW.append("-Número total de camisetas en el almacén : " + consulta_1 + "\n");
		            brW.append("-Número total de camisetas de la talla S en el almacén : " + consulta_2 + "\n");
		            brW.append("-Número total de camisetas de color rosa en el almacén : " + consulta_3 + "\n");
		            brW.append("-Número total de camisetas de la marca Lacoste en el almaćen : " + consulta_4 + "\n");
		            brW.append("-Número total de camisetas de manga corta en el almacén : " + consulta_5 + "\n");
		            brW.append("-Número total de camisetas de mujer en el almacén : " + consulta_6 + "\n");


		        } catch (FileNotFoundException ex){
		            System.out.println("FileNotFound");
		        } catch (IOException ex) {
		            System.out.println("IOException");
		        }
	}
	
	private static void puntoBpuntoDos() {
		String url = "jdbc:mysql://localhost:3306/camisetas?allowPublicKeyRetrieval=true&useSSL=false";
		String user = "root", pass = "";
		try(Connection conn = DriverManager.getConnection(url,user,pass);){
			String SQL = "DELETE FROM camisetas.camiseta WHERE color = 'amarillo';";
			Statement stm = conn.createStatement();
            int n = stm.executeUpdate(SQL);
            if (n>=0) {
            	System.out.println("Registro Eliminado");
                //JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
        }catch (Exception e){
        	System.out.println("Error de Registro" + e.toString());
            //JOptionPane.showMessageDialog(null, "Error de Registro" + e.toString());
        }
	}
	
	// Punto C -------------------------------------------------------
		private static ArrayList<String> getSqlArray() {
			String url = "jdbc:mysql://localhost:3306/camisetas?allowPublicKeyRetrieval=true&useSSL=false";
			String user = "root", pass = "";
			String sql = "SELECT * FROM camiseta";
	        ArrayList<String> resultado = new ArrayList<>();
			try(Connection conn = DriverManager.getConnection(url,user,pass);){
					Statement stm = conn.createStatement();
					ResultSet rs = stm.executeQuery(sql);
				while(rs.next()) {
					resultado.add(rs.getInt(1)+","+rs.getInt(2)+","+rs.getString(3)
					+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6)+"\n");
					//System.out.printf(rs.getInt(1)+","+rs.getInt(2)+","
					//+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6)+"\n");
				}		
			} catch (SQLException e) {
				showSQLExceptionInfo(e);
			}			
				return resultado;
		}
		
		private static void puntoC(ArrayList<String> ArrayList) {
			try (BufferedWriter brW = new BufferedWriter(new 
			        FileWriter(urlcamisetasExportadas))) {
			 
		     for (int i = 0; i < ArrayList.size(); i++) {
	                brW.append(ArrayList.get(i));
	            }
		     System.out.println("Camisetas exportadas creada con exito");
			 } catch (FileNotFoundException ex){
				 System.out.println("FileNotFound");
			 } catch (IOException ex) {
				 System.out.println("IOException");
			 } 
		}

	// métodos ----------------------------------------------------------------------------------
	private static void generamap(String[] arrayCampos,int indice,Map<String, Integer> mapa) {
		// mapCantidades
        String key = arrayCampos[indice];
        if (mapa.containsKey(key)) {
        	mapa.put(key,mapa.get(key)+1);
        } else {
        	mapa.put(key,1);
        }
	}
	private static String getKey(String titulo,Map<String, Integer> mapa) {
		String linea = "";
		linea += titulo;
		for (String key : mapa.keySet()) {
			linea += key + " -> " + mapa.get(key) + "\n";
		}
		return linea;
	}
	
	private static int cuentaComas(String linea) {
		int numSinComas = linea.replace(",", "").length();
        int numComas = linea.length() - numSinComas;
        return numComas;
    }
	private static boolean validaLinea(String linea) {
        boolean resultado;
        String[] arrayCampos = linea.split(",");

        if (cuentaComas(linea) != 5 || linea.contains(",     ,") 
        		|| !(isNumeric(arrayCampos[1]))/*si es número es true así que !*/ ) {
        	
        	resultado = false;
        }else{
        	resultado = true;
        }
        return resultado;
    }
	private static int cambiaNumeric(String cadena) {
        int resultado = 0;
        try {
            resultado = Integer.parseInt(cadena);
        } catch (NumberFormatException excepcion) {
        	resultado = 0;
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
	private static String limpiaLineaAcentosYEnnie(String linea) {	
		//quito acentos y ñ
		String lineaLimpia = linea;
		lineaLimpia = lineaLimpia.replaceAll("á", "a");
		lineaLimpia = lineaLimpia.replaceAll("é", "e");
		lineaLimpia = lineaLimpia.replaceAll("í", "i");
		lineaLimpia = lineaLimpia.replaceAll("ó", "o");
		lineaLimpia = lineaLimpia.replaceAll("ú", "u");
		lineaLimpia = lineaLimpia.replaceAll("Á", "A");
		lineaLimpia = lineaLimpia.replaceAll("É", "E");
		lineaLimpia = lineaLimpia.replaceAll("Í", "I");
		lineaLimpia = lineaLimpia.replaceAll("Ó", "O");
		lineaLimpia = lineaLimpia.replaceAll("Ú", "U");
		lineaLimpia = lineaLimpia.replaceAll("ñ", "n");
		return lineaLimpia;
	}
	
	// main
	public static void main(String[] args) {
		//filtraCamisetas.paso_1_a_3punto2();
		//filtraCamisetas.paso_3punto3();
		//filtraCamisetas.punto3punto4();
		//filtraCamisetas.puntoB();
		//filtraCamisetas.puntoBpuntoDos();
		//filtraCamisetas.getSqlArray();
		//filtraCamisetas.puntoC(getSqlArray());
	} 
}
