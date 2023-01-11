package pruebaDeProyectoJavi;

import proyectoJavi.*;

public class Test {
 
	public static void main(String[] args) {
		
		// ------------------ Clase Cuadro ----------------------
		System.out.println("------------------ Clase Cuadro ----------------------");
			Cuadro c1 = new Cuadro("La Prueba","Pepito Perez");
			Cuadro c2 = new Cuadro("La Dos","Manolito Pelaez",1946,"Belico");

			System.out.println(c1.toString());
			c2.addColor("Marron");
			c2.addColor("verde");
			c2.restaurar();
			c2.enmarcar();
			System.out.println(c2.toString());	
		
			// ------------------ Clase NFT ----------------------
			System.out.println("------------------ Clase NFT ----------------------");

			NFT n2 = new NFT("La Dos","Manolito Pelaez",
					2022,"/home/alan/eclipse-workspace/Dam/"
							+ "src/proyectoJavi","JavaNFT.png");
					
			n2.addColor("Marron");
			n2.addColor("verde");
			System.out.println(n2.toString());	
			n2.setCertificado("/home/alan/eclipse-workspace/Dam/src/proyectoJavi","Alan Sweere");
			
			n2.SetPrecio(200);
			System.out.println(n2.GetPrecio());
			n2.SetPrecio(n2.descuento(20));
			System.out.println(n2.GetPrecio());
			System.out.println(n2.getFormato());
			// ------------------ Clase Grafitti ----------------------
			System.out.println("------------------ Clase Grafitti ----------------------");

			Graffiti g1 = new Graffiti("La Prueba","Pepito Perez");
			Graffiti g2 = new Graffiti("La Dos","Manolito Pelaez",1946,"Pared Lisa");

			System.out.println(c1.toString());
			g1.setSuperficie("Pared de ladrillo");
			System.out.println(c1.toString());

			g2.addColor("Marron");
			g2.addColor("verde");
			g2.restaurar();
			System.out.println(g2.toString());
	}
}
