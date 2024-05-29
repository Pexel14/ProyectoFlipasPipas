package com.dam.db.persistencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dam.db.AccesoDB;
import com.dam.db.constants.FlipasPipasConst;
import com.dam.db.constants.TablaUsuNotifConst;

public class UsuNotificacionesPer {
	
	private AccesoDB acceso;
	
	public UsuNotificacionesPer() {
		acceso = new AccesoDB();
	}
	
	public void enviarNotificacion(int usuario) {
		String insert = "INSERT INTO " + TablaUsuNotifConst.NOM_TABLA + " VALUES(?,?)"; 
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(insert);
			
			for (int i = 1; i <= FlipasPipasConst.CANT_NOTIFICACIONES; i++) {
				stmt.setInt(1, i);
				stmt.setInt(2, usuario);
				
				stmt.execute();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
