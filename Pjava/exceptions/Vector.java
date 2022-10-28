package exceptions;

class VectorOutOfBoundsException extends Exception {}

public class Vector {
    //Campos
    int x,y;
    static int xMax=  25, yMax = 25;
    // forma por cada horizonte o culumna su rango max tanto para su 
    //correspondente valor negativo y positivo
    
    //Construtores
    public Vector(int x, int y) {
        this.x = x > xMax ? xMax : x < -xMax ? -xMax : x;
        this.y = y > yMax ? yMax : y < -yMax ? -yMax : y;
    }

    public Vector(int z) {
        this(z, z);
    }
    
    //Métodos
    public Vector suma(Vector v) throws VectorOutOfBoundsException{
        
        int newX = this.x + v.x;
        int newY = this.y + v.y;
        
        if (newX > xMax || newX < -xMax || 
                newY > yMax || newY < -yMax ) {
            throw new VectorOutOfBoundsException();
        }
        //Vector NewV = new Vector(newX, newY);
        return new Vector(newX, newY);
    }
    
    @Override
    public String toString(){
        return "{"+ this.x + ", " + this.y + "}";
    }
        
    public static void main(String[] args) {
        Vector v1 = new Vector(5, 10);
        Vector v2 = new Vector(5);
        
        System.out.println(v1);
        System.out.println(v2);
        try {
            //System.out.println(v1.suma(v2));
            System.out.println(v2.suma(v2));
        } catch (VectorOutOfBoundsException ex) {
            System.out.println("Suma no realizada");
        }
    }
    
}
