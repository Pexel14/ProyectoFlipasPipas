package com.dam.db.persistencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dam.db.AccesoDB;
import com.dam.model.pojos.Preguntas;

public class UsuPregPer {
	
	private AccesoDB acceso = new AccesoDB();
	
	private static final String NOM_TABLA = "PREGUNTAS";
	private static final String COL_ID_PREG = "ID_PREGUNTA";
	private static final String COL_ID_LECC = "ID_LECCION";
	private static final String COL_PREG = "PREGUNTA";
	private static final String COL_RESP1 = "RESP1";
	private static final String COL_RESP2 = "RESP2";
	private static final String COL_RESP3 = "RESP3";
	private static final String COL_RESP4 = "RESP4";
	private static final String COL_CORRECTA = "CORRECTA";

	public ArrayList<Preguntas> getPreg(int idLeccion) {
		
		ArrayList <Preguntas>  preguntas = new ArrayList<>();
		Preguntas pregunta = null;
		
		String query = "SELECT DISTINCT * FROM " + NOM_TABLA + " WHERE " + COL_ID_LECC + " = ?;";
		
		Connection con = null;
		
		PreparedStatement stmt = null;
		
		ResultSet rslt = null;
		
		try {
			
			con = acceso.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idLeccion);
			
			rslt = stmt.executeQuery();
			
			while (rslt.next()) {
				pregunta = new Preguntas(rslt.getInt(COL_ID_PREG),
						rslt.getInt(COL_ID_LECC),
						rslt.getString(COL_PREG),
						rslt.getString(COL_RESP1),
						rslt.getString(COL_RESP2),
						rslt.getString(COL_RESP3),
						rslt.getString(COL_RESP4),
						rslt.getString(COL_CORRECTA));
				
				preguntas.add(pregunta);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return preguntas;
		
	}

}
