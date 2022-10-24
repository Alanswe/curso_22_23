package FileUtils;

import FileUtils.FileUtils;
import java.io.File;

public class Test {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\Mañana\\Documents\\NetBeansProjects\\JavaJavi\\_midir");
        FileUtils.analiza(f);
        System.out.println("-------------");
        File f1 = new File("_midir/filetxt.txt");
        FileUtils.analiza(f1);
        
    }
        
    
}
