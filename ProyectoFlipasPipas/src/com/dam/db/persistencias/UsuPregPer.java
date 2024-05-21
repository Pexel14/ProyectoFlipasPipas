package com.dam.db.persistencias;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.dam.db.AccesoDB;
import com.dam.db.constants.TablaUsuPregConst;
import com.dam.db.constants.TablaUsuariosConst;

public class UsuPregPer {
	
	private AccesoDB acceso;

	public UsuPregPer() {
		this.acceso = new AccesoDB();
	}

	public HashMap<String, Integer> nickPuntUsu() {
		
		HashMap<String, Integer> tup = new HashMap<String, Integer>();
		
		//** P U E D E  C A M B I A R **
		String query = "SELECT U." + TablaUsuariosConst.NOM_COL_NICK
						+ ", UP." + TablaUsuPregConst.NOM_COL_PUNTOS
						+ " FROM " + TablaUsuPregConst.NOM_TABLA + " UP"
						+ " JOIN " + TablaUsuariosConst.NOM_TABLA + " U"
						+ " ON U." + TablaUsuariosConst.NOM_COL_ID_USUARIO + " = UP." + TablaUsuPregConst.NOM_COL_ID_USUARIO;
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
