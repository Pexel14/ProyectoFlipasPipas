package com.dam.model.pojos;

public class Preguntas {
	
	private int idPregunta;
	private int idLeccion;
	private String pregunta;
	private String resp1;
	private String resp2;
	private String resp3;
	private String resp4;
	private String correcta;
	
	public Preguntas(int idPregunta, int idLeccion, String pregunta, String resp1, String resp2, String resp3,
			String resp4, String correcta) {
		this.idPregunta = idPregunta;
		this.idLeccion = idLeccion;
		this.pregunta = pregunta;
		this.resp1 = resp1;
		this.resp2 = resp2;
		this.resp3 = resp3;
		this.resp4 = resp4;
		this.correcta = correcta;
	}

	@Override
	public String toString() {
		return "Preguntas [idPregunta=" + idPregunta + ", idLeccion=" + idLeccion + ", pregunta=" + pregunta
				+ ", resp1=" + resp1 + ", resp2=" + resp2 + ", resp3=" + resp3 + ", resp4=" + resp4 + ", correcta="
				+ correcta + "]";
	}
	
}
