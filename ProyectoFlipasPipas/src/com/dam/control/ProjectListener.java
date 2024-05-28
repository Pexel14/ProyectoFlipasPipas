package com.dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.dam.db.persistencias.UsuPregPer;
import com.dam.db.persistencias.UsuTienda;
import com.dam.db.persistencias.UsuariosPer;
import com.dam.model.pojos.Preguntas;
import com.dam.model.pojos.Usuarios;


import com.dam.db.persistencias.NotificacionesPer;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import com.dam.db.constants.FlipasPipasConst;
import com.dam.db.persistencias.LeccionesPer;
import com.dam.db.persistencias.UsuLecPer;

import com.dam.model.pojos.Tienda;

import com.dam.view.*;


public class ProjectListener implements ActionListener {
	
	private static final double PIPAS_MAX_BOT = 1.5;
	private static final double PIPAS_MIN_BOT = 0.5;
	private static final int CANT_PIPAS_LECCION = 200;
	private static final int CANT_PIPAS_PENALIZACION = 20;
	//CLASES REGISTRO/INICIO
	private VRegistro vr;
	private VInicioSesion vi;
	
	//CLASES MENU
	private VMenu vm;
	private String img;
	private PnlTienda pti;
	private PnlRanking pr;
	private PnlTemario pte;
	private PnlCursos pc;
	private VAjustes va;
	private VNotis vn;
	private VUsuario vu;
	private VCustomizacion vcu;
	
	//CLASES GENERALES
	private Vdefiniciones vd;
	
	//CLASES NIVELES
	private PnlLeciones pl;
	private VPreguntas vp;

	// CLASES PERSISTENCIAS
	private UsuariosPer up;
	private UsuPregPer upp;
	private LeccionesPer lp;
	private UsuTienda ut;
	private NotificacionesPer pn;
	private UsuLecPer ulp;
	
	// CLASES POJOS
	private Usuarios usuario;
	
	// EN QUÉ VENTANA Y NIVEL ESTÁ EL USUARIO
	private int lenguaje;
	private int nivActual;
	
	// CORREO DE USUARIO
	private String correoUsuActual;
	
	// PREGUNTAS
	private int pregPos;
	private ArrayList<Preguntas> preguntas;
	
	// FALLOS Y PUNTOS
	private int cantFallos = 0;
	private int pipas = 0;
	private int puntos = 0;
	
//	public ProjectListener() {
//		
//	}
	
