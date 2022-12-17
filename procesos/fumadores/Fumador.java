package fumadores;

public class Fumador implements Runnable {
    private final int ingredienteposeido;
    private final Mesa mesa;
    private final String nombrefumador;

    /**
     * Constructor de la clase Fumador
     * @param nombrefumador Nombre del fumador
     * @param ingredienteposeido Ingrediente que tiene el fumador
     * @param mesa Mesa común al estanquero y los fumadores
     */
    public Fumador(String nombrefumador, int ingredienteposeido, Mesa mesa){
        this.ingredienteposeido = ingredienteposeido;
        this.mesa = mesa;
        this.nombrefumador = nombrefumador;
    }

    @Override
    /**
     * Implementación del hilo
     */
    public void run(){
        while(!mesa.mesaVacia())
            mesa.cogerIngredientes(nombrefumador, ingredienteposeido);             
    }
    
}