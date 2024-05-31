package com.dam.model.pojos;

public class Usuarios {

	private int idUsuario;
    private String nick;
    private String email;
    private String fotoPerfil;
    private int monedas;
    private String contrasenia;
    private int puntos;

    public Usuarios(int id_usuario, String nick, String email, String fotoPerfil,  int monedas, String contrasenia, int puntos) {
        this.idUsuario = id_usuario;
        this.nick = nick;
        this.email = email;
        this.fotoPerfil = fotoPerfil;
        this.monedas = monedas;
        this.contrasenia = contrasenia;
        this.puntos = puntos;
    }

	public String getNick() {
		return nick;
	}

	public String getEmail() {
		return email;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public int getMonedas() {
		return monedas;
	}

	public String getContrasenia() {
		return contrasenia;
	}
	
	public int getPuntos() {
		return puntos;
	}
		
}
