
package herencia;

public class Animal {
    String color;
    double peso;
    
    public String toString(){
        return String.format("Animal %s de %.2f gr.%n", color, peso);
    }
}