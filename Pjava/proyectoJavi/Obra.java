package proyectoJavi;

import java.util.ArrayList;

public abstract class Obra {
	// Variables
	private String nombre;
	private String autor;
	private int fecha;
	protected boolean restaurado;
	private ArrayList<String> colores = new ArrayList<String>();
	
	//Constructores
	Obra(String nombre,String autor,int fecha){
		this.nombre = nombre;
		this.autor = autor;
		this.fecha = fecha;
	}
	
	Obra(String nombre,String autor){
		this(nombre, autor,0);
	}
	
	//getters
	public String getNombre() {
		return nombre;
	}
	public String getAutor() {
		return autor;
	}
	public int getFecha() {
		return fecha;
	}
	public boolean estaRestaurado() {
		return restaurado;
	}
	public ArrayList<String> getColores() {
		return this.colores;
	}

	//setters
	public abstract void restaurar();
	
	public void addColor(String color) {
		this.colores.add(color);
	}
	public void setRestaurado(boolean restaurado) {
		this.restaurado = restaurado;
	}
	//toString
	@Override
	public String toString() {
		return "\nNombre: "+getNombre()
		+ "\nAutor: "+getAutor()
		+ "\nFecha: "+((getFecha()==0) ? "Desconocida":getFecha())
		+ "\nColores Usados: "+(getColores().isEmpty() 
				? "No hay colores definidos": getColores());
	}
}
