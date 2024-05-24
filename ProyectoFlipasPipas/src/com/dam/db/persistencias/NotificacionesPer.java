package com.dam.db.persistencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dam.db.AccesoDB;
import com.dam.db.constants.TablaNotificacionesConst;

public class NotificacionesPer {
	
	AccesoDB acceso;
	
	public NotificacionesPer() {
		this.acceso = new AccesoDB();
	}
	
	public ArrayList<String> selectNotificaciones() {
		
		ArrayList<String> listNotis = new ArrayList<String>();
		
		// TODO query solo las 4 del id del usuario que le pases por paramentro ;
		
	       String query = "SELECT " + TablaNotificacionesConst.NOM_COL_COLUMNA3 + " FROM " + TablaNotificacionesConst.NOM_TABLA + 
	    		   " WHERE " + TablaNotificacionesConst.NOM_COL_COLUMNA2 + " = ? ORDER BY " 
	    		   + TablaNotificacionesConst.NOM_COL_COLUMNA1;
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		
		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setInt(1, 1); // TODO seleciona el id del usario que le digas
			rslt = stmt.executeQuery();
			
			
			while (rslt.next()) {
				listNotis.add(rslt.getString(1));

			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				if (rslt != null) rslt.close();
				if (stmt != null) stmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	 
		
		return listNotis;
		
	}
	
}
