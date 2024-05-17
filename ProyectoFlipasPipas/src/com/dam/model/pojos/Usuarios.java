package com.dam.model.pojos;

public class Usuarios {

	private int idUsuario;
    private String nick;
    private String email;
    private String fotoPerfil;
    private int monedas;
    private String contrasenia;

    public Usuarios(int id_usuario, String nick, String email, String fotoPerfil,  int monedas, String contrasenia) {
        this.idUsuario = id_usuario;
        this.nick = nick;
        this.email = email;
        this.fotoPerfil = fotoPerfil;
        this.monedas = monedas;
        this.contrasenia = contrasenia;
    }

	@Override
	public String toString() {
		return "Usuarios [id_usuario=" + idUsuario + ", nick=" + nick + ", email=" + email + ", fotoPerfil=" + fotoPerfil + ", monedas=" + monedas + ", contraseña="
				+ contrasenia + "]";
	}

	public int getIdUsuario() {
		return idUsuario;
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
		
}
