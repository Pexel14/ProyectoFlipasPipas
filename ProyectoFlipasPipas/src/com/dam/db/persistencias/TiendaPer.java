package com.dam.db.persistencias;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dam.db.AccesoDB;
import com.dam.db.constants.TablaTiendaConst;
import com.dam.model.pojos.Tienda;
import com.dam.view.PnlTienda;

public class TiendaPer {
	private AccesoDB acceso;
	private PnlTienda tienda;
	
	private String nombre;
	private int precio;
	
	
	public TiendaPer(){
		acceso = new AccesoDB();
	}

	public ArrayList<Tienda> cargarBotones() {
		ArrayList<Tienda> listaTienda = new ArrayList<Tienda>(); 
		
		String query = "SELECT * FROM " + TablaTiendaConst.NOM_TABLA;
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rlst = null;
		
		try {
			con = acceso.getConexion();
			
			stmt = con.createStatement();
			
			rlst = stmt.executeQuery(query);
			
			while(rlst.next()) {
				listaTienda.add(new Tienda(rlst.getInt(1), rlst.getString(2), rlst.getInt(3), rlst.getString(4), rlst.getBoolean(5)));
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
	
	public int comprobarObjeto(String objeto) {
		String query = "SELECT " + TablaTiendaConst.NOM_COL_ID + " FROM " + TablaTiendaConst.NOM_TABLA + " WHERE " + TablaTiendaConst.NOM_COL_OBJETO + " = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rlst = null;
		int id = 0;
		
		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setString(1, objeto);
			
			rlst = stmt.executeQuery();
			
			if(rlst.next()) {
				id = rlst.getInt(2);
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
		
		return id;
	}
	
	public int comprarObjeto(int id) {
		String update = "UPDATE " + TablaTiendaConst.NOM_TABLA + " SET " + TablaTiendaConst.NOM_COL_COMPRADA + " = true " + " WHERE " + TablaTiendaConst.NOM_COL_ID + " = ?";
		int res = 0;
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(update);
			stmt.setInt(1, id);
			
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
	
	public void setVentana(PnlTienda tienda) {
		this.tienda = tienda;
	}
}
