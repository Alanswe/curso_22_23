import 'package:flutter/material.dart';

void main() => runApp(const IntroScreen());

class IntroScreen extends StatelessWidget {
  const IntroScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      title: 'Material App',
      home: Scaffold(
        body: Center(
          child: IntroScreen(),
        ),
      ),
    );
  }
}