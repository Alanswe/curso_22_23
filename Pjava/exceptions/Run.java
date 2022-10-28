package exceptions;
class MyUncheckedException extends RuntimeException {}
class MyCheckedException extends Exception {}

class MyClass {
    static void m1() throws MyCheckedException {          
            System.out.println("Entrando en m1 de MyClass");
            m2();
            System.out.println("Saliendo de m1 de MyClass");
    }

    static void m2() throws MyCheckedException{
        try{
            System.out.println("Entrando en m2 de MyClass");
            int caso = 5;
            switch(caso) {
                case 0:
                    System.out.println(3/0);
                    break;
                case 1: 
                    (new Integer[2])[1]++;
                    break;
                case 2: 
                    (new int[2])[9]++;
                    break;
                case 3: 
                    throw new RuntimeException();    
                case 4: 
                    throw new MyUncheckedException();  
                case 5: 
                    throw new MyCheckedException();
                default:
            }
            System.out.println("Saliendo de m2 de MyClass");
        } catch (ArithmeticException e) {
            System.out.println("No sabes contar");
            System.out.println(e.getClass().getName());
        } catch (NullPointerException e) {
            System.out.println("La nada no es para nada");
            System.out.println(e.getClass().getName());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Te has salido de madre");
            System.out.println(e.getClass().getName());
        } catch (MyUncheckedException e) {
            System.out.println("Aquí presumiendo de conocimento");
            System.out.println(e.getClass().getName());
        } catch (MyCheckedException e) {
            System.out.println("Aquí presumiendo de conocimento más");
            System.out.println(e.getClass().getName());
        } finally {
            System.out.println("Y finalmente aquí está finally");
        }
            }
}

public class Run {
	public static void main(String[] args) throws MyCheckedException {
		System.out.println("Entrando en main de Run");
		MyClass.m1();
		System.out.println("Saliendo de main de Run");
	}
}