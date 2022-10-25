void main() {
  int start = 1700, stop = 1951, step = 10;
  int multiplos = 0;
  int contador = 0;
  String resultado = "";

  if (start >= stop || start < 0 || step < 0) {
    print("Para los valores de las variables indicadas no es posible " +
        "realizar la operación solicitada.");
  } else {
    for (int i = stop; i > start; i--) {
      if (i % step == 0) {
        multiplos++;
        contador++;
        if (contador == 10) {
          resultado += "$i \n";
          contador = 0;
        } else {
          resultado += "$i ";
        }
      }
    }
    print("La cuenta atrás de $step en $step desde $stop hasta $start es : " +
        "\n$resultado");
    print("\nTotal números mostrados: $multiplos");
  }
}
