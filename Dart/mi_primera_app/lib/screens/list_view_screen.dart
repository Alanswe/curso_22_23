import 'package:flutter/material.dart';

class listView1 extends StatelessWidget {

  final elements = const [
    'Opción 1: AAA','Opción 2: BBB','Opción 3: CCC',
  ];

  const listView1({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.orange,
        centerTitle: true,
        title: const Text(
            'List view 1',
          style: TextStyle(
            fontSize: 25,
          ),
        ),
    ),
      body: ListView(
        children: elements.map( // se crea un bucle Stream que hace a (e) cada elemento
              (e) => ListTile(
                leading: const Icon(Icons.arrow_circle_right_outlined,color: Colors.orange),
                trailing: const Icon(Icons.arrow_forward_ios_outlined,color: Colors.blue),
                title: Text(
                  e,
                  style: const TextStyle(
                    fontSize: 20,
                  ),
                ),
            ),
        ).toList()
      ),
    );
  }
}
