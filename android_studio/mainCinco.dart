import 'package:flutter/material.dart';

void main(){
  const TextStyle estilo_1 = TextStyle(
    color: Colors.orange,
    fontSize: 30,
  );
  runApp(
    Row(
        textDirection: TextDirection.ltr,
        children: const <Widget>[
          Icon(
            Icons.circle,
            color: Colors.blue,
            size: 30,
            textDirection: TextDirection.ltr,

          ),
          Text(
            "Hola",
            style: estilo_1,
            textDirection: TextDirection.ltr,
          ),
          Icon(
            Icons.square,
            color: Colors.white,
            size: 30,
            textDirection: TextDirection.ltr,
          ),
          Text(
            "adios",
            style: estilo_1,
            textDirection: TextDirection.ltr,
          ),
          Icon(
            Icons.circle_outlined,
            color: Colors.orange,
            size: 30,
            textDirection: TextDirection.ltr,
          ),
        ],
    ),
  );
}