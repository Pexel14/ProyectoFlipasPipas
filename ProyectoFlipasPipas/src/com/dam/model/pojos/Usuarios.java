package com.dam.model.pojos;

public class Usuarios {

	private int idUsuario;
	private String nick;
	private String email;
	private String fotoPerfil;
	private int monedas;
	private String contraseña;
	
	public Usuarios(int id_usuario, String nick, String email, String fotoPerfil,  int monedas, String contraseña) {
		this.idUsuario = id_usuario;
		this.nick = nick;
		this.email = email;
		this.fotoPerfil = fotoPerfil;
		this.monedas = monedas;
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Usuarios [id_usuario=" + idUsuario + ", nick=" + nick + ", fotoPerfil=" + fotoPerfil + ", monedas=" + monedas + ", contraseña="
				+ contraseña + "]";
	}
		
}
