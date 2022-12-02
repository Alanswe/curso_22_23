import 'package:flutter/material.dart';

void main(){
  const TextStyle estilo_1 = TextStyle(
    color: Colors.white,
    fontSize: 25,
  );

  runApp(
    Container(
      margin: const EdgeInsets.symmetric(vertical: 150.0,horizontal: 50.0),
      color: Colors.orange,
      alignment: Alignment.center,
      child: Column(
        textDirection: TextDirection.ltr,
        children: <Widget>[
          Container(
            padding: const EdgeInsets.all(10.0),
            child: const Image(
              image: NetworkImage('https://images.unsplash.com/photo-1512641406448'
                  '-6574e777bec6?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdl'
                  'fHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80'),
              alignment: Alignment.center,
            ),
          ),

          Container(
            margin: const EdgeInsets.symmetric(vertical: 15.0,horizontal: 15.0),
            padding: const EdgeInsets.all(5.0),
            color: Colors.blue,
            child: const Text(
              "Hola",
              style: estilo_1,
              textDirection: TextDirection.ltr,
              ),
          ),
        ],

      ),

    ),

  );













}