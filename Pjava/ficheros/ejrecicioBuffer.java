package ficheros;

import java.util.Random;
import java.io.*;

public class ejrecicioBuffer {
    
    public static void main(String[] args) {
        
        String nombre = "";
        String apellido1 = "";
        String apellido2 = "";
        int nacido = 0;
        
        String[] arrayNombres = {};
        String[] arrayApellidos = {};

        // Nombres
        try (BufferedReader br = new BufferedReader(new FileReader 
        ("C:\\Users\\Mañana\\Downloads\\Nombres.txt"))){
            String linea = "";
            while ((linea = br.readLine()) != null) {
                //System.out.println(linea);
                arrayNombres = linea.split(", ");
            }
        } catch (FileNotFoundException ex){
            System.out.println("FileNotFound");
        } catch (IOException ex) {
            System.out.println("IOException");
        }
        
        //Apellidos  
        try (BufferedReader br = new BufferedReader(new FileReader 
        ("C:\\Users\\Mañana\\Downloads\\Apellidos.txt"))){
            String linea = "";
            while ((linea = br.readLine()) != null) {
                //System.out.println(linea);
                arrayApellidos = linea.split(", ");
            }
        } catch (FileNotFoundException ex){
            System.out.println("FileNotFound");
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    
        // crear archivo sql
                
        try (BufferedWriter brW = new BufferedWriter(new 
        FileWriter("C:\\Users\\Mañana\\Downloads\\personasScriptFinal.sql"))) {
            //brW.append("CREATE DATABASE baseDeDatos;");
            //brW.append("CREATE TABLE personas (nombre VARCHAR(30),apellido1 VARCHAR(30),apellido2 VARCHAR(30), nacido INT)");
                
            /*
            for (int i = 0; i < 10_000; i++) {
                brW.append("INSERT INTO personas VALUES "
                        + "('" + generaNombre(arrayNombres) + "',"
                        + " '"+generaApellido(arrayApellidos)+"',"
                        + " '"+generaApellido(arrayApellidos)+"',"
                                + " "+generaNacido()+");");
            }
            */
            
            
            brW.append("INSERT INTO personas VALUES ");
            
            for (int i = 0; i < 9_999; i++) {
                brW.append("('" + generaNombre(arrayNombres) + "',"
                        + " '"+generaApellido(arrayApellidos)+"',"
                        + " '"+generaApellido(arrayApellidos)+"',"
                                + " "+generaNacido()+"),");
            }
            
           // La final con el ; en vez de la ,
            brW.append("('" + generaNombre(arrayNombres) + "',"
                    + " '"+generaApellido(arrayApellidos)+"',"
                    + " '"+generaApellido(arrayApellidos)+"',"
                            + " "+generaNacido()+");");
            
            brW.append(";");
            
            
        } catch (FileNotFoundException ex){
            System.out.println("FileNotFound");
        } catch (IOException ex) {
            System.out.println("IOException");
        }
        
        // pruebas 
        //System.out.println(generaNacido());
        //System.out.println(generaNombre(arrayNombres));
        //System.out.println(generaApellido(arrayApellidos));
    }

    private static String generaNombre(String[] nombres) {
        int min_val = 0 ;
        int max_val = 29;
        Random rand = new Random();
        int randomNum = min_val + rand.nextInt((max_val - min_val) + 1);
        return nombres[randomNum];
    
    }
    
    private static String generaApellido(String[] apellidos) {
        int min_val = 0 ;
        int max_val = 49;
        Random rand = new Random();
        int randomNum = min_val + rand.nextInt((max_val - min_val) + 1);
        return apellidos[randomNum];
    
    }
    
    private static int generaNacido() {
        int min_val = 1920 ;
        int max_val = 2022;
        Random rand = new Random();
        int randomNum = min_val + rand.nextInt((max_val - min_val) + 1);
        return randomNum;
    }
    
} 
