package com.dam.model.pojos;

public class Tienda {

	private int id_objeto;
	private String objeto;
	private int precio;
	private String imagen;
	private boolean comprada;
	
	public Tienda(int id_objeto, String objeto, int precio, String imagen, boolean comprada) {
		this.id_objeto = id_objeto;
		this.objeto = objeto;
		this.precio = precio;
		this.imagen = imagen;
		this.comprada = comprada;
	}

	public int getId_objeto() {
		return id_objeto;
	}

	public int getPrecio() {
		return precio;
	}

	public String getImagen() {
		return imagen;
	}

	public boolean isComprada() {
		return comprada;
	}
	
	
	
}
