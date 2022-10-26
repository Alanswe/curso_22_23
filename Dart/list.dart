void main() {
  String listaEntera = "";
  List<String> listaDePrueba = [
    "Mi ",
    "casa ",
    "y ",
    "mi ",
    "coche ",
    "son ",
    "verdes ",
    "y ",
    "azules."
  ];

  for (int i = 0; i < listaDePrueba.length; i++) {
    listaEntera += "${listaDePrueba[i]}";
  }

  print(listaEntera);

  for (var palabras in listaDePrueba) {
    print(palabras);
  }

  // Añadir un elemento
  listaDePrueba.add("value");
  print(listaDePrueba);
}
