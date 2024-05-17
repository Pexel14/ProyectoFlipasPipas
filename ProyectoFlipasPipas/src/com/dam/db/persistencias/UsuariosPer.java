package com.dam.db.persistencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dam.db.AccesoDB;
import com.dam.db.constants.TablaUsuariosConst;
import com.dam.view.VCustomizacion;
import com.dam.view.VInicioSesion;
import com.dam.view.VUsuario;

public class UsuariosPer {
	
	private AccesoDB acceso;
	private VUsuario vu;
	private VInicioSesion vi;
	private VCustomizacion vcu;
	private int id;
	public UsuariosPer() {
		acceso = new AccesoDB();
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
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			
//			stmt.setString(1, id);
			
			rlst = stmt.executeQuery();
			
			if(rlst.next()) {
				vu.getLblNomUsuario().setText(rlst.getString(1));
				vu.getLblEmailUsuario().setText(rlst.getString(2));
				vu.getLblRacha().setText("1" + vu.getLblPipaCoins().getText());
				vu.getLblPipaCoins().setText(rlst.getString(3) + vu.getLblPipaCoins().getText());
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
	
	public void setVentana(VUsuario vu) {
		this.vu = vu;
	}
	
	public int getId() {
		return id;
	}
	
	public void setVentana(VCustomizacion vcu) {
		this.vcu = vcu;
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
			con = acceso.getConexion();
			
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
}
