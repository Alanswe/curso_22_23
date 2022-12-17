package filosofosComensales;

public class Tenedor {
    private boolean tomado = false;

    public synchronized void tomar(){
        while (tomado) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.err.println("Error al tomar el tenedor");
            }
        }
        tomado = true;
    }

    public synchronized void dejar() {
        tomado = false;
        // Cambia notify por notifyAll y mira que pasa
        // Ahora rompe el interbloqueo, codigo del main del if...
        notify();
    }
    
}

