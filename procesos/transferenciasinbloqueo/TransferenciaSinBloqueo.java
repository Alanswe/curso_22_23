package transferenciasinbloqueo;

import java.util.Random;

class Hilo implements Runnable {

  Cuenta c1, c2;
  String nomHilo;

  Hilo(Cuenta c1, Cuenta c2, String nomHilo) {
    this.c1 = c1;
    this.c2 = c2;
    this.nomHilo = nomHilo;
  }

  @Override
  public void run() {
    int cantidad = 10;
    int numTransf = 0;
    for (int i = 0; i < 10000; i++) {
      if (GestorTransferencias.transferencia(c1, c2, cantidad)) {
        numTransf++;
      }
    }
    System.out.printf("**** FIN de %s, %d transferencias hechas de %s a %s.\n",
            this.getNomHilo(), numTransf, c1.getNumCuenta(), c2.getNumCuenta());
  }

  public String getNomHilo() {
    return nomHilo;
  }

}

public class TransferenciaSinBloqueo {

  public static void main(String[] args) {

    Cuenta c1 = new Cuenta("ES1512345678901234567890", 12500);
    Cuenta c2 = new Cuenta("ES4578901234567890123456", 23400);
    
    System.out.printf("Saldo inicial de %s: %d\n", c1.getNumCuenta(), c1.getSaldo());
    System.out.printf("Saldo inicial de %s: %d\n", c2.getNumCuenta(), c2.getSaldo());
    System.out.println("---------------------------------------");

    // Dos hilos, uno que hace transferencias de c1 a c2, y otro que hace transferencias de c2 a c1.
    Thread h1 = new Thread(new Hilo(c1, c2, "H1"));
    Thread h2 = new Thread(new Hilo(c2, c1, "H2"));

    h1.start();
    h2.start();

    /*
     * Realice un Random para que me convertirá en aleatorio la salida de true o false,
     * después dentro de un try solo si se conseguía el true se pone en pausa uno u otro
     * haciendo así que pueda variar la cifra resultante final del saldo de la cuenta haciendo así,
     * que sea mucho más difícil que se produzca el interbloqueo. 
     * */
    
    Random numAleatorio = new Random();
    boolean esperaAleatoria = numAleatorio.nextBoolean();
    
    try {
    	if (esperaAleatoria) {
    		h1.sleep(1000);
    	}else {
    		h2.sleep(1000);
    	}	
	} catch (InterruptedException e) {
		System.err.println("Error en la espera");
		e.printStackTrace();
	}
    

    try {
      h1.join();
      h2.join();
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }

    System.out.println("---------------------------------------");
    System.out.printf("Saldo final en %s : %d\n", c1.getNumCuenta(), c1.getSaldo());
    System.out.printf("Saldo final en %s : %d\n", c2.getNumCuenta(), c2.getSaldo());

  }

}
