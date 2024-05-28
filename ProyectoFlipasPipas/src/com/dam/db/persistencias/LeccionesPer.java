package com.dam.db.persistencias;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dam.db.AccesoDB;
import com.dam.db.constants.FlipasPipasConst;
import com.dam.db.constants.TablaLeccionesConst;
import com.dam.db.constants.TablaTemarioConst;


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

	public ArrayList<String> getDef(int lenguaje) { // TODO
		ArrayList<String> deflist = new ArrayList<String>();
		
		String query = "SELECT " + TablaTemarioConst.NOM_COL_COLUMNA3 + " FROM "  + TablaTemarioConst.NOM_TABLA;  
		
		if (lenguaje == (FlipasPipasConst.ID_CURSO_JAVA)) {
			query += " WHERE " + TablaTemarioConst.NOM_COL_COLUMNA4 + " = "  + FlipasPipasConst.ID_CURSO_JAVA;
		} else if (lenguaje == FlipasPipasConst.ID_CURSO_SQL) {
			query += " WHERE " + TablaTemarioConst.NOM_COL_COLUMNA4 + " = "  + FlipasPipasConst.ID_CURSO_SQL;
		} else if (lenguaje == FlipasPipasConst.ID_CURSO_HTML) {
			query += " WHERE " + TablaTemarioConst.NOM_COL_COLUMNA4 + " = "  + FlipasPipasConst.ID_CURSO_HTML;
		} else {
			query += " WHERE " + TablaTemarioConst.NOM_COL_COLUMNA4 + " = "  + FlipasPipasConst.ID_CURSO_CSS;
		}
		
		
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		
		try {
			con = acceso.getConexion();
			stmt = con.createStatement();
			rslt = stmt.executeQuery(query);
			
			while(rslt.next()) {
				deflist.add(rslt.getString(1));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("No se encontraron los datos en la base verifique 'db/BaseDatos.db'");
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
		
		
		return deflist;
		
	}

	public ArrayList<Boolean> nvlCompletados(int id_curso) {
        ArrayList<Boolean> booleans = new ArrayList<Boolean>();

        String query = "SELECT " + TablaLeccionesConst.NOM_COL_COMPLETADA
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
                booleans.add(rslt.getBoolean(1));
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

        return booleans;
    }
}
