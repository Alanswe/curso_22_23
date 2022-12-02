import 'package:flutter/material.dart';

void main(){
  const TextStyle estilo_1 = TextStyle(
    color: Colors.red,
    fontSize: 25,
  );
  runApp(
      Container(
        margin: const EdgeInsets.symmetric(vertical: 200.0,horizontal: 50.0),
        color: Colors.white,
        alignment: Alignment.center,
        child: const Text(
          textAlign: TextAlign.center,
          "Hola Mundo!",
          style: estilo_1,
          textDirection: TextDirection.ltr,
        ),
      ),
  );

}