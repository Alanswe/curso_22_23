package proyectoJavi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NFT extends Obra implements Digital,Comerciable{
	// variable
	private int peso;
	private String urlArchivo;
	private boolean vCertificado;
	private String urlCertificado;
	private String nombreNFT;
	private int precio = 0;
	
	// Constructor
	public NFT(String nombre, String autor, int fecha, String urlArchivo, String nombreNFT) {
		super(nombre, autor, fecha);
		this.urlArchivo = urlArchivo;
		this.nombreNFT = nombreNFT;
	}

	// Metodos
	public void setCertificado(String urlCertificado, String duenio) {
		if (validarNFT()) {
			try(FileWriter fw = new FileWriter(geturlArchivo()+"/CertificadoNFT.txt");){
				fw.append("------------------------- Datos -------------------------");
				fw.append(super.toString()
					+ "\nPeso: " + getPeso() + " bytes"
					+ "\nFormato: " + getFormato());
				fw.append("\n------------------------- Dueñ@ de NFT -------------------------");
				fw.append("\nDueñ@: " + duenio);
				System.out.println("-------------------\nCertificado creado con exito\n-------"
						+ "------------");
			} catch (IOException e) {
				System.out.println("-------------------\nProblemas creando el archivo\n--------"
						+ "-----------");
			}
		} else {
			System.out.println("-------------------\nProblemas creando el archivo: No se encontó un archivo "
					+ "valido para crear certificado\n-------------------");
		}
		this.urlCertificado = urlCertificado;
	}
	public String getNombreNFT() {
		return nombreNFT;
	}
	public String geturlArchivo() {
		return urlArchivo;
	}
	public long getPeso() {
		File archivo = new File(geturlArchivo() + "/" + getNombreNFT());
		long peso = archivo.length();
		return peso;
	}

	// toString
	@Override
	public String toString() {
		if (validarNFT()) {
			return "\n----------\nDatos de NFT: \n----------" 
					+ super.toString() 
					+ "\nPeso: " + getPeso() + " bytes"
					+ "\nCertificado: " + (validarCertificado()==true? "Si":"No")
					+ "\n--------------------------------------";
		} else {
			return "-------------------\n¡Archivo valido no encontrado!\n-------------------";
		}
	}

	// Metodo abstracto heredado
	@Override
	public void restaurar() {
		System.out.println("No se puede restaurar, un NFT es inmutable");
	}
	
	// Metodos de Iterface Digital
	@Override
	public boolean validarCertificado() {
		File archivo = new File(geturlArchivo() + "/" + getNombreNFT());
		boolean vCertificado = (archivo.exists() ? true : false);
		return vCertificado;
	}
	@Override
	public boolean validarNFT() {
		boolean nftValidado;
		File archivo = new File(geturlArchivo() + "/" + getNombreNFT());
		boolean isArchivo = (archivo.exists() ? true : false);
		if (isArchivo && getPeso() < 31457280 /*30Mb*/) {
			nftValidado = true;
		} else { 
			nftValidado = false ;
		}
		return nftValidado;
	}
	@Override
	public String getFormato() {
		String resultado;
		if (validarNFT()) {
			String[] nombreYExtension = this.nombreNFT.split("\\.");
			resultado = nombreYExtension[1];
		}else {
			resultado = "Ocurrió un error en el archivo";
		}
		return resultado;

	}
	// Metodos de Iterface Comerciable
	@Override
	public int descuento(int porcentaje) {
		int precioFinal = 0;
		if (validarNFT()) {
			int descuento = (porcentaje*GetPrecio())/100;
			precioFinal = GetPrecio() - descuento;
		} else {	
			System.out.println("No se encuentra archivo valido");
		}
		return precioFinal;
	}
	@Override
	public int GetPrecio() {
		int resultado = 0;
		if (validarNFT()) {
			resultado = this.precio;
		} else {
			System.out.println("No se encuentra archivo valido");
		}
		return resultado;
	}
	@Override
	public void SetPrecio(int nuevoPrecio) {
		if (validarNFT()) { 
			this.precio = nuevoPrecio;
		} else {
			System.out.println("No se encuentra archivo valido al que poner precio");
		}
	}
}
