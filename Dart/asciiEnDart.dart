import 'dart:io';

void main() {
  //De letra a assci
  String ch = 'R';
  print(' ASCII value of ${ch[0]} is ${ch.codeUnitAt(0)}');

  //De assci a letra
  String s = String.fromCharCode(82);
  print(s);
}
