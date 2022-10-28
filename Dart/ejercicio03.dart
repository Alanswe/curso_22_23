void main() {
  int start = 200, stop = 300, multiplo = 10;
  int numMultiplosSinBucle = 0;
  int sumaDeMultiplosConBucle = 0;

  //Con bucle
  if (start >= stop || start < 0 || multiplo < 0) {
    print("Para los valores de las variables indicadas no es posible realizar" +
        " la operación solicitada.");
  } else {
    for (int i = start; i <= stop; i++) {
      if (i % multiplo == 0) {
        sumaDeMultiplosConBucle += i;
        print(i);
      }
    }
  }

  //Sin bucle
  if (start >= stop || start < 0 || multiplo < 0) {
    print("Para los valores de las variables indicadas no es posible realizar" +
        " la operación solicitada.");
  } else {
    numMultiplosSinBucle = ((stop + start) ~/ 2) * 11;
  }

  //Con bucle
  print("La suma de los múltiplos de $multiplo entre $start y $stop es" +
      " $sumaDeMultiplosConBucle.");
  //Sin bucle
  print("La suma de los múltiplos de $multiplo entre $start y $stop es" +
      " $numMultiplosSinBucle.");
}
