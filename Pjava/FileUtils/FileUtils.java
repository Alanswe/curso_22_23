package FileUtils;

import java.io.File;

public class FileUtils {
    
    public static boolean analiza(File f) {
        
        if (f != null){
            if (f.exists() == true){
                boolean lectura = f.canRead();
                boolean escritura = f.canWrite();
                boolean ejecutable = f.canExecute();
                String parent = f.getParent();
                String name = f.getName();
                // en caso de que sea un archivo
                if (f.isFile()== true){
                    long tamanio = f.length()/(1024*1014);
                    System.out.printf("Tamaño : %d Mb %n",tamanio);
                    
                } else {
                    if (f.isDirectory() == true) {
                        File[] files = f.listFiles();
                        System.out.println("Listado de los archivos"
                                + " que contiene: ");
                        for(File file: files){
                            System.out.println(file);
                        }
                        System.out.println("");
                    }
                }
                
                System.out.printf("Permiso de lectura: %b %n"
                        + "Permiso de escritura : %b %n"
                        + "Permiso de ejecución: %b %n"
                        + "Su parent es %s %n"
                        + "Su nombre es: %s %n",
                        lectura,escritura,ejecutable,parent,name);
                
                return true;
            } else {
                System.out.println("The file does not exist or does not match"
                        + " the path");                    
                return false;
            }
            
        } else {
            System.out.println("The file is null");            
            return false;
        }
        
        
        
    }
    
}
