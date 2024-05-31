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


	public String getPregunta() {
		return pregunta;
	}

	public String getResp1() {
		return resp1;
	}

	public String getResp2() {
		return resp2;
	}

	public String getResp3() {
		return resp3;
	}

	public String getResp4() {
		return resp4;
	}

	public String getCorrecta() {
		return correcta;
	}
	
}
