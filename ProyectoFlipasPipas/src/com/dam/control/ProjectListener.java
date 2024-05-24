package com.dam.control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JOptionPane;

import javax.swing.JTextField;

import com.dam.db.persistencias.UsuPregPer;
import com.dam.db.persistencias.UsuariosPer;
import com.dam.model.pojos.Preguntas;
import com.dam.model.pojos.Usuarios;


import com.dam.db.persistencias.NotificacionesPer;
import com.dam.db.persistencias.UsuariosPer;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JButton;

import com.dam.db.constants.FlipasPipasConst;
import com.dam.db.persistencias.LeccionesPer;
import com.dam.db.persistencias.UsuPregPer;
import com.dam.model.pojos.Lecciones;


import com.dam.view.PnlCursos;
import com.dam.view.PnlLeciones;
import com.dam.view.PnlRanking;
import com.dam.view.PnlTemario;
import com.dam.view.PnlTienda;
import com.dam.view.VAjustes;
import com.dam.view.VConfirmacion;
import com.dam.view.VCustomizacion;
import com.dam.view.VInicioSesion;
import com.dam.view.VMenu;
import com.dam.view.VNotis;
import com.dam.view.VPreguntas;
import com.dam.view.VRegistro;
import com.dam.view.VUsuario;
import com.dam.view.Vdefiniciones;

public class ProjectListener implements ActionListener {
	//CLASES REGISTRO/INICIO
	private VRegistro vr;
	private VInicioSesion vi;
	
	//CLASES MENU
	private VMenu vm;
	private PnlTienda pti;
	private PnlRanking pr;
	private PnlTemario pte;
	private PnlCursos pc;
	private VAjustes va;
	private VNotis vn;
	private VUsuario vu;
	private VCustomizacion vcu;
	
	//CLASES GENERALES
	private VConfirmacion vco;
	private Vdefiniciones vd;
	
	//CLASES NIVELES
	private PnlLeciones pl;
	private VPreguntas vp;
	


	// CLASES PERSISTENCIAS
	private UsuariosPer usuper;
	private UsuPregPer usupregper;
	
	// CLASES POJOS
	private Usuarios usuario;
	
	// EN QUÉ VENTANA ESTÁ EL USUARIO
	private String lenguaje;
	
	// PREGUNTAS
	private int pregPos;
	private ArrayList<Preguntas> preguntas;

	//PERSISTENCIAS
	private UsuariosPer pu;
	private NotificacionesPer pn;

