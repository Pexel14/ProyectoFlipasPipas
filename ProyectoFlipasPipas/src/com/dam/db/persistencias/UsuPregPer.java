package com.dam.db.persistencias;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dam.db.AccesoDB;
import com.dam.model.pojos.Preguntas;

import java.sql.SQLException;
import com.dam.db.constants.TablaPreguntasConst;

public class UsuPregPer {
	
	private AccesoDB acceso;
	
	public UsuPregPer() {
		acceso = new AccesoDB();
	}

	public ArrayList<Preguntas> getPreg(int idLeccion) {
		
		ArrayList <Preguntas>  preguntas = new ArrayList<>();
		Preguntas pregunta = null;
		
		String query = "SELECT DISTINCT * FROM " + TablaPreguntasConst.NOM_TABLA + " WHERE " + TablaPreguntasConst.COL_ID_LECC + " = ?;";
		
		Connection con = null;
		
		PreparedStatement stmt = null;
		
		ResultSet rslt = null;
		
		try {
			
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idLeccion);
			
			rslt = stmt.executeQuery();
			
			while (rslt.next()) {
				pregunta = new Preguntas(rslt.getInt(TablaPreguntasConst.COL_ID_PREG),
						rslt.getInt(TablaPreguntasConst.COL_ID_LECC),
						rslt.getString(TablaPreguntasConst.COL_PREG),
						rslt.getString(TablaPreguntasConst.COL_RESP1),
						rslt.getString(TablaPreguntasConst.COL_RESP2),
						rslt.getString(TablaPreguntasConst.COL_RESP3),
						rslt.getString(TablaPreguntasConst.COL_RESP4),
						rslt.getString(TablaPreguntasConst.COL_CORRECTA));
				
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
	
}
