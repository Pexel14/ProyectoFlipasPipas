package com.dam.db.persistencias;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dam.db.AccesoDB;
import com.dam.db.constants.TablaLeccionesConst;


public class LeccionesPer {

	private AccesoDB acceso;

	public LeccionesPer() {
		this.acceso = new AccesoDB();
	}
	
	public ArrayList<String> datosLeccion(int id_curso) {
		
		ArrayList<String> nomLec = new ArrayList<String>();
		
		String query = "SELECT " + TablaLeccionesConst.NOM_COL_LECCION
						+ " FROM " + TablaLeccionesConst.NOM_TABLA
						+ " WHERE " + TablaLeccionesConst.NOM_COL_ID_CURSO + " = " + id_curso;
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		
		try {
			con = acceso.getConexion();
			stmt = con.createStatement();
			rslt = stmt.executeQuery(query);
			
			while(rslt.next()) {
				nomLec.add(rslt.getString(1));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		return nomLec;
	}
	
	public void leccionTerminada(int nivActual) {
		
		String query = "UPDATE " + TablaLeccionesConst.NOM_TABLA + " SET " + TablaLeccionesConst.NOM_COL_COMPLETADA + " = 1 WHERE "
				+ TablaLeccionesConst.NOM_COL_ID_LECCION + " = ?;";
		
		Connection con = null;
		
		PreparedStatement stmt = null;
		
		ResultSet rslt = null;
		
		try {
			
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setInt(1, nivActual);
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}

}
