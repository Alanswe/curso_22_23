package hilosincdec;

class Contador {

  private int cuenta = 0;
  private int tope = 10_000;
  
  /*TODO:
   *  (HECHO) Que exista también un valor máximo para el contador.
   *  (HECHO) Verifica que nunca sobrepasa el valor máximo.
   * */
  
  Contador(int valorInicial) {
    this.cuenta = valorInicial;
  }

  public int getTope() {
	return tope;
}

synchronized public int getCuenta() {
    return cuenta;
  }
  
  /*Para que llegue a un tope, le pongo un límite en el método incrementa en el
  *    que le indico que mientras que cuenta sea menor a 10_000, sin necesidad de retocar el decrementa
  *    Para ver mejor el resultado puse un mensaje cuando alcanza el tope indicado.
  *Cuando se repite el incrementa después de alcanzar el tope es porque este no afecta a la capacidad de aleatoriedad de activación de DES o INC
  */
  
  synchronized public int incrementa() {
	  if (this.cuenta < getTope()) {
		  this.cuenta++;
	  } else {
		  System.err.println("---------------------------------------------- ¡TOPE DE CUENTA ALCANZADO! ----------------------------------------------");
		  
	  }
    return cuenta;
  }

  synchronized public int decrementa() {
	  this.cuenta--;
    return cuenta;
  }

}

class HiloIncr implements Runnable {

  private final String id;
  private final Contador cont;

  HiloIncr(String id, Contador c) {
    this.id = id;
    this.cont = c;
  }

  @Override
  public void run() {
    while (true) {
      synchronized (this.cont) {
        this.cont.incrementa();
        this.cont.notify();
        System.out.printf("Hilo %s incrementa, valor contador: %d\n", this.id,
                this.cont.getCuenta());
      }
    }
  }
}

class HiloDecr implements Runnable {

  private final String id;
  private final Contador cont;

  HiloDecr(String id, Contador c) {
    this.id = id;
    this.cont = c;
  }

  @Override
  public void run() {
    while (true) {
      synchronized (this.cont) {
        while (this.cont.getCuenta() < 1) {
          System.out.printf("!!! Hilo %s no puede decrementar, valor contador: %d\n",
                  this.id, this.cont.getCuenta());
          try {
            this.cont.wait();
          } catch (InterruptedException ex) {
          }
        }
        this.cont.decrementa();
        System.out.printf("Hilo %s decrementa, valor contador: %d\n", this.id,
                this.cont.getCuenta());
      }
    }
  }
}

class HilosIncDec {

  private static final int NUM_HILOS_INC = 10;
  private static final int NUM_HILOS_DEC = 10;

  public static void main(String[] args) {
    Contador c = new Contador(0);
    
    // INC
    Thread[] hilosInc = new Thread[NUM_HILOS_INC];
    for (int i = 0; i < NUM_HILOS_INC; i++) {
      Thread th = new Thread(new HiloIncr("INC"+i, c));
      hilosInc[i] = th;
    }
    // DES
    Thread[] hilosDec = new Thread[NUM_HILOS_DEC];
    for (int i = 0; i < NUM_HILOS_DEC; i++) {
      Thread th = new Thread(new HiloDecr("DEC"+i, c));
      hilosDec[i] = th;
    }
    
    
    //---------------------------
    for (int i = 0; i < NUM_HILOS_INC; i++) {
      hilosInc[i].start();
    }
    for (int i = 0; i < NUM_HILOS_DEC; i++) {
      hilosDec[i].start();   
    }
    
    
  }
}
