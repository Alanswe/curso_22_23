void main() {
  """Copia el siguiente texto en un String y realiza las siguientes operaciones:

  1. Cuenta las palabras utilizando el tamaño de una List en la que metas 
  todas las palabras.
  2. Cuenta todas las palabras únicas utilizando el tamaño de un Set en el que 
  metas todas las palabras.
  3. Crea un Map donde la llave sea la palabra y el valor el número de veces 
  que se repite. Genera adicionalmente 2 Map más que estén ordenados por el 
  valor uno en ascendente y otro en descendente.""";

  String texto =
      """Una niña recibe de su madre el encargo de llevar una cesta a su abuela
       enferma que vive en el bosque, advirtiéndole que no hable con 
       desconocidos. Pero por el camino se encuentra un lobo y se para a hablar
        con él, dándole detalles de lo que va a hacer. El lobo aprovecha para 
        engañar a caperucita y llegar antes a casa de la abuelita, a quien se 
        come, y luego ocupa su lugar para engañar a caperucita y comérsela 
        también. Afortunadamente, un leñador que andaba por allí descubre al 
        lobo durmiendo tras su comida, y rescata a caperucita y su abuelita 
        de la tripa del lobo, sustituyéndolas por piedras que hacen que el 
        lobo se ahoge al ir a beber al río.""";

  List<String> palabras = texto.split(' ');

  //1
  int numPalabras = palabras.length;
  print("1) El texto tiene $numPalabras palabras.");

  //2
  Set palabrasUnicas = Set.from(palabras);
  int numPalabrasUnicas = palabrasUnicas.length;
  print("2) El texto tiene $numPalabrasUnicas palabras únicas.");

  //3
  Map<String, dynamic> palabrasMap = {};
  //Hace un solo recorido al texto y actualiza el resultado
  for (var palabra in palabras) {
    if (palabrasMap.containsKey("$palabra")) {
      palabrasMap.addAll({palabra: (++palabrasMap["$palabra"])});
    } else {
      palabrasMap.addAll({palabra: 1});
    }
  }
  print("3) Map de repeticiones de letras: $palabrasMap");
}
