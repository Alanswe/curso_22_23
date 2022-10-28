package herencia;

public class Test {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.peso = 2000;
        a.color = "rojo";
        System.out.println(a);
        
        Gato g = new Gato();
        g.peso = 3000;
        g.color = "azul";
        System.out.println(g);
        
        Serpiente s = new Serpiente();
        s.peso = 150;
        s.color = "amarillo";
        s.venenosa = true;
        System.out.println(s);

        
    }
    

    
    
    
}