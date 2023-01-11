package proyectoJavi;

public class Cuadro extends Obra implements Comerciable{
	// Variables
	private boolean enmarcado;
	private String tematica;
	private int precio = 0;

	//Constructor
	public Cuadro(String nombre, String autor) {
		super(nombre, autor);
	}
	public Cuadro(String nombre,String autor,int fecha,String tematica){
		super(nombre, autor, fecha);
		this.tematica = tematica;
	}

	// toString
	@Override
	public String toString() {
		return "\n----------\nDatos de cuadro: \n----------" 
				+ super.toString() 
				+ "\nRestaurado: "+(estaRestaurado() ? "Si":"No")
				+ "\nTemática: " + getTematica()
				+ "\nEnmarcado: " + isEnmarcado();
	}
	
	// Métodos
	public void enmarcar() {
		this.enmarcado = true;
	}
	public void desEnmarcar() {
		this.enmarcado = false;
	}
	
	// Getters
	public boolean isEnmarcado() {
		return enmarcado;
	}
	public String getTematica() {
		if (this.tematica == null) {
			return "No hay temática definida";
		} else {
			return tematica;
		}
	}
	
	//setter
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	
	@Override
	public void restaurar() {
		setRestaurado(true);
	}
	
	// Metodos de Iterface Comerciable
	@Override
	public int descuento(int porcentaje) {
		int descuento = (porcentaje*GetPrecio())/100;
		int precioFinal = GetPrecio() - descuento;
		return precioFinal;
	}
	@Override
	public int GetPrecio() {
		return this.precio;
	}
	@Override
	public void SetPrecio(int nuevoPrecio) {
		this.precio = nuevoPrecio;
	}
}
