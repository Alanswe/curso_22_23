package transferenciasinbloqueo;

public class Cuenta {
  
  int saldo;
  final String numCuenta;

  public Cuenta(String numCuenta, int saldoInicial) {
    this.saldo = saldoInicial;
    this.numCuenta = numCuenta;
  }
  
  public synchronized int getSaldo() {
    return this.saldo;
  }
  
  public synchronized void ingresar(int cantidad) {
    this.saldo += cantidad;
  }
  
  public synchronized void sacar(int cantidad) {
    this.saldo -= cantidad;
  }
  
  public String getNumCuenta() {
    return this.numCuenta;
  }
  
}
