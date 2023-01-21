import 'package:flutter/material.dart';
import 'package:mi_primera_app/screens/counter_screen.dart';
import 'package:mi_primera_app/screens/intro_screen.dart';
import 'package:mi_primera_app/screens/list_view_2_screen.dart';
import 'package:mi_primera_app/screens/list_view_screen.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Material App',
      home: listView2(),
          //CounterScreen(),
          // IntroScreen(),
      routes: {
        'counter_screen'  : (context) => const CounterScreen(),
        'list_View_1_screen'  : (context) => const listView1(),
        'list_View_2_screen'  : (context) => const listView2(),
        'intro_screen'  : (context) => const IntroScreen(),
      },
    );
  }
}