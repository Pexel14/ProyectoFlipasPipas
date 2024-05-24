package com.dam.db.persistencias;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dam.db.AccesoDB;
import com.dam.db.constants.TablaTiendaConst;
import com.dam.db.constants.TablaUsuarioTiendaConst;
import com.dam.model.pojos.Tienda;

public class UsuTienda {
	private AccesoDB acceso;
	
	public UsuTienda() {
		acceso = new AccesoDB();
	}
	
	public ArrayList<Tienda> cargarBotones() {
		ArrayList<Tienda> listaTienda = new ArrayList<Tienda>(); 
		
		String query = "SELECT T.*, UT.* FROM " + TablaTiendaConst.NOM_TABLA 
				+ " T JOIN " + TablaUsuarioTiendaConst.NOM_TABLA + " UT ON UT." + TablaUsuarioTiendaConst.COL_ID_OBJ + " = T." + TablaTiendaConst.NOM_COL_ID;
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rlst = null;
		
		try {
			con = acceso.getConexion();
			
			stmt = con.createStatement();
			
			rlst = stmt.executeQuery(query);
			
			while(rlst.next()) {
				listaTienda.add(new Tienda(rlst.getInt(1), rlst.getString(2), rlst.getInt(3), rlst.getString(4), rlst.getBoolean(7)));
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
		return listaTienda;
		
	}

//	public void crearTienda(int id_usuario) {
//		
//		String insert = "";
//		
//		Connection con = null;
//		
//	
//		
//		
//	}
	
}
