package com.dam.db.persistencias;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dam.db.AccesoDB;
import com.dam.model.pojos.Usuarios;

public class UsuariosPer {
	
	private static final String NOM_TABLA = "USUARIOS";
	private static final String COL_ID = "ID_USUARIO";
	private static final String COL_NICK = "NICK";
	private static final String COL_EMAIL = "EMAIL";
	private static final String COL_FOTO = "FOTO_PERFIL";
	private static final String COL_MONEDAS = "MONEDAS";
	private static final String COL_CONTRASENIA = "CONTRASENIA";
	
	private AccesoDB accesoBD;
	
	public UsuariosPer() {
		accesoBD = new AccesoDB();
	}

	public boolean existeUsuario(String correo) {
		
		boolean existe = false;
		
		String query = "SELECT " + COL_NICK + " FROM " + NOM_TABLA + " WHERE " + COL_EMAIL + " = ?;";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		
		try {
			
			con = accesoBD.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setString(1, correo);
			
			rslt = stmt.executeQuery();
			
			existe = rslt.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rslt.close();
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return existe;
	}
	
	public boolean contraCorrecta(String correo, String passw) {
		
		boolean coincide = false;
		
		String query = "SELECT " + COL_CONTRASENIA + " FROM " + NOM_TABLA + " WHERE " + COL_EMAIL + " = ?;";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		
		try {
			
			con = accesoBD.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setString(1, correo);
			
			rslt = stmt.executeQuery();
			
			if (rslt.next()) {
				if (rslt.getString(1).equals(passw)) {
					coincide = true;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rslt.close();
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return coincide;
	}

	public boolean correoRepetido(String correo) {
		
		boolean repetido = false;
		
		String query = "SELECT " + COL_EMAIL + " FROM " + NOM_TABLA + " WHERE " + COL_EMAIL + " = ?;";
		
		Connection con = null;
		
		PreparedStatement stmt = null;
		
		ResultSet rslt = null;
		
		try {
			con = accesoBD.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setString(1, correo);
			
			rslt = stmt.executeQuery();
			
			repetido = rslt.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rslt.close();
				stmt.close();
				rslt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return repetido;
	}

	public boolean nombreRepetido(String nombre) {
		
		boolean repetido = false;
		
		String query = "SELECT " + COL_NICK + " FROM " + NOM_TABLA + " WHERE " + COL_NICK + " = ?;";
		
		Connection con = null;
		
		PreparedStatement stmt = null;
		
		ResultSet rslt = null;
		
		try {
			con = accesoBD.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setString(1, nombre);
			
			rslt = stmt.executeQuery();
			
			repetido = rslt.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rslt.close();
				stmt.close();
				rslt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return repetido;
	}
	
	public void registrarUsuario(Usuarios usuario) {

		String query = "INSERT INTO " + NOM_TABLA + " ("
		+ COL_NICK + ", " + COL_EMAIL + ", " + COL_FOTO + ", " + COL_MONEDAS + ", " + COL_CONTRASENIA
		+ ") VALUES (?, ?, ?, ?, ?);";
		
		Connection con = null;
		
		PreparedStatement stmt = null;
		
		try {

			con = accesoBD.getConexion();
			
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, usuario.getNick());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getFotoPerfil());
			stmt.setInt(4, usuario.getMonedas());
			stmt.setString(5, usuario.getContrasenia());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				stmt.close();
				
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
