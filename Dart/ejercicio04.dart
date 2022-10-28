import 'dart:io';

void main() {
  int contadoInverso = 122;
  int contadorMayuscula = 65;
  int contadoInversoMayuscula = 90;

  String abecedario_1 = "",
      abecedario_2 = "",
      abecedario_3 = "",
      abecedario_4 = "",
      abecedario_5 = "";

  for (int i = 97; i <= 122; i++) {
    //abecedario_1 minúsculas
    abecedario_1 += String.fromCharCode(i);
    //abecedario_2 invertido en minúsculas
    abecedario_2 += String.fromCharCode(contadoInverso--);
    //abecedario_3 mayúsculas
    abecedario_3 += String.fromCharCode(contadorMayuscula++);
    //abecedario_4 invertido en mayúsculas
    abecedario_4 += String.fromCharCode(contadoInversoMayuscula--);
    //abecedario_5 mezclado
    if (i % 2 == 0) {
      abecedario_5 += String.fromCharCode(i - 32);
    } else {
      abecedario_5 += String.fromCharCode(i);
    }
  }
  print(abecedario_1);
  print(abecedario_2);
  print(abecedario_3);
  print(abecedario_4);
  print(abecedario_5);
}
