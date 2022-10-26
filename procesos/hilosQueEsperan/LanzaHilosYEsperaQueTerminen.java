package hilosQueEsperan;

import java.util.Random;

class Hilo implements Runnable {

  private final String nombre;

  Hilo(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public void run() {
    System.out.printf("Hola, soy el hilo: %s.\n", this.nombre);
    for (int i = 0; i < 5; i++) {
      Random r = new Random();
      int pausa = 10 + r.nextInt(500 - 10);
      System.out.printf("Hilo: %s hace pausa de %d ms.\n", this.nombre, pausa);
      try {
        Thread.sleep(pausa);
      } catch (InterruptedException e) {
        System.out.printf("Hilo %s interrumpido.\n", this.nombre);
      }
    }
    System.out.printf("Hilo %s terminado.\n", this.nombre);
  }

}

public class LanzaHilosYEsperaQueTerminen {

  public static void main(String[] args) {

    Thread h1 = new Thread(new Hilo("H1"));
    Thread h2 = new Thread(new Hilo("H2"));
    h1.start();
    h2.start();
    try {
      h1.join();
      h2.join();
    } catch (InterruptedException ex) {
      System.out.println("Hilo principal interrumpido.");
    }
    System.out.println("Hilo principal terminado.");

  }

}