	public ProjectListener(VInicioSesion vi) {
		this.vi = vi;


		pn = new NotificacionesPer();

		upp = new UsuPregPer();
		lp = new LeccionesPer();

		up = new UsuariosPer();
		
		ut = new UsuTienda();
		
		ulp = new UsuLecPer();
	}

	
	public void actionPerformed(ActionEvent e) {
		
//		String s = e.getActionCommand();
//		
//		switch (s) {
//		case VInicioSesion.ACT_COM_BTN_INICIO_SESION:
//			vr.dispose();
//			vm.cargarPanel(pc);
//			vm.hacerVisible();
//			break;
//
//		default:
//			break;
//		}
		
		
		// BOTONES
		if (e.getSource() instanceof JButton) {
			
			//BOTONES INICIO/REGISTRO
			// Regístrate (REGISTRO)
			if (e.getSource().equals(vr.getBtnRegistrar())) {
				
				String nombre = vr.getTxtNombre();
				String correo = vr.getTxtCorreo();
				String passw = vr.getTxtContrasenia();
				String confPasswd = vr.getTxtConfirmarContrasenia();
				
				if (nombre.isBlank() || nombre.equals("Nombre")) {
					JOptionPane.showMessageDialog(vr, "Introduce un nombre", "Error de datos", JOptionPane.ERROR_MESSAGE);
				} else if (correo.isBlank()) {
					JOptionPane.showMessageDialog(vr, "Introduce un correo", "Error de datos", JOptionPane.ERROR_MESSAGE);
				} else if (!correo.contains("@")) {
					JOptionPane.showMessageDialog(vr, "El correo debe contener un arroba (@)", "Error de datos", JOptionPane.ERROR_MESSAGE);
				} else if (up.correoRepetido(correo)) {
					JOptionPane.showMessageDialog(vr, "El correo introducido ya existe", "Error de datos", JOptionPane.ERROR_MESSAGE);
				} else if (passw.isBlank()) {
					JOptionPane.showMessageDialog(vr, "Introduzca una contraseña", "Error de datos", JOptionPane.ERROR_MESSAGE);
				} else if (confPasswd.isBlank()) {
					JOptionPane.showMessageDialog(vr, "Introduzca la confirmación de contraseña", "Error de datos", JOptionPane.ERROR_MESSAGE);
				} else if (!passw.equals(confPasswd)) {
					JOptionPane.showMessageDialog(vr, "Las contraseñas no coinciden", "Error de datos", JOptionPane.ERROR_MESSAGE);
				} else {
					
					boolean correoYaExiste = up.correoRepetido(correo);
					boolean nombreYaExiste = up.nombreRepetido(nombre);
					
					if (correoYaExiste) {
						JOptionPane.showMessageDialog(vr, "El correo ya está registrado", "Error de datos", JOptionPane.ERROR_MESSAGE);
					} else {
						usuario = new Usuarios(0, nombre, correo, "/img/usuario.png", 0, passw, 0);
						up.registrarUsuario(usuario);
						
						JOptionPane.showMessageDialog(vr, "Usuario creado con éxito", "Registro correcto", JOptionPane.INFORMATION_MESSAGE);
						
						up.getUser(correo);
						ut.crearTienda(up.getId_usuario());
						ulp.insertarLecciones(up.getId_usuario());
						
						vr.dispose();
						vr.limpiarDatos();
						vi.hacerVisible();
					}
					
				}
				
			}
			
			else if(e.getSource() == vu.getBtnCerrarVentana()) {
				vu.dispose();
			}
			
			// Volver (REGISTRO)
			else if (e.getSource().equals(vr.getBtnVolver())) {
				vr.dispose();
				vr.limpiarDatos();
				vi.hacerVisible();
			}
			
			// Iniciar sesión (INICIAR SESIÓN)
			else if (e.getSource().equals(vi.getBtnIniciarSesion())) {
				
				String correo = vi.getTxtCorreo();
				String passw = vi.getTxtPassw();
				
				if (correo.isBlank()) {
					JOptionPane.showMessageDialog(vi, "Introduzca el nombre de usuario", "Error de datos", JOptionPane.ERROR_MESSAGE);
				} else if (passw.isBlank()) {
					JOptionPane.showMessageDialog(vi, "Introduzca la contraseña", "Error de datos", JOptionPane.ERROR_MESSAGE);
				} else {
					 
					boolean correoCorrecto = up.existeUsuario(correo.trim());
					 
					 if (!correoCorrecto) {
						 JOptionPane.showMessageDialog(vi, "El usuario no existe", "Error de datos", JOptionPane.ERROR_MESSAGE);
					 } else {
						 
						 boolean contraCorrecta = up.contraCorrecta(correo.trim(), passw);
						 
						 if (!contraCorrecta) {
							 JOptionPane.showMessageDialog(vi, "Contraseña incorrecta", "Error de datos", JOptionPane.ERROR_MESSAGE);
						 } else {
							 
							 correoUsuActual = correo;
							 
							 vi.dispose();
							 vi.limpiarDatos();
							 
							 String foto = up.getFotoPerfil();
							 
							 if(foto != null) {
								 vm.cambiarFotoPerfil(foto);
							 }
							 
							 vm.cargarPanel(pc);
							 vm.hacerVisible();
						 }
						 
					 }
					 
				}
				
			}
			
			else if(e.getSource() == vcu.getBtnFP1() 
					|| e.getSource() == vcu.getBtnFP2() 
					|| e.getSource() == vcu.getBtnFP3()
					|| e.getSource() == vcu.getBtnFP4() 
					|| e.getSource() == vcu.getBtnFP5() 
					|| e.getSource() == vcu.getBtnFP6()) {
				String boton = e.getActionCommand();
				switch (boton) {
					case "imagen1":
						img = vcu.getTxtFP1();
						break;
						
					case "imagen2":
						img = vcu.getTxtFP2();
						break;
						
					case "imagen3":
						img = vcu.getTxtFP3();
						break;
						
					case "imagen4":
						img = vcu.getTxtFP4();
						break;
						
					case "imagen5":
						img = vcu.getTxtFP5();
						break;
						
					case "imagen6":
						img = vcu.getTxtFP6();
						break;
				}
			}
			
			else if(e.getSource() == vcu.getBtnGuardar()) {
				
				if(img == null) {
					img = "/img/usuario.png";
				}
				
				int res = up.customizarPerfil(img, vcu.getTxtNombre().getText());
				
				if(res != 0) {
					vm.cambiarFotoPerfil(img);
					JOptionPane.showMessageDialog(vcu, "Guardado con exito", "Informacion", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(vcu, "Algo no ha ido como esperado", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
			// Registrarse (INICIAR SESIÓN)
			else if (e.getSource().equals(vi.getBtnRegistrarse())) {
				vi.dispose();
				vi.limpiarDatos();
				vr.hacerVisible();
			}
			
			
			//BOTONES MENU
			// Home (CURSOS)
			else if (e.getSource().equals(vm.getBtnHome())) {
				vm.cargarPanel(pc);
			}
			
			else if(e.getSource().equals(vm.getBtnTienda())){
				pti.cargarObjetos(ut.cargarBotones(up.getId_usuario()));
				
				int saldo = up.comprobarSaldo();
				pti.cargarSaldo(saldo);
				
				vm.cargarPanel(pti);
			}
			
			else if(e.getSource().equals(vm.getBtnRanking())){
				vm.cargarPanel(pr);
				
				// Guardar nombre y puntos de los usuarios en un HashMap
				HashMap<String, Integer> tablaUsuPnt = up.nickPuntUsu();
				// Busco las imagenes de los usuarios
				ArrayList<String> imagenesUsu = up.imgUsu();
				// Esto lo uso para hacer un entry en un arraylist
				ArrayList<Entry<String, Integer>> tablaRanking = new ArrayList<Entry<String,Integer>>(tablaUsuPnt.entrySet());
				pr.mostrarRanking(tablaRanking,imagenesUsu);
			}
			
			else if(e.getSource().equals(vm.getBtnTemario())){
				vm.cargarPanel(pte);
			}
			
			else if(e.getSource().equals(vm.getBtnAjustes())){
				va.hacerVisible();
			}
			
			else if(e.getSource().equals(vm.getBtnNotis())){
				vn.hacerVisible();
				vn.setNotis(pn.selectNotificaciones());
			}
			
			else if(e.getSource().equals(vm.getBtnPerfil())){
				Usuarios usuario = up.cargarDatosUsuario();
				
				vu.getLblEmailUsuario().setText(usuario.getEmail());
				vu.getLblNomUsuario().setText(usuario.getNick());
				vu.getLblPipaCoins().setText(String.valueOf(usuario.getMonedas()) + " flipa coins");
				
				vu.hacerVisible();
			}
						
			//BOTONES NIVELES
			//CURSOS

//			else if(e.getSource().equals(pc.getBtnJava()) || e.getSource().equals(pc.getBtnHtml()) || e.getSource().equals(pc.getBtnCss()) || e.getSource().equals(pc.getBtnSql())) {
////				cargarLecciones(); //Posible metodo para diferenciar lecciones segun el lenguaje
//				vm.cargarPanel(pl);
//			}

			//Metodo en la persistencia de Lecciones pasándoles el id del curso
//			else if(e.getSource().equals(pc.getBtnJava())) {
//				cargarLecCur(FlipasPipasConst.ID_CURSO_JAVA);
//			} else if (e.getSource().equals(pc.getBtnHtml())){
//				cargarLecCur(FlipasPipasConst.ID_CURSO_HTML);
//			} else if (e.getSource().equals(pc.getBtnCss())){
//				cargarLecCur(FlipasPipasConst.ID_CURSO_CSS);
//			} else if (e.getSource().equals(pc.getBtnSql())){
//				cargarLecCur(FlipasPipasConst.ID_CURSO_SQL);
//			}
			
			//BOTONES DEFINICION
			else if(e.getSource().equals(pc.getBtnInterrogante1())) {
				vd.mostrarInterrogantes(0);
				vd.hacerVisible();
			}
			
			else if (e.getSource().equals(pc.getBtnInterrogante2())) {
				vd.mostrarInterrogantes(1);
				vd.hacerVisible();
			}
			
			else if (e.getSource().equals(pc.getBtnInterrogante3())) {
				vd.mostrarInterrogantes(2);
				vd.hacerVisible();
			}
			
			else if (e.getSource().equals(pc.getBtnInterrogante4())) {
				vd.mostrarInterrogantes(3);
				vd.hacerVisible();
			}
			
			//LECCIONES
			//JUNTAR TODOS
//			else if(e.getSource().equals(pl.getBtnLec_1()) 
//					|| e.getSource().equals(pl.getBtnExamen()) 
//					|| e.getSource().equals(pl.getBtnRepaso()) 
//					|| e.getSource().equals(pl.getBtnLec_2()) 
//					|| e.getSource().equals(pl.getBtnLec_3()) 
//					|| e.getSource().equals(pl.getBtnLec_4())) {
//				vm.dispose();
//				vp.hacerVisible();
//			}
			
			//BOTONES DEFINICION
			//JUNTAR TODOS
			else if(e.getSource().equals(pl.getBtnDfn_1())) {
				ArrayList<String> defList = lp.getDef(lenguaje);// TODO definir segun curso oh id de lecion interna oh externamente?
				vd.mostrarDef(defList.get(0));
				vd.hacerVisible();
			}
			
			else if(e.getSource().equals(pl.getBtnDfn_2())) {
				ArrayList<String> defList = lp.getDef(lenguaje);// TODO definir segun curso oh id de lecion interna oh externamente?
				vd.mostrarDef(defList.get(1));
				vd.hacerVisible();
			}
			
			else if(e.getSource().equals(pl.getBtnDfn_3())) {
				ArrayList<String> defList = lp.getDef(lenguaje);// TODO definir segun curso oh id de lecion interna oh externamente?
				vd.mostrarDef(defList.get(2));
				vd.hacerVisible();
			}
			
			else if(e.getSource().equals(pl.getBtnDfn_4())) {
				ArrayList<String> defList = lp.getDef(lenguaje);// TODO definir segun curso oh id de lecion interna oh externamente?
				vd.mostrarDef(defList.get(3));
				vd.hacerVisible();
			}
			
			
					
			//BOTONES USUARIO
			//USUARIO
			else if(e.getSource().equals(vu.getBtnEditarPerfil())) {
				vu.dispose();
				vcu.cargarObjetos(ut.cargarBotones(up.getId_usuario()));
				vcu.getTxtNombre().setText(up.getNick());
				vcu.hacerVisible();
			}
			
			//BOTONES CONFIRMACION
			else if(e.getSource() == vu.getBtnCerrarSesion() || e.getSource() == va.getBtnBorrarCuenta()) {
				String texto = e.getActionCommand();

				
				int res = JOptionPane.showConfirmDialog( vp,"¿Estás seguro?", "Confirmacion", JOptionPane.YES_NO_OPTION);
				
				if(res == JOptionPane.YES_OPTION) {
					switch (texto) {
					case VUsuario.ACT_COM_BTN_CERRARSESION:
						vu.dispose();
						vm.dispose();
						vi.hacerVisible();
						break;
						/* * * * NO ENTRA EN EL CASE * * * */
					case VAjustes.ACT_CMD_BTN_BORRAR_CUENTA:


						up.borrarcuenta();
						va.dispose();
						vi.hacerVisible();

						up.borrarcuenta();
						vi.hacerVisible();
						break;
					}
				}
				
			}


			// CURSOS
				// CSS
			else if (e.getSource().equals(pc.getBtnCss())) {
				lenguaje = FlipasPipasConst.ID_CURSO_CSS;
				cargarLecCur(FlipasPipasConst.ID_CURSO_CSS);
				vm.cargarPanel(pl);
			}
				// HTML
			else if (e.getSource().equals(pc.getBtnHtml())) {
				lenguaje = FlipasPipasConst.ID_CURSO_HTML;
				cargarLecCur(FlipasPipasConst.ID_CURSO_HTML);
				vm.cargarPanel(pl);
			}
				// JAVA
			else if (e.getSource().equals(pc.getBtnJava())) {
				lenguaje = FlipasPipasConst.ID_CURSO_JAVA;
				cargarLecCur(FlipasPipasConst.ID_CURSO_JAVA);
				vm.cargarPanel(pl);
			}
				// SQL
			else if (e.getSource().equals(pc.getBtnSql())) {
				lenguaje = FlipasPipasConst.ID_CURSO_SQL;
				cargarLecCur(FlipasPipasConst.ID_CURSO_SQL);
				vm.cargarPanel(pl);
			}
			
			// PREGUNTAS
				//Pregunta 1
			else if (e.getSource().equals(pl.getBtnLec_1())) {
				cargarPregunta(19, 13, 1, 7);
				estabelcerNivelActual(1, 7, 13, 19);
			}
				// Pregunta 2
			else if (e.getSource().equals(pl.getBtnLec_2())) {
				cargarPregunta(20, 14, 2, 8);
				estabelcerNivelActual(2, 8, 14, 20);
			}
				// Repaso
			else if (e.getSource().equals(pl.getBtnRepaso())) {
				cargarPregunta(21, 15, 3, 9);
				estabelcerNivelActual(3, 9, 15, 21);
			}
				// Pregunta 3
			else if (e.getSource().equals(pl.getBtnLec_3())) {
				cargarPregunta(22, 16, 4, 10);
				estabelcerNivelActual(4, 10, 16, 22);
			}
				// Pregunta 4
			else if (e.getSource().equals(pl.getBtnLec_4())) {
				cargarPregunta(23, 17, 5, 11);
				estabelcerNivelActual(5, 11, 17, 23);
			}
				// Examen
			else if (e.getSource().equals(pl.getBtnExamen())) {
				cargarPregunta(24, 18, 6, 12);
				estabelcerNivelActual(6, 12, 18, 25);
			}
			
				// Botón A
			else if (e.getSource().equals(vp.getBtnA())) {
				// Si aciertas la pregunta
				if (vp.getBtnA().getText().equals(preguntas.get(pregPos).getCorrecta())) {
					preguntaAcertada();
					if (pregPos != preguntas.size()) JOptionPane.showMessageDialog(vm, "¡Pregunta acertada, muy bien!", "Sigue así", JOptionPane.INFORMATION_MESSAGE);
				}
				// Si fallas
				else preguntaFallada();
			}
				
				// Botón B
			else if (e.getSource().equals(vp.getBtnB())) {
				// Si aciertas la pregunta
				if (vp.getBtnB().getText().equals(preguntas.get(pregPos).getCorrecta())) {
					preguntaAcertada();
					if (pregPos != preguntas.size()) JOptionPane.showMessageDialog(vm, "¡Pregunta acertada, muy bien!", "Sigue así", JOptionPane.INFORMATION_MESSAGE);
				}
				// Si fallas
				else preguntaFallada();
			}
				
				// Botón C
			else if (e.getSource().equals(vp.getBtnC())) {
				// Si aciertas la pregunta
				if (vp.getBtnC().getText().equals(preguntas.get(pregPos).getCorrecta())) {
					preguntaAcertada();
					if (pregPos != preguntas.size()) JOptionPane.showMessageDialog(vm, "¡Pregunta acertada, muy bien!", "Sigue así", JOptionPane.INFORMATION_MESSAGE);
				}
				// Si fallas
				else preguntaFallada();
			}
				
				// Botón D
			else if (e.getSource().equals(vp.getBtnD())) {
				// Si aciertas la pregunta
				if (vp.getBtnD().getText().equals(preguntas.get(pregPos).getCorrecta())) {
					preguntaAcertada();
					if (pregPos != preguntas.size()) JOptionPane.showMessageDialog(vm, "¡Pregunta acertada, muy bien!",
							"Sigue así", JOptionPane.INFORMATION_MESSAGE);
				}
				// Si fallas
				else preguntaFallada();
			}

			
			//BOTONES SALIR
			else if(e.getSource().equals(va.getBtnSalir())) {
				va.dispose();
			}			
			
			else if(e.getSource() == vn.getBtnSalir()) {
				vn.dispose();
			}
			
			else if(e.getSource().equals(vp.getBtnSalir())) {
				int opc = JOptionPane.showConfirmDialog(vp,"¿Estás segur@ de que quieres salir? Tu progreso no se guardará",
						"Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (opc == JOptionPane.YES_OPTION) {
					vp.dispose();
					vm.hacerVisible();
					vm.cargarPanel(pl);
				}
			}
			
			else if(e.getSource() == vcu.getBtnSalir()) {
				vcu.dispose();
				vu.hacerVisible();
			}
			

			else if (e.getSource().equals(vd.getBtnSalirDef())) {
				vd.dispose();;
			}


			else if(e.getSource() == vcu.getBtnFP1() 
					|| e.getSource() == vcu.getBtnFP2() 
					|| e.getSource() == vcu.getBtnFP3()
					|| e.getSource() == vcu.getBtnFP4() 
					|| e.getSource() == vcu.getBtnFP5() 
					|| e.getSource() == vcu.getBtnFP6()) {
				String boton = e.getActionCommand();
				switch (boton) {
					case "imagen1":
						img = vcu.getBtnFP1().getIcon().toString();
						break;
						
					case "imagen2":
						img = vcu.getBtnFP2().getIcon().toString();
						break;
						
					case "imagen3":
						img = vcu.getBtnFP3().getIcon().toString();
						break;
						
					case "imagen4":
						img = vcu.getBtnFP4().getIcon().toString();
						break;
						
					case "imagen5":
						img = vcu.getBtnFP5().getIcon().toString();
						break;
						
					case "imagen6":
						img = vcu.getBtnFP6().getIcon().toString();
						break;
				}
			}
			
			else if(e.getSource() == vcu.getBtnGuardar()) {
				int res = up.customizarPerfil(img, vu.getLblNomUsuario().getText());
				
				if(res != 0) {
					JOptionPane.showMessageDialog(vcu, "Guardado con exito", "Informacion", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(vcu, "Algo no ha ido como esperado", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			} 
			

			
			
			else if(e.getSource() == pti.getBtnObj1() 
					|| e.getSource() == pti.getBtnObj2() 
					|| e.getSource() == pti.getBtnObj3() 
					|| e.getSource() == pti.getBtnObj4() 
					|| e.getSource() == pti.getBtnObj5() 
					|| e.getSource() == pti.getBtnObj6()) {
				String boton = e.getActionCommand();
				
				int res = JOptionPane.showConfirmDialog(pti, "¿Estás seguro?", "Confirmacion Compra", JOptionPane.YES_NO_OPTION);
				Tienda id = null;
				
				if(res == JOptionPane.YES_OPTION) {
					switch (boton) {
					case "Objeto1":
						id = ut.comprobarObjeto(pti.getBtnObj1().getText());
						break;
					case "Objeto2":
						id = ut.comprobarObjeto(pti.getBtnObj2().getText());
						break;
					case "Objeto3":
						id = ut.comprobarObjeto(pti.getBtnObj3().getText());
						break;
					case "Objeto4":
						id = ut.comprobarObjeto(pti.getBtnObj4().getText());
						break;
					case "Objeto5":
						id = ut.comprobarObjeto(pti.getBtnObj5().getText());
						break;
					case "Objeto6":
						id = ut.comprobarObjeto(pti.getBtnObj6().getText());
						break;
					}
					
					

				}
				

				
				boolean comprado = false;
				
				if(id != null) {
					int saldo = pti.getSaldo();
					if(saldo > 0) {
						int realizado = ut.comprarObjeto(id, up.getId_usuario());
						
						if(realizado != 0) {
							int actualizado = up.compradoObjeto(saldo - id.getPrecio());
							
							if(actualizado != 0) {
								comprado = true;
								pti.cargarObjetos(ut.cargarBotones(up.getId_usuario()));
								saldo = up.comprobarSaldo();
								pti.cargarSaldo(saldo);
								JOptionPane.showMessageDialog(pti, "Ha comprado el icono", "Compra Realizada", JOptionPane.INFORMATION_MESSAGE);								
							}
						} 
					}
				}
				if(!comprado && id != null) {
					JOptionPane.showMessageDialog(pti, "No se ha podido completar la transaccion", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
				
		} else if (e.getSource() instanceof JTextArea) {
			System.out.println("hola");
		}
		
	}


	private void estabelcerNivelActual(int i, int j, int k, int l) {
		if(lenguaje == FlipasPipasConst.ID_CURSO_JAVA) {
			nivActual = i;
		}
		else if (lenguaje == FlipasPipasConst.ID_CURSO_SQL) {
			nivActual = j;
		}
		else if (lenguaje == FlipasPipasConst.ID_CURSO_HTML) {
			nivActual = k;
		}
		else if (lenguaje == FlipasPipasConst.ID_CURSO_CSS) {
			nivActual = l;
		}
	}


	private void cargarPregunta(int css, int html, int java, int sql) {
		preguntas = null;
		pregPos = 0;
		
		if (lenguaje == FlipasPipasConst.ID_CURSO_CSS) obtenerEstablecerPregunta(css);
		else if (lenguaje == FlipasPipasConst.ID_CURSO_HTML) obtenerEstablecerPregunta(html);
		else if (lenguaje == FlipasPipasConst.ID_CURSO_JAVA) obtenerEstablecerPregunta(java);
		else if (lenguaje == FlipasPipasConst.ID_CURSO_SQL) obtenerEstablecerPregunta(sql);
	}


	private void obtenerEstablecerPregunta(int num) {
		preguntas = upp.getPreg(num);
		vm.dispose();
		vp.setPregunta(preguntas.get(pregPos));
		vp.hacerVisible();
	}


	private void preguntaFallada() {
		JOptionPane.showMessageDialog(vp, "Has fallado!", "" , JOptionPane.ERROR_MESSAGE);
		
		// 
		if (cantFallos < Math.floor(CANT_PIPAS_LECCION/CANT_PIPAS_PENALIZACION)) cantFallos+=1;
		
		// Mueve la pregunta fallida al final del ArrayList
		preguntas.add(preguntas.get(pregPos));
		
		// Si aún quedan preguntas, pasa a la siguiente
		if (pregPos < preguntas.size() - 1) {
		    pregPos += 1;
		} else {
		    pregPos = 0;
		}
		
		vp.setPregunta(preguntas.get(pregPos));
	}


	private void preguntaAcertada() {
			
		if (pregPos < preguntas.size()) {
			pregPos += 1;
		}
		
		// Si has acertado la última pregunta
		if (pregPos == preguntas.size()) {
			// Calcular cantidad de pipas
			pipas = CANT_PIPAS_LECCION - cantFallos*CANT_PIPAS_PENALIZACION;
			puntos = CANT_PIPAS_LECCION - cantFallos*CANT_PIPAS_PENALIZACION;
			JOptionPane.showMessageDialog(vp, "¡Has acabado la lección! Has obtenido " + pipas + " pipacoins y "
					+ puntos + " puntos", "¡Enhorabuena!", JOptionPane.INFORMATION_MESSAGE);
			
			// Añadir pipas al usuario
			up.aniadirPipas(correoUsuActual, pipas);
			up.aniadirPuntos(correoUsuActual, puntos);
			
//			 Añadir pipas a los bots
			int pipasUsuario = up.getPipasUsuario(correoUsuActual);
			Random rd = new Random();
			
			int puntosBot1 = rd.nextInt((int) Math.round(pipasUsuario*PIPAS_MIN_BOT), (int) Math.round(pipasUsuario*PIPAS_MAX_BOT));
			int puntosBot2 = rd.nextInt((int) Math.round(pipasUsuario*PIPAS_MIN_BOT), (int) Math.round(pipasUsuario*PIPAS_MAX_BOT));
			int puntosBot3 = rd.nextInt((int) Math.round(pipasUsuario*PIPAS_MIN_BOT), (int) Math.round(pipasUsuario*PIPAS_MAX_BOT));
			up.puntosABots(puntosBot1, puntosBot2, puntosBot3);
			
//			ulp.leccionTerminada(nivActual, up.getId_usuario());
			
			if(nivActual != 6 || nivActual != 12 || nivActual != 18 || nivActual != 24) {
				ulp.desbloquearLeccion(up.getId_usuario(), nivActual + 1);
				pl.cargarLec(lp.datosLeccion(lenguaje), lenguaje, ulp.cargarLecciones(up.getId_usuario(), lenguaje));
			}
			vp.dispose();
			vm.cargarPanel(pl);
			vm.hacerVisible();
		}
		// Si no
		else {
			vp.setPregunta(preguntas.get(pregPos));

		}
	}
	
	private void cargarLecCur(int id_curso) {
		vm.cargarPanel(pl);
		
		String nomCur = "";
		
		switch (id_curso) {
			case FlipasPipasConst.ID_CURSO_JAVA: nomCur="JAVA";break;
			case FlipasPipasConst.ID_CURSO_SQL: nomCur="SQL";break;
			case FlipasPipasConst.ID_CURSO_HTML: nomCur="HTML";break;
			case FlipasPipasConst.ID_CURSO_CSS: nomCur="CSS";break;
		}
		
		
		
		ArrayList<Boolean> nvlsOK = ulp.cargarLecciones(up.getId_usuario(), id_curso);
		ArrayList<String> nomLec = lp.datosLeccion(id_curso);

		pl.cargarLec(nomLec, lenguaje, nvlsOK);

//		pl.cargarLec(nomLec, lenguaje, nomCur);

	}


	public void setPanel(PnlTienda tienda) {
		this.pti = tienda;
	}
	
	public void setPanel(PnlLeciones lecciones) {
		this.pl = lecciones;
	}
	
	public void setPanel(PnlCursos cursos) {
		this.pc = cursos;
	}
	
	public void setPanel(PnlRanking ranking) {
		this.pr = ranking;
	}
	
	public void setPanel(PnlTemario temario) {
		this.pte = temario;
	}
	
	public void setVentana(Vdefiniciones definiciones) {
		this.vd = definiciones;
	}
	
	public void setVentana(VAjustes ajustes) {
		this.va = ajustes;
	}
	

	
	public void setVentana(VCustomizacion customizacion) {
		this.vcu = customizacion;
	}
	
	public void setVentana(VNotis notificaciones) {
		this.vn = notificaciones;
	}
	
	public void setVentana(VPreguntas preguntas) {
		this.vp = preguntas;
	}
	
	public void setVentana(VUsuario usuario) {
		this.vu = usuario;
	}
	
	public void setVentana(VRegistro registro) {
		this.vr = registro;
	}
	
	public void setVentana(VMenu menu) {
		this.vm = menu;
	}

}
