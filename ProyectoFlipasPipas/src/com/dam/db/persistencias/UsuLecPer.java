package com.dam.db.persistencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dam.db.AccesoDB;
import com.dam.db.constants.FlipasPipasConst;
import com.dam.db.constants.TablaUsuLecConst;

public class UsuLecPer {
	
	private AccesoDB acceso;
	
	public UsuLecPer() {
		acceso = new AccesoDB();
	}
	
	public void insertarLecciones(int id) {
		String insert = "INSERT INTO " + TablaUsuLecConst.NOM_TABLA + " VALUES(?,?,?)";
		
		Connection con = null;
		
		PreparedStatement stmt = null;
		
		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(insert);
			
			for (int j = 1; j <= FlipasPipasConst.CANT_LECCIONES; j++) {
				stmt.setInt(1, j);
				stmt.setInt(2, id);
				
				if(j == 1 || j == 7 || j == 13 || j == 19) {
					stmt.setBoolean(3, true);
				} else {
					stmt.setBoolean(3, false);						
				}
				
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
	
	public ArrayList<Boolean> cargarLecciones(int id){
		//TODO: Que al entrar en los niveles se carguen a los que puede acceder el usuario
		
		String select = "SELECT " + TablaUsuLecConst.COL_COMPLETADA + " FROM " + TablaUsuLecConst.NOM_TABLA + " WHERE " + TablaUsuLecConst.COL_IDUSU + " = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rlst = null;
		ArrayList<Boolean> lecciones = new ArrayList<Boolean>();
		
		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(select);
			stmt.setInt(1, id);
			
			rlst = stmt.executeQuery();
			
			while(rlst.next()) {
				lecciones.add(rlst.getBoolean(1));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				
				if(stmt != null) {
					stmt.close();
				}
				
				if(rlst != null) {
					rlst.close();
				}
				
				if(con != null) {
					con.close();
				}
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return lecciones;
	}
	
	public void leccionTerminada(int nivActual, int id) {
		
		String query = "UPDATE " + TablaUsuLecConst.NOM_TABLA + " SET " + TablaUsuLecConst.COL_COMPLETADA + " = true WHERE "
				+ TablaUsuLecConst.COL_IDLEC + " = ? AND " + TablaUsuLecConst.COL_IDUSU + " = ?";
		
		Connection con = null;
		
		PreparedStatement stmt = null;
		
		ResultSet rslt = null;
		
		try {
			
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setInt(1, nivActual);
			stmt.setInt(2, id);
			
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
	
	public int desbloquearLeccion(int id, int leccion) {
		String update = "UPDATE " + TablaUsuLecConst.NOM_TABLA + " SET " + TablaUsuLecConst.COL_COMPLETADA + " = true " 
	+ " WHERE " + TablaUsuLecConst.COL_IDLEC + " = ? AND " + TablaUsuLecConst.COL_IDUSU + " = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		int res = 0;
		
		try {
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(update);
			
			stmt.setInt(1, leccion);
			stmt.setInt(2, id);
			
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
	
}