	// PERSISTENCIAS
	private UsuPregPer upp;
	private LeccionesPer lp;
	

	
	public ProjectListener(VRegistro vr, VInicioSesion vi, VMenu vm, PnlTienda pti, PnlRanking pr, PnlTemario pte,
			PnlCursos pc, VAjustes va, VNotis vn, VUsuario vu, VCustomizacion vcu, VConfirmacion vco,
			PnlLeciones pl, VPreguntas vp, Vdefiniciones vd) {
		this.vr = vr;
		this.vi = vi;
		this.vm = vm;
		this.pti = pti;
		this.pr = pr;
		this.pte = pte;
		this.pc = pc;
		this.va = va;
		this.vn = vn;
		this.vu = vu;
		this.vcu = vcu;
		this.vco = vco;
		this.pl = pl;
		this.vp = vp;
		this.vd = vd;

		pu = new UsuariosPer();
		pn = new NotificacionesPer();

		upp = new UsuPregPer();
		lp = new LeccionesPer();

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
				} else if (correo.isBlank() || correo.equals("Correo")) {
					JOptionPane.showMessageDialog(vr, "Introduce un correo", "Error de datos", JOptionPane.ERROR_MESSAGE);
				} else if (usuper.correoRepetido(correo)) {
					JOptionPane.showMessageDialog(vr, "El correo introducido ya existe", "Error de datos", JOptionPane.ERROR_MESSAGE);
				} else if (passw.isBlank() || passw.equals("Contraseña")) {
					JOptionPane.showMessageDialog(vr, "Introduzca una contraseña", "Error de datos", JOptionPane.ERROR_MESSAGE);
				} else if (confPasswd.isBlank() || confPasswd.equals("Confirmar contraseña")) {
					JOptionPane.showMessageDialog(vr, "Introduzca la confirmación de contraseña", "Error de datos", JOptionPane.ERROR_MESSAGE);
				} else if (!passw.equals(confPasswd)) {
					JOptionPane.showMessageDialog(vr, "Las contraseñas no coinciden", "Error de datos", JOptionPane.ERROR_MESSAGE);
				} else {
					
					boolean correoYaExiste = usuper.correoRepetido(correo);
					boolean nombreYaExiste = usuper.nombreRepetido(nombre);
					
					if (correoYaExiste) {
						JOptionPane.showMessageDialog(vr, "El correo ya está registrado", "Error de datos", JOptionPane.ERROR_MESSAGE);
					} else {
						usuario = new Usuarios(0, nombre, correo, "Foto 1", 0, passw);
						usuper.registrarUsuario(usuario);
						JOptionPane.showMessageDialog(vr, "Usuario creado con éxito", "Registro correcto", JOptionPane.INFORMATION_MESSAGE);
						
						vr.dispose();
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
				vi.hacerVisible();
			}
			
			// Iniciar sesión (INICIAR SESIÓN)
			else if (e.getSource().equals(vi.getBtnIniciarSesion())) {
				
				String correo = vi.getTxtCorreo();
				String passw = vi.getTxtPassw();
				
				if (correo.isBlank() || correo.equals("Correo")) {
					JOptionPane.showMessageDialog(vi, "Introduzca el nombre de usuario", "Error de datos", JOptionPane.ERROR_MESSAGE);
				} else if (passw.isBlank()) {
					JOptionPane.showMessageDialog(vi, "Introduzca la contraseña", "Error de datos", JOptionPane.ERROR_MESSAGE);
				} else {
					 
					boolean correoCorrecto = usuper.existeUsuario(correo);
					 
					 if (!correoCorrecto) {
						 JOptionPane.showMessageDialog(vi, "El usuario no existe", "Error de datos", JOptionPane.ERROR_MESSAGE);
					 } else {
						 
						 boolean contraCorrecta = usuper.contraCorrecta(correo, passw);
						 
						 if (!contraCorrecta) {
							 JOptionPane.showMessageDialog(vi, "Contraseña incorrecta", "Error de datos", JOptionPane.ERROR_MESSAGE);
						 } else {
							 vi.dispose();
							 vm.cargarPanel(pc);
							 vm.hacerVisible();
						 }
						 
					 }
					 
				}
				
			}
			
			// Registrarse (INICIAR SESIÓN)
			else if (e.getSource().equals(vi.getBtnRegistrarse())) {
				vi.dispose();
				vr.hacerVisible();
			}
			
			
			//BOTONES MENU
			// Home (CURSOS)
			else if (e.getSource().equals(vm.getBtnHome())) {
				vm.cargarPanel(pc);
			}
			
			else if(e.getSource().equals(vm.getBtnTienda())){
				vm.cargarPanel(pti);
			}
			
			else if(e.getSource().equals(vm.getBtnRanking())){
				vm.cargarPanel(pr);
				// Guardo nombre y puntos de usuario en un HashMap
				HashMap<String, Integer> tablaUsuPnt = upp.nickPuntUsu();
				// Esto lo uso para hacer un entry en un arraylist
				ArrayList<Entry<String, Integer>> tablaRanking = new ArrayList<Entry<String,Integer>>(tablaUsuPnt.entrySet());
				pr.mostrarRanking(tablaRanking);
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
				vu.hacerVisible();
			}
						
			//BOTONES NIVELES
			//CURSOS

//			else if(e.getSource().equals(pc.getBtnJava()) || e.getSource().equals(pc.getBtnHtml()) || e.getSource().equals(pc.getBtnCss()) || e.getSource().equals(pc.getBtnSql())) {
////				cargarLecciones(); //Posible metodo para diferenciar lecciones segun el lenguaje
//				vm.cargarPanel(pl);
//			}

			//Metodo en la persistencia de Lecciones pasándoles el id del curso
			else if(e.getSource().equals(pc.getBtnJava())) {
				cargarLecCur(FlipasPipasConst.ID_CURSO_JAVA);
			} else if (e.getSource().equals(pc.getBtnHtml())){
				cargarLecCur(FlipasPipasConst.ID_CURSO_HTML);
			} else if (e.getSource().equals(pc.getBtnCss())){
				cargarLecCur(FlipasPipasConst.ID_CURSO_CSS);
			} else if (e.getSource().equals(pc.getBtnSql())){
				cargarLecCur(FlipasPipasConst.ID_CURSO_SQL);
			}
			
			//BOTONES DEFINICION
			else if(e.getSource().equals(pc.getBtnInterrogante1())) {
				vd.hacerVisible();
				vd.mostrarDefinicion(0);
			}
			
			else if (e.getSource().equals(pc.getBtnInterrogante2())) {
				vd.hacerVisible();
				vd.mostrarDefinicion(1);
			}
			
			else if (e.getSource().equals(pc.getBtnInterrogante3())) {
				vd.hacerVisible();
				vd.mostrarDefinicion(2);
			}
			
			else if (e.getSource().equals(pc.getBtnInterrogante4())) {
				vd.hacerVisible();
				vd.mostrarDefinicion(3);
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
			else if(e.getSource().equals(pl.getBtnDfn_1()) || e.getSource().equals(pl.getBtnDfn_2()) || e.getSource().equals(pl.getBtnDfn_3()) || e.getSource().equals(pl.getBtnDfn_4())) {
				vd.hacerVisible();
				
			}
					
			//BOTONES USUARIO
			//USUARIO
			else if(e.getSource().equals(vu.getBtnEditarPerfil())) {
				vu.dispose();
				vcu.hacerVisible();
			}
			
			//BOTONES CONFIRMACION
			else if(e.getSource() == vu.getBtnCerrarSesion() || e.getSource() == va.getBtnBorrarCuenta()) {
				String texto = e.getActionCommand();
				Object ventana = e.getSource();
				vco.hacerVisible();
				
				int res = JOptionPane.showConfirmDialog((Component) ventana,"¿Estás seguro?", "Confirmacion", JOptionPane.YES_NO_OPTION);
				
				if(res == JOptionPane.YES_OPTION) {
					switch (texto) {
					case VUsuario.ACT_COM_BTN_CERRARSESION:
						vu.dispose();
						vm.dispose();
						vi.hacerVisible();
						break;
					case VAjustes.ACT_CMD_BTN_BORRAR_CUENTA:
						//TODO poner metodo borrarcuenta() persistencia Usuarios
						break;
					}
				}
				
			}

			// CURSOS
				// CSS
			else if (e.getSource().equals(pc.getBtnCss())) {
				lenguaje = "CSS";
				vm.cargarPanel(pl);
			}
				// HTML
			else if (e.getSource().equals(pc.getBtnHtml())) {
				lenguaje = "HTML";
				vm.cargarPanel(pl);
			}
				// JAVA
			else if (e.getSource().equals(pc.getBtnJava())) {
				lenguaje = "JAVA";
				vm.cargarPanel(pl);
			}
				// SQL
			else if (e.getSource().equals(pc.getBtnSql())) {
				lenguaje = "SQL";
				vm.cargarPanel(pl);
			}
			
			// PREGUNTAS TODO
				//Pregunta 1
			else if (e.getSource().equals(pl.getBtnLec_1())) cargarPregunta(19, 13, 1, 7);
				// Pregunta 2
			else if (e.getSource().equals(pl.getBtnLec_2())) cargarPregunta(20, 14, 2, 8);
				// Repaso
			else if (e.getSource().equals(pl.getBtnRepaso())) cargarPregunta(21, 15, 3, 9);
				// Pregunta 3
			else if (e.getSource().equals(pl.getBtnLec_3())) cargarPregunta(22, 16, 4, 10);
				// Pregunta 4
			else if (e.getSource().equals(pl.getBtnLec_4())) cargarPregunta(23, 17, 5, 11);
				// Examen
			else if (e.getSource().equals(pl.getBtnExamen())) cargarPregunta(24, 18, 6, 12);
			
				// Botón A
			else if (e.getSource().equals(vp.getBtnA())) {
				// Si aciertas la pregunta
				if (vp.getBtnA().getText().equals(preguntas.get(pregPos).getCorrecta())) preguntaAcertada();
				// Si fallas
				else preguntaFallada();
			}
				
				// Botón B
			else if (e.getSource().equals(vp.getBtnB())) {
				// Si aciertas la pregunta
				if (vp.getBtnB().getText().equals(preguntas.get(pregPos).getCorrecta())) preguntaAcertada();
				// Si fallas
				else preguntaFallada();
			}
				
				// Botón C
			else if (e.getSource().equals(vp.getBtnC())) {
				// Si aciertas la pregunta
				if (vp.getBtnC().getText().equals(preguntas.get(pregPos).getCorrecta())) preguntaAcertada();
				// Si fallas
				else preguntaFallada();
			}
				
				// Botón D
			else if (e.getSource().equals(vp.getBtnD())) {
				// Si aciertas la pregunta
				if (vp.getBtnD().getText().equals(preguntas.get(pregPos).getCorrecta())) preguntaAcertada();
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
				vp.dispose();
				vm.hacerVisible();
				vm.cargarPanel(pl);
			}
			
			else if(e.getSource() == vcu.getBtnSalir()) {
				vcu.dispose();
				vu.hacerVisible();
			}
			
			else if(e.getSource() == vco.getBtnRespNo()) {
				vco.dispose();
			}
			
			else if (e.getSource().equals(vd.getBtnSalirDef())) {
				vd.dispose();;
			}

			
		}
		
	}


	private void cargarPregunta(int css, int html, int java, int sql) {
		preguntas = null;
		pregPos = 0;
		
		if (lenguaje.equals("CSS")) obtenerEstablecerPregunta(css);
		else if (lenguaje.equals("HTML")) obtenerEstablecerPregunta(html);
		else if (lenguaje.equals("JAVA")) obtenerEstablecerPregunta(java);
		else if (lenguaje.equals("SQL")) obtenerEstablecerPregunta(sql);
	}


	private void obtenerEstablecerPregunta(int num) {
		preguntas = usupregper.getPreg(num);
		vm.dispose();
		vp.hacerVisible();
		vp.setPregunta(preguntas.get(pregPos));
	}


	private void preguntaFallada() {
		JOptionPane.showMessageDialog(vp, "Has fallado!", "" , JOptionPane.ERROR_MESSAGE);
		
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
			JOptionPane.showMessageDialog(vp, "¡Has acabado la lección!", "¡Enhorabuena!", JOptionPane.INFORMATION_MESSAGE);
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
		
		ArrayList<String> nomLec = lp.datosLeccion(id_curso);
		pl.cargarLec(nomLec, nomCur);

	}

}
