package com.dam.db.persistencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.dam.db.AccesoDB;
import com.dam.model.pojos.Usuarios;


import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.dam.view.PnlRanking;
import com.dam.db.constants.TablaUsuPregConst;

import com.dam.db.constants.TablaUsuariosConst;

public class UsuariosPer {
	
	private static final String NOM_TABLA = "USUARIOS";
	private static final String COL_ID = "ID_USUARIO";
	private static final String COL_NICK = "NICK";
	private static final String COL_EMAIL = "EMAIL";
	private static final String COL_FOTO = "FOTO_PERFIL";
	private static final String COL_MONEDAS = "MONEDAS";
	private static final String COL_CONTRASENIA = "CONTRASENIA";
	
	private AccesoDB accesoBD;
	
	private static int id_usuario;
	private static String fotoPerfil;
	private static String nick;
	

	public UsuariosPer() {
		accesoBD = new AccesoDB();
	}

	public boolean existeUsuario(String correo) {
		
		boolean existe = false;
		
		String query = "SELECT " + COL_ID + ", " + COL_NICK + ", " + COL_FOTO + " FROM " + NOM_TABLA + " WHERE " + COL_EMAIL + " = ?;";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		
		try {
			
			con = accesoBD.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setString(1, correo);
			
			rslt = stmt.executeQuery();
			
			if(rslt.next()) {
				existe = true;
				id_usuario = rslt.getInt(1);
				nick = rslt.getString(2);
				fotoPerfil = rslt.getString(3);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rslt != null) rslt.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return existe;
	}
	
	
	
	
	
	public boolean contraCorrecta(String correo, String passw) {
		
		boolean coincide = false;
		
		String query = "SELECT " + COL_CONTRASENIA + " FROM " + NOM_TABLA + " WHERE " + COL_EMAIL + " = ?;";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;
		
		try {
			
			con = accesoBD.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setString(1, correo);
			
			rslt = stmt.executeQuery();
			
			if (rslt.next()) {
				if (rslt.getString(1).equals(passw)) {
					coincide = true;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rslt.close();
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return coincide;
	}

	public boolean correoRepetido(String correo) {
		
		boolean repetido = false;
		
		String query = "SELECT " + COL_EMAIL + " FROM " + NOM_TABLA + " WHERE " + COL_EMAIL + " = ?;";
		
		Connection con = null;
		
		PreparedStatement stmt = null;
		
		ResultSet rslt = null;
		
		try {
			con = accesoBD.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setString(1, correo);
			
			rslt = stmt.executeQuery();
			
			repetido = rslt.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rslt.close();
				stmt.close();
				rslt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return repetido;
	}

	public boolean nombreRepetido(String nombre) {
		
		boolean repetido = false;
		
		String query = "SELECT " + COL_NICK + " FROM " + NOM_TABLA + " WHERE " + COL_NICK + " = ?;";
		
		Connection con = null;
		
		PreparedStatement stmt = null;
		
		ResultSet rslt = null;
		
		try {
			con = accesoBD.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setString(1, nombre);
			
			rslt = stmt.executeQuery();
			
			repetido = rslt.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rslt.close();
				stmt.close();
				rslt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return repetido;
	}
	
	public void registrarUsuario(Usuarios usuario) {

		String query = "INSERT INTO " + NOM_TABLA + " ("
		+ COL_NICK + ", " + COL_EMAIL + ", " + COL_FOTO + ", " + COL_MONEDAS + ", " + COL_CONTRASENIA
		+ ") VALUES (?, ?, ?, ?, ?);";
		
		Connection con = null;
		
		PreparedStatement stmt = null;
		
		try {

			con = accesoBD.getConexion();
			
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, usuario.getNick());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getFotoPerfil());
			stmt.setInt(4, usuario.getMonedas());
			stmt.setString(5, usuario.getContrasenia());
			
			stmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(stmt != null) stmt.close();
				
				if(con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void borrarcuenta() { 
		String deletStm = "DELETE FROM " + NOM_TABLA + " WHERE " + COL_ID
				+ " = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
	
		try {
			con = accesoBD.getConexion();
			pstmt = con.prepareStatement(deletStm);
			pstmt.setInt(1, id_usuario);
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		}
		
	}


	public Usuarios cargarDatosUsuario() {
		String query = "SELECT " + TablaUsuariosConst.NOM_COL_NICK 
				+ ", " + TablaUsuariosConst.NOM_COL_EMAIL 
				+ ", " + TablaUsuariosConst.NOM_COL_MONEDAS 
				+ " FROM " + TablaUsuariosConst.NOM_TABLA 
				+ " WHERE " + TablaUsuariosConst.NOM_COL_ID + " = ?";
		
		Usuarios usuario = null;
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rlst = null;
		
		try {
			con = accesoBD.getConexion();
			
			stmt = con.prepareStatement(query);
			
			stmt.setInt(1, id_usuario);
			
			rlst = stmt.executeQuery();
			
			if(rlst.next()) {
				usuario = new Usuarios(0, rlst.getString(1), rlst.getString(2), "", rlst.getInt(3), "");
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
		return usuario;
	}
	
	
	public void getID(String email) {
		String select = "SELECT " + COL_ID + " FROM " + NOM_TABLA + " WHERE " + COL_EMAIL + " = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rlst = null;
		
		try {
			con = accesoBD.getConexion();
			
			stmt = con.prepareStatement(select);
			
			stmt.setString(1, email);
			
			rlst = stmt.executeQuery();
			
			if(rlst.next()) {
				id_usuario = rlst.getInt(1);
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
		
	}
	

	public int customizarPerfil(String img, String nombre) {
 		String update = "UPDATE " + TablaUsuariosConst.NOM_TABLA 
				+ " SET " + TablaUsuariosConst.NOM_COL_FOTOPERFIL + " = ?, " 
				+ TablaUsuariosConst.NOM_COL_NICK + " = ? "
				+ " WHERE " + TablaUsuariosConst.NOM_COL_ID + " = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		int res = 0;
		
		try {
			con = accesoBD.getConexion();
			
			stmt = con.prepareStatement(update);
			
			stmt.setString(1, img);
			stmt.setString(2, nombre);
			stmt.setInt(3, id_usuario);
			
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
	
	public int comprobarSaldo() {
		String query = "SELECT " + TablaUsuariosConst.NOM_COL_MONEDAS + " FROM " + TablaUsuariosConst.NOM_TABLA + " WHERE " + TablaUsuariosConst.NOM_COL_ID + " = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rlst = null;
		
		int saldo = 0;
		
		try {
			con = accesoBD.getConexion();
			
			stmt = con.prepareStatement(query);
			
			stmt.setInt(1, id_usuario);
			
			rlst = stmt.executeQuery();
			
			if(rlst.next()) {
				saldo = rlst.getInt(1);
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
		return saldo;
	}
	
	public int compradoObjeto(int saldo) {
		String update = "UPDATE " + TablaUsuariosConst.NOM_TABLA + " SET " + TablaUsuariosConst.NOM_COL_MONEDAS + " = ? WHERE " + TablaUsuariosConst.NOM_COL_ID + " = ?";
		
		Connection con = null;
		PreparedStatement stmt = null;
		int res = 0;
		
		if(saldo >= 0) {
			try {
				con = accesoBD.getConexion();
				
				stmt = con.prepareStatement(update);
				
				stmt.setInt(1, saldo);
				stmt.setInt(2, id_usuario);
				
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
		}
		
		
		return res;
	}
	
	public int getId_usuario() {
		return id_usuario;
	}
	
	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public ArrayList<String> imgUsu() {
		
		ArrayList<String> imgs = new ArrayList<String>();
	
		String query = "SELECT " + TablaUsuariosConst.NOM_COL_FOTOPERFIL
				+ " FROM " + TablaUsuariosConst.NOM_TABLA
				//+ " FETCH NEXT " + PnlRanking.CANT_USU_RNKG + " ROWS"G
				+ " ORDER BY " + TablaUsuariosConst.NOM_COL_PUNTOS + " DESC"
				+ " LIMIT " + PnlRanking.CANT_USU_RNKG;
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		
		try {
			con = accesoBD.getConexion();
			stmt = con.createStatement();
			rslt = stmt.executeQuery(query);
			
			while(rslt.next()) {
				imgs.add(rslt.getString(1));
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
			return imgs;
		}
	
	public HashMap<String, Integer> nickPuntUsu() {
        HashMap<String, Integer> tup = new HashMap<String, Integer>();

        String query = "SELECT " + TablaUsuariosConst.NOM_COL_NICK
                        + ", " + TablaUsuariosConst.NOM_COL_PUNTOS
                        + " FROM " + TablaUsuariosConst.NOM_TABLA;
        Connection con = null;
        Statement stmt = null;
        ResultSet rslt = null;

        try {
            con = accesoBD.getConexion();
            stmt = con.createStatement();
            rslt = stmt.executeQuery(query);

            while(rslt.next()) {
                tup.put(rslt.getString(1), rslt.getInt(2));
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

        return tup;
    }
	
}
