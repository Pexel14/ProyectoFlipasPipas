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
import com.dam.db.constants.FlipasPipasConst;

import com.dam.db.constants.TablaUsuariosConst;

public class UsuariosPer {
	private AccesoDB accesoBD;
	
	private static int id_usuario;
	private static String fotoPerfil;
	private static String nick;
	

	public UsuariosPer() {
		accesoBD = new AccesoDB();
	}

	public boolean existeUsuario(String correo) {
		
		boolean existe = false;
		
		String query = "SELECT " + TablaUsuariosConst.COL_ID + ", " 
					+ TablaUsuariosConst.COL_NICK + ", " + TablaUsuariosConst.COL_FOTO 
					+ " FROM " + TablaUsuariosConst.NOM_TABLA + " WHERE " + TablaUsuariosConst.COL_EMAIL + " = ?;";
		
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
				if(rslt != null) {
					rslt.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return existe;
	}
	
	
	public boolean contraCorrecta(String correo, String passw) {
		
		boolean coincide = false;
		
		String query = "SELECT " + TablaUsuariosConst.COL_CONTRASENIA 
				+ " FROM " + TablaUsuariosConst.NOM_TABLA + " WHERE " + TablaUsuariosConst.COL_EMAIL + " = ?;";
		
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
				if(stmt != null) {
					stmt.close();
				}
				
				if(rslt != null) {
					rslt.close();
				}
				
				if(con != null) {
					con.close();
				}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return coincide;
	}

	public boolean correoRepetido(String correo) {
		
		boolean repetido = false;
		
		String query = "SELECT " + TablaUsuariosConst.COL_EMAIL 
				+ " FROM " + TablaUsuariosConst.NOM_TABLA + " WHERE " + TablaUsuariosConst.COL_EMAIL + " = ?;";
		
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
				
				if(stmt != null) {
					stmt.close();
				}
				
				if(rslt != null) {
					rslt.close();
				}
				
				if(con != null) {
					con.close();
				}
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return repetido;
	}
	
	public void registrarUsuario(Usuarios usuario) {

		String query = "INSERT INTO " + TablaUsuariosConst.NOM_TABLA + " ("
		+ TablaUsuariosConst.COL_NICK + ", " + TablaUsuariosConst.COL_EMAIL 
		+ ", " + TablaUsuariosConst.COL_FOTO + ", " + TablaUsuariosConst.COL_MONEDAS 
		+ ", " + TablaUsuariosConst.COL_CONTRASENIA + ", " + TablaUsuariosConst.COL_PUNTOS
		+ ") VALUES (?, ?, ?, ?, ?, ?);";
		
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
			stmt.setInt(6, usuario.getPuntos());
			
			stmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(stmt != null) {
					stmt.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void borrarcuenta() { 
		String deletStm = "DELETE FROM " + TablaUsuariosConst.NOM_TABLA + " WHERE " + TablaUsuariosConst.COL_ID
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
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		}
		
	}


	public Usuarios cargarDatosUsuario() {
		String query = "SELECT " + TablaUsuariosConst.COL_NICK 
				+ ", " + TablaUsuariosConst.COL_EMAIL 
				+ ", " + TablaUsuariosConst.COL_MONEDAS 
				+ ", " + TablaUsuariosConst.COL_PUNTOS 
				+ " FROM " + TablaUsuariosConst.NOM_TABLA 
				+ " WHERE " + TablaUsuariosConst.COL_ID + " = ?";
		
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
				usuario = new Usuarios(0, rlst.getString(1), rlst.getString(2), "", rlst.getInt(3), "", rlst.getInt(4));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
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
	
	
	public void getUser(String email) {
		String select = "SELECT " + TablaUsuariosConst.COL_ID + ", " + TablaUsuariosConst.COL_NICK 
				+ " FROM " + TablaUsuariosConst.NOM_TABLA + " WHERE " + TablaUsuariosConst.COL_EMAIL + " = ?";
		
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
				nick = rlst.getString(2);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
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
				+ " SET " + TablaUsuariosConst.COL_FOTO + " = ?, " 
				+ TablaUsuariosConst.COL_NICK + " = ? "
				+ " WHERE " + TablaUsuariosConst.COL_ID + " = ?";
		
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
		String query = "SELECT " + TablaUsuariosConst.COL_MONEDAS + " FROM " + TablaUsuariosConst.NOM_TABLA + " WHERE " + TablaUsuariosConst.COL_ID + " = ?";
		
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
		String update = "UPDATE " + TablaUsuariosConst.NOM_TABLA + " SET " + TablaUsuariosConst.COL_MONEDAS 
				+ " = ? WHERE " + TablaUsuariosConst.COL_ID + " = ?";
		
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
	
	public String getNick() {
		return nick;
	}

	public ArrayList<String> imgUsu() {
		
		ArrayList<String> imgs = new ArrayList<String>();

		
		String query = "SELECT " + TablaUsuariosConst.COL_FOTO
				+ " FROM " + TablaUsuariosConst.NOM_TABLA
	               + " ORDER BY " + TablaUsuariosConst.COL_PUNTOS + " DESC"
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

        String query = "SELECT " + TablaUsuariosConst.COL_NICK
                        + ", " + TablaUsuariosConst.COL_PUNTOS
                        + " FROM " + TablaUsuariosConst.NOM_TABLA
     	               + " ORDER BY " + TablaUsuariosConst.COL_PUNTOS + " DESC"
    	               + " LIMIT " + PnlRanking.CANT_USU_RNKG;
        
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

	public void aniadirPipas(String correoUsuActual, int pipas) {
		
		String query = "UPDATE " + TablaUsuariosConst.NOM_TABLA +
				" SET " + TablaUsuariosConst.COL_MONEDAS + " = (" + TablaUsuariosConst.COL_MONEDAS + "+?)"
				+ "WHERE " + TablaUsuariosConst.COL_EMAIL + " = ?";
		
		Connection con = null;
		
		PreparedStatement stmt = null;
		
		try {
			
			con = accesoBD.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setInt(1, pipas);
			stmt.setString(2, correoUsuActual);
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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

	public void aniadirPuntos(String correoUsuActual, int puntos) {

		String query = "UPDATE " + TablaUsuariosConst.NOM_TABLA +
				" SET " + TablaUsuariosConst.COL_PUNTOS + " = (" + TablaUsuariosConst.COL_PUNTOS + "+?)"
				+ "WHERE " + TablaUsuariosConst.COL_EMAIL + " = ?";
		
		Connection con = null;
		
		PreparedStatement stmt = null;
		
		try {
			
			con = accesoBD.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setInt(1, puntos);
			stmt.setString(2, correoUsuActual);
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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
	
	public void puntosABots(int puntosBot1, int puntosBot2, int puntosBot3) {
	    Connection con = null;
	    PreparedStatement stmt = null;
	    
	    try {
	        con = accesoBD.getConexion();
	        
	        // Bot 1
	        String query = "UPDATE " + TablaUsuariosConst.NOM_TABLA +
	                        " SET " + TablaUsuariosConst.COL_PUNTOS + " = ? " +
	                        "WHERE " + TablaUsuariosConst.COL_ID + " = " + FlipasPipasConst.ID_BOT1;
	        stmt = con.prepareStatement(query);
	        stmt.setInt(1, puntosBot1);
	        stmt.executeUpdate();
	        
	        // Bot 2
	        query = "UPDATE " + TablaUsuariosConst.NOM_TABLA +
	                        " SET " + TablaUsuariosConst.COL_PUNTOS + " = ? " +
	                        "WHERE " + TablaUsuariosConst.COL_ID + " = " + FlipasPipasConst.ID_BOT2;
	        stmt = con.prepareStatement(query);
	        stmt.setInt(1, puntosBot2);
	        stmt.executeUpdate();
	        
	        // Bot 3
	        query = "UPDATE " + TablaUsuariosConst.NOM_TABLA +
	                        " SET " + TablaUsuariosConst.COL_PUNTOS + " = ? " +
	                        "WHERE " + TablaUsuariosConst.COL_ID + " = " + FlipasPipasConst.ID_BOT3;
	        stmt = con.prepareStatement(query);
	        stmt.setInt(1, puntosBot3);
	        stmt.executeUpdate();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
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

	public int getPipasUsuario(String correoUsuActual) {
		int pnts = 0;
		
		String query = "SELECT " + TablaUsuariosConst.COL_PUNTOS + " FROM " + TablaUsuariosConst.NOM_TABLA
				+ " WHERE " + TablaUsuariosConst.COL_EMAIL + " = ?";
		
		Connection con = null;
		
		PreparedStatement stmt = null;
		
		ResultSet rslt = null;
		
		try {
			con = accesoBD.getConexion();
			
			stmt = con.prepareStatement(query);
			stmt.setString(1, correoUsuActual);
			
			rslt = stmt.executeQuery();
			if (rslt.next()) {
				pnts = rslt.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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
		
		return pnts;
	}

	public int[] getPntsBots() {
		int[] pnts = new int[3];
		
		String query = "SELECT " + TablaUsuariosConst.COL_PUNTOS + " FROM " + TablaUsuariosConst.NOM_TABLA
				+ " WHERE " + TablaUsuariosConst.COL_ID + " IN (" + FlipasPipasConst.ID_BOT1 + "," + FlipasPipasConst.ID_BOT2 + "," + FlipasPipasConst.ID_BOT3 + ")";
		
		Connection con = null;
		
		Statement stmt = null;
		
		ResultSet rslt = null;
		
		int i = 0;
		
		try {
            con = accesoBD.getConexion();
            stmt = con.createStatement();
            rslt = stmt.executeQuery(query);

            while(rslt.next()) {
            	pnts[i] = rslt.getInt(1);
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
		
		return pnts;
	}


}
