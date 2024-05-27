package com.dam.db.persistencias;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dam.db.AccesoDB;
import com.dam.model.pojos.Preguntas;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.dam.db.constants.TablaUsuPregConst;
import com.dam.db.constants.TablaUsuariosConst;

public class UsuPregPer {
	
	private AccesoDB acceso = new AccesoDB();
	
	private static final String NOM_TABLA = "PREGUNTAS";
	private static final String COL_ID_PREG = "ID_PREGUNTA";
	private static final String COL_ID_LECC = "ID_LECCION";
	private static final String COL_PREG = "PREGUNTA";
	private static final String COL_RESP1 = "RESP1";
	private static final String COL_RESP2 = "RESP2";
	private static final String COL_RESP3 = "RESP3";
	private static final String COL_RESP4 = "RESP4";
	private static final String COL_CORRECTA = "CORRECTA";

	public ArrayList<Preguntas> getPreg(int idLeccion) {
		
		ArrayList <Preguntas>  preguntas = new ArrayList<>();
		Preguntas pregunta = null;
		
		String query = "SELECT DISTINCT * FROM " + NOM_TABLA + " WHERE " + COL_ID_LECC + " = ?;";
		
		Connection con = null;
		
		PreparedStatement stmt = null;
		
		ResultSet rslt = null;
		
		try {
			
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idLeccion);
			
			rslt = stmt.executeQuery();
			
			while (rslt.next()) {
				pregunta = new Preguntas(rslt.getInt(COL_ID_PREG),
						rslt.getInt(COL_ID_LECC),
						rslt.getString(COL_PREG),
						rslt.getString(COL_RESP1),
						rslt.getString(COL_RESP2),
						rslt.getString(COL_RESP3),
						rslt.getString(COL_RESP4),
						rslt.getString(COL_CORRECTA));
				
				preguntas.add(pregunta);
			}
			
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
		
		return preguntas;
	}

	public HashMap<String, Integer> nickPuntUsu() {
		
		HashMap<String, Integer> tup = new HashMap<String, Integer>();
		
		//** P U E D E  C A M B I A R **
		String query = "SELECT U." + TablaUsuariosConst.NOM_COL_NICK
						+ ", UP." + TablaUsuPregConst.NOM_COL_PUNTOS
						+ " FROM " + TablaUsuPregConst.NOM_TABLA + " UP"
						+ " JOIN " + TablaUsuariosConst.NOM_TABLA + " U"
						+ " ON U." + TablaUsuariosConst.NOM_COL_ID + " = UP." + TablaUsuPregConst.NOM_COL_ID_USUARIO;
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		
		try {
			con = acceso.getConexion();
			stmt = con.createStatement();
			rslt = stmt.executeQuery(query);
			
			while(rslt.next()) {
				tup.put(rslt.getString(TablaUsuariosConst.NOM_COL_NICK), rslt.getInt(TablaUsuPregConst.NOM_COL_PUNTOS));
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
		
		return tup;

	}
	
}
