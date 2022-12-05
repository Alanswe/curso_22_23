package transferenciasinbloqueo;

public class GestorTransferencias {

  public static boolean transferencia(Cuenta c1, Cuenta c2, int cantidad) {
      /*Debido a que queremos que el bloqueo sea en la primera cuenta que
       * introducimos en vez de la cuenta más baja como estaba antes,
       * procedo a eliminar el primer if que condiciona el orden de c1 y c2,
       * también tengo que borrar el synchronized ya que no quiero que se sincronice
       * dejo el resultado
       * */
    boolean result = false;
    if (c1.getSaldo() >= cantidad) {
      c1.sacar(cantidad);
      c2.ingresar(cantidad);
      result = true;
    }
    return result;
  }

}
