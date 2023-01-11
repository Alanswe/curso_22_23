package proyectoJavi;

public class Graffiti extends Obra{
	//Variables
	private String superficieDePintado;	
	
	//Constructores
	public Graffiti(String nombre, String autor) {
		super(nombre, autor);
	}
	public Graffiti(String nombre, String autor, int fecha, String superficieDePintado) {
		super(nombre, autor, fecha);
		this.superficieDePintado = superficieDePintado;
	}

	// getter y setter
	public String getSuperficie() {
		String superficie = superficieDePintado == null ?
				"Superficie desconocida": superficieDePintado;
		return superficie;
	}
	public void setSuperficie(String superficieDePintado) {
		this.superficieDePintado = superficieDePintado;
	}

	// toString
	@Override
	public String toString() {
		return "\n----------\nDatos de Graffiti: \n----------" 
				+ super.toString() 
				+ "\nRestaurado: "+(estaRestaurado() ? "Si":"No")
				+ "\nSuperficie de pintado: " + getSuperficie();
	}
	
	// Metodo abstracto heredado
	@Override
	public void restaurar() {
		setRestaurado(true);
	}
}
