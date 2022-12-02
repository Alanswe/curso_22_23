import 'package:flutter/material.dart';

void main() {
  // estilos
  const TextStyle estilo_1 = TextStyle(
    fontWeight: FontWeight.bold,
    color: Colors.blue,
    fontSize: 35,
  );
  const TextStyle estilo_2 = TextStyle(
    fontStyle: FontStyle.italic,
    color: Colors.orange,
    fontSize: 20,
  );

  // hijo
  const List<TextSpan> hijito = [
    TextSpan(
      text: " is simply dummy text of the printing and "
          "typesetting industry. Lorem Ipsum has been the industry's standard "
          "dummy text ever since the 1500s, when an unknown printer took a"
          " galley of type and scrambled it to make a type specimen book. "
          "It has survived not only five centuries, but also the leap into "
          "electronic typesetting, remaining essentially unchanged. It was"
          " popularised in the 1960s with the release of Letraset sheets "
          "containing Lorem Ipsum passages, and more recently with desktop"
          " publishing software like Aldus PageMaker including versions "
          "of Lorem Ipsum.",
      style: estilo_2,
    ),
  ];

  runApp(const Text.rich(
    TextSpan(
      text: "Lorem Ipsum",
      style: estilo_1,
      children: hijito,
    ),
    textDirection: TextDirection.ltr,
  ));
}
