package com.dam.db.persistencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dam.db.AccesoDB;
import com.dam.db.constants.TablaUsuariosConst;

public class UsuariosPer {
	
	AccesoDB acceso;
	static int id;

	public UsuariosPer() {
		acceso = new AccesoDB();
	}
	
	public void borrarcuenta() {	//TODO Aun no se pueden iniciar las pruebas 
		String deletStm = "DELETE FROM " + TablaUsuariosConst.NOM_TABLA + " WHERE " + TablaUsuariosConst.NOM_COL_COLUMNA1
				+ " = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
	
		try {
			con = acceso.getConexion();
			pstmt = con.prepareStatement(deletStm);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
