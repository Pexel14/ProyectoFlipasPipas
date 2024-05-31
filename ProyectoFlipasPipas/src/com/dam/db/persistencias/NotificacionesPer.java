package com.dam.db.persistencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dam.db.AccesoDB;
import com.dam.db.constants.TablaNotificacionesConst;
import com.dam.db.constants.TablaUsuNotifConst;

public class NotificacionesPer {
	
	AccesoDB acceso;
	
	public NotificacionesPer() {
		this.acceso = new AccesoDB();
	}
	
	public String selectNotificaciones(int notificacion, int usuario) {
		
		String notif = "";		
		
		String query = "SELECT N." + TablaNotificacionesConst.COL_NOTIF 
				+ " FROM " + TablaNotificacionesConst.NOM_TABLA + " N JOIN " 
				+ TablaUsuNotifConst.NOM_TABLA + " UN ON UN." + TablaUsuNotifConst.COL_IDNOTIF + " = N." + TablaNotificacionesConst.COL_IDNOTIF 
				+ " WHERE UN." + TablaUsuNotifConst.COL_IDUSU + " = ? AND N." + TablaNotificacionesConst.COL_IDNOTIF + " = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		
		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			
			stmt.setInt(1, usuario);
			stmt.setInt(2, notificacion);
			
			rslt = stmt.executeQuery();
			
			
			if(rslt.next()) {
				notif = rslt.getString(1);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			
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
		
		return notif;
		
	}
	
}
