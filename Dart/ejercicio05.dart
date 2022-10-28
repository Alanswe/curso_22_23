import 'dart:math';

void main() {
  """Crea, una lista que contenga un conjunto de 10 números aleatorios entre
   el 0 y el 100, donde los número impares estén cambiados de signo.""";
  var numeroRandom = new Random();
  int num = 0;

  List<int> lista = [];
  for (int i = 0; i <= 10; i++) {
    if ((num = numeroRandom.nextInt(100)) % 2 == 0) {
      lista.add(num);
    } else {
      lista.add(-num);
    }
  }
  print(lista);
}
