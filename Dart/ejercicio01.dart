void main() {
 
  int start = 1, stop = 50, step = 2;
  int multiplos = 0;
  
  for(int i = start; i < stop; i++) {
    if (start >= stop || start < 0 || step < 0){
      print("Para los valores de las variables indicadas no es posible realizar la operación solicitada.");
      break;
    } else {
        if (i%step == 0) {
          multiplos++; 
          //print(i);
        }
    }
  }
  
  
  // sin bucle
  int numeroMultiplos = 0;
  if (start >= stop || start < 0 || step < 0){
      print("Para los valores de las variables indicadas no es posible realizar la operación solicitada.");
  } else {
      numeroMultiplos = (stop - start) ~/step;  
      }

  print("1) Entre $start y $stop hay $multiplos múltiplos de $step");
  print("2) Entre $start y $stop hay $numeroMultiplos múltiplos de $step");
  
}