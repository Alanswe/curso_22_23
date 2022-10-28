package herencia;

public class Serpiente extends Animal {
    boolean venenosa;
    
    public void show(){
        System.out.printf("Serpiente %s %s de %.2f gr.%n", 
                venenosa ? "venenosa" : "", color, peso);
    }
}
