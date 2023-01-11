import 'package:flutter/material.dart';

void main() {

runApp(
    Container(
      margin: const EdgeInsets.symmetric(vertical: 125.0,horizontal: 50.0),
      decoration: BoxDecoration(
        border: Border.all(
            color: Colors.blue,
            width: 3.0,
            style: BorderStyle.solid
        ),
        borderRadius: BorderRadius.circular(5),
        color: Colors.black,
      ),

    child: Container(
      margin: const EdgeInsets.symmetric(vertical: 7.0,horizontal: 7.0),
      color: Colors.black,
      alignment: Alignment.center,

      child: Column(
        textDirection: TextDirection.ltr,
        children: <Widget>[

          Container(
            margin: const EdgeInsets.fromLTRB(10,30,10,5),
            child: const Text(
              "Título",
              textScaleFactor: 2,
              textDirection: TextDirection.ltr,
              style: TextStyle(fontWeight: FontWeight.bold),
            ),
          ),

          Row(
            textDirection: TextDirection.ltr,
            mainAxisAlignment: MainAxisAlignment.center,
            children: const [
              FlutterLogo(size: 25,),
              FlutterLogo(size: 25,),
            ],
          ),

          Container(
            padding: const EdgeInsets.all(15.0),
            child: const Image(
              image: NetworkImage('https://images.unsplash.com/photo-1512641406448'
                  '-6574e777bec6?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdl'
                  'fHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80'),
              alignment: Alignment.center,
            ),
          ),

          Row(
            textDirection: TextDirection.ltr,
            mainAxisAlignment: MainAxisAlignment.center,
            children: const [
              FlutterLogo(size: 25,),
              FlutterLogo(size: 25,),
            ],
          ),

          Container(
            margin: const EdgeInsets.fromLTRB(5,10,5,5),
            child: const Text(
              "Este es un texto debajo del doble logo de Flutter, y está debajo del todo",
              textDirection: TextDirection.ltr,
              textAlign: TextAlign.center,
              textScaleFactor: 1.15,
            ),

          ),
        ],
      ),
    ),
  ),
);
}