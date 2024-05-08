package com.dam.model.pojos;

public class Cursos {
	
	private int idCurso;
	private String nombre;
	
	public Cursos(int id_curso, String nombre) {
		this.idCurso = id_curso;
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Cursos [id_curso=" + idCurso + ", nombre=" + nombre + "]";
	}
	
}
