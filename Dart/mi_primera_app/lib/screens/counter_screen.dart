import 'package:flutter/material.dart';

class CounterScreen extends StatefulWidget {
  const CounterScreen({Key? key}) : super(key: key);

  @override
  State<CounterScreen> createState() => _CounterScreenState();
}

class _CounterScreenState extends State<CounterScreen> {
// Variables
  int counter = 0;
//Metodos
  void increase(){
    counter++;
    setState(() {});
  }
  void decrease(){
    if (counter>=1){
      counter--;
    } else {
      counter=0;
    }
    setState(() {});
  }
  void reset(){
    counter = 0;
    setState(() {});
  }
//Pantalla
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          backgroundColor: Colors.orange,
          centerTitle: true,
          title: const Text('Material App Bar'),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              const Text(
                'Número de clicks',
                style: TextStyle(
                  fontSize: 35,
                ),
              ),
              Text(
                '$counter',
                style: const TextStyle(
                  fontSize: 35,
                ),
              ),
            ],
          ),
        ),
        floatingActionButtonLocation: FloatingActionButtonLocation.centerFloat,
        floatingActionButton: MisBotones(
          increaseFn: increase, decreaseFn: decrease, resetFn: reset,
        ),
    );
  }
}

class MisBotones extends StatelessWidget {
  final Function increaseFn;
  final Function decreaseFn;
  final Function resetFn;

  const MisBotones({Key? key,
      required this.increaseFn,
      required this.decreaseFn,
      required this.resetFn}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
      children: <Widget>[
        FloatingActionButton(
          backgroundColor: Colors.orange,
          child: const Icon(Icons.exposure_plus_1_outlined),
          onPressed: () => increaseFn(),
        ),
        FloatingActionButton(
          backgroundColor: Colors.orange,
          child: const Icon(Icons.exposure_minus_1_outlined),
          onPressed: () => decreaseFn(),
        ),
        FloatingActionButton(
          backgroundColor: Colors.orange,
          child: const Icon(Icons.settings_backup_restore_outlined),
          onPressed: () => resetFn(),
        )
      ],
    );
  }
}
