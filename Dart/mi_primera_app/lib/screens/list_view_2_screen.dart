import 'package:flutter/material.dart';

class listView2 extends StatelessWidget {

  final elements = const [
    'Opción 1: AAA','Opción 2: BBB','Opción 3: CCC',
  ];
  final urls = const [
    'counter_screen',
    'list_View_1_screen',
    //'intro_screen', // necesita qutarse el run app
    'list_View_2_screen',
  ];

  const listView2({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.orange,
        centerTitle: true,
        title: const Text(
          'List view 2',
          style: TextStyle(
            fontSize: 25,
          ),
        ),
      ),
      body: ListView.separated(
          itemBuilder: (context, index) => ListTile(
            onTap: () => Navigator.pushNamed(context, urls[index]),
            leading: const Icon(Icons.arrow_circle_right_outlined,
                color: Colors.orange),
            trailing: const Icon(Icons.arrow_forward_ios_outlined,
                color: Colors.blue),
            title: Text(
              elements[index],
              style: const TextStyle(
                fontSize: 20,
              ),
            ),
          ),

          separatorBuilder: (_, __)/*_ y __  es para decir que no vas a utilizar
          dichos datos o argumentos*/ => const Divider(),
          itemCount: elements.length,
      )
    );
  }
}
