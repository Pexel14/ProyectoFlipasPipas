package com.dam.model;

public class Lecciones {
	
	private int idLeccion;
	private int idCurso;
	private String leccion;
	private boolean lecCompletada;
	
	public Lecciones(int idLeccion, int idCurso, String leccion, boolean lecCompletada) {
		this.idLeccion = idLeccion;
		this.idCurso = idCurso;
		this.leccion = leccion;
		this.lecCompletada = lecCompletada;
	}
	
	@Override
	public String toString() {
		return "Lecciones [idLeccion=" + idLeccion + ", idCurso=" + idCurso + ", leccion=" + leccion
				+ ", lecCompletada=" + lecCompletada + "]";
	}
	
}
