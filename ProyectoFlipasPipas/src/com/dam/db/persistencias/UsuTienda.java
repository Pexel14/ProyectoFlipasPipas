package com.dam.db.persistencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public int comprarObjeto(Tienda id) {
		String update = "UPDATE " + TablaUsuarioTiendaConst.NOM_TABLA + " SET " + TablaUsuarioTiendaConst.COL_COMPRADA + " = true " + " WHERE " + TablaUsuarioTiendaConst.COL_ID_OBJ + " = ?";
		int res = 0;
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(update);
			stmt.setInt(1, id.getId_objeto());
			
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
	
	
	public Tienda comprobarObjeto(String objeto) {
		String query = "SELECT T.*, UT.* FROM " + TablaTiendaConst.NOM_TABLA + " T JOIN " 
				+ TablaUsuarioTiendaConst.NOM_TABLA + " UT ON UT." + TablaUsuarioTiendaConst.COL_ID_OBJ + " = T." 
				+ TablaTiendaConst.NOM_COL_ID + " WHERE " + TablaTiendaConst.NOM_COL_OBJETO + " = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rlst = null;
		Tienda id = null;
		
		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setString(1, objeto);
			
			rlst = stmt.executeQuery();
			
			if(rlst.next()) {
				id = new Tienda(rlst.getInt(1), rlst.getString(2), rlst.getInt(3), rlst.getString(4), rlst.getBoolean(7));
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
	
	public void crearTienda(int id_usuario) {
		//Insertar los 6 objetos de la tienda 
		String insert = "INSERT INTO " + TablaUsuarioTiendaConst.NOM_TABLA + " VALUES (?,?,?)";
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(insert);
			
			
			for (int i = 1; i <= 6; i++) {
				stmt.setInt(1, i);
				stmt.setInt(2, id_usuario);
				stmt.setBoolean(3, false);
				
				stmt.executeUpdate();
			}
			
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
		
	}
	
}
