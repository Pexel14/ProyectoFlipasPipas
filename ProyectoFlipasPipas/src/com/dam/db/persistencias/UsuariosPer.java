package com.dam.db.persistencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dam.db.AccesoDB;
import com.dam.model.pojos.Usuarios;

import com.dam.db.constants.TablaUsuariosConst;

public class UsuariosPer {
	
	private static final String NOM_TABLA = "USUARIOS";
	private static final String COL_ID = "ID_USUARIO";
	private static final String COL_NICK = "NICK";
	private static final String COL_EMAIL = "EMAIL";
	private static final String COL_FOTO = "FOTO_PERFIL";
	private static final String COL_MONEDAS = "MONEDAS";
	private static final String COL_CONTRASENIA = "CONTRASENIA";
	
	private AccesoDB accesoBD;
	
	private static int id_usuario;
	private static String nick;
	

	public UsuariosPer() {
		accesoBD = new AccesoDB();
	}

	public boolean existeUsuario(String correo) {
		
		boolean existe = false;
		
		String query = "SELECT " + COL_ID + ", " + COL_NICK + " FROM " + NOM_TABLA + " WHERE " + COL_EMAIL + " = ?;";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		
		try {
			
			con = accesoBD.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setString(1, correo);
			
			rslt = stmt.executeQuery();
			
			if(rslt.next()) {
				existe = true;
				id_usuario = rslt.getInt(1);
				nick = rslt.getString(2);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rslt != null) rslt.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
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
				if(stmt != null) stmt.close();
				
				if(con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void borrarcuenta() { 
		String deletStm = "DELETE FROM " + NOM_TABLA + " WHERE " + COL_ID
				+ " = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
	
		try {
			con = accesoBD.getConexion();
			pstmt = con.prepareStatement(deletStm);
			pstmt.setInt(1, id_usuario);
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		}
		
	}


	public void cargarDatosUsuario() {
		String query = "SELECT " + TablaUsuariosConst.NOM_COL_NICK 
				+ ", " + TablaUsuariosConst.NOM_COL_EMAIL 
				+ ", " + TablaUsuariosConst.NOM_COL_MONEDAS 
				+ " FROM " + TablaUsuariosConst.NOM_TABLA 
				+ " WHERE " + TablaUsuariosConst.NOM_COL_ID + " = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rlst = null;
		
		try {
			con = accesoBD.getConexion();
			
			stmt = con.prepareStatement(query);
			
//			stmt.setString(1, id);
			
			rlst = stmt.executeQuery();
			
//			if(rlst.next()) {
//				vu.getLblNomUsuario().setText(rlst.getString(1));
//				vu.getLblEmailUsuario().setText(rlst.getString(2));
//				vu.getLblRacha().setText("1" + vu.getLblPipaCoins().getText());
//				vu.getLblPipaCoins().setText(rlst.getString(3) + vu.getLblPipaCoins().getText());
//			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rlst != null) {
					rlst.close();
				}
				
				if(stmt != null) {
					stmt.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	
	public void getID(String email) {
		String select = "SELECT " + COL_ID + " FROM " + NOM_TABLA + " WHERE " + COL_EMAIL + " = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rlst = null;
		
		try {
			con = accesoBD.getConexion();
			
			stmt = con.prepareStatement(select);
			
			stmt.setString(1, email);
			
			rlst = stmt.executeQuery();
			
			if(rlst.next()) {
				id_usuario = rlst.getInt(1);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rlst != null) {
					rlst.close();
				}
				
				if(stmt != null) {
					stmt.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
	}
	

	public int customizarPerfil(String img) {
		String update = "UPDATE " + TablaUsuariosConst.NOM_TABLA 
				+ " SET " + TablaUsuariosConst.NOM_COL_FOTOPERFIL + " = ?, " 
				+ TablaUsuariosConst.NOM_COL_NICK + " = ? "
				+ " WHERE " + TablaUsuariosConst.NOM_COL_ID + " = ?";
//		if(!nombre.equals(vcu.getTxtNombre().getText()){
//			nombre = vcu.getTxtNombre().getText();
//		}
		
		Connection con = null;
		PreparedStatement stmt = null;
		int res = 0;
		
		try {
			con = accesoBD.getConexion();
			
			stmt = con.prepareStatement(update);
			
			stmt.setString(1, img);
//			stmt.setString(2, nombre);
//			stmt.setString(3, id);
			
			res = stmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return res;
	}
	
	public int comprobarSaldo() {
		String query = "SELECT " + TablaUsuariosConst.NOM_COL_MONEDAS + " FROM " + TablaUsuariosConst.NOM_TABLA + " WHERE " + TablaUsuariosConst.NOM_COL_ID + " = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rlst = null;
		
		int saldo = 0;
		
		try {
			con = accesoBD.getConexion();
			
			stmt = con.prepareStatement(query);
			
			stmt.setInt(1, id_usuario);
			
			rlst = stmt.executeQuery();
			
			if(rlst.next()) {
				saldo = rlst.getInt(1);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rlst != null) {
					rlst.close();
				}
				
				if(stmt != null) {
					stmt.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return saldo;
	}
	
	public int compradoObjeto(int saldo) {
		String update = "UPDATE " + TablaUsuariosConst.NOM_TABLA + " SET " + TablaUsuariosConst.NOM_COL_MONEDAS + " = ? WHERE " + TablaUsuariosConst.NOM_COL_ID + " = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		int res = 0;
		
		if(saldo >= 0) {
			try {
				con = accesoBD.getConexion();
				
				stmt = con.prepareStatement(update);
				
				stmt.setInt(1, saldo);
				stmt.setInt(2, id_usuario);
				
				res = stmt.executeUpdate();
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(stmt != null) {
						stmt.close();
					}
					
					if(con != null) {
						con.close();
					}
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		}
		
		
		return res;
	}
	
	public int getId_usuario() {
		return id_usuario;
	}
	
}
