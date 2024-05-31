package com.dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.dam.db.persistencias.UsuPregPer;
import com.dam.db.persistencias.UsuTienda;
import com.dam.db.persistencias.UsuariosPer;
import com.dam.model.pojos.Preguntas;
import com.dam.model.pojos.Usuarios;


import com.dam.db.persistencias.NotificacionesPer;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dam.db.constants.FlipasPipasConst;
import com.dam.db.persistencias.LeccionesPer;
import com.dam.db.persistencias.UsuLecPer;
import com.dam.db.persistencias.UsuNotificacionesPer;
import com.dam.model.pojos.Tienda;

import com.dam.view.*;


public class ProjectListener implements ActionListener {
	
	//CLASES REGISTRO/INICIO
	private VRegistro vr; //---> Ventana de registro de usuario
	private VInicioSesion vi; //---> Ventana de inicio de sesión
	
	//CLASES MENU
	private VMenu vm; //---> Ventana Menú, con el menú donde se cargarán los paneles
	private PnlTienda pti; //---> Panel de Tienda, donde se cargan los iconos a comprar
	private PnlRanking pr; //---> Panel de Ranking, donde aparecen los usuarios con más puntos
	private PnlTemario pte; //---> Panel de Temario, donde podrás consultar el temario
	private PnlCursos pc; //---> Panel de Cursos, donde se cargarán los cursos
	private VAjustes va; //---> Ventana de Ajustes, donde podrás consultar las redes sociales de FliplasPipas y borrar la cuenta
	private VNotificaciones vn; //---> Ventana de Notificaciones, donde se irán enviando notificaciones
	private VUsuario vu; //---> Ventana de Usuario, donde podrás consultar el nombre, correo, monedas y puntos. También podrás ir a la customización del usuario
	private VCustomizacion vcu; //---> Ventana de Customización, donde pordrás cambiar el nombre de usuario y la imagen
	private Vdefiniciones vd; //---> Ventana de Definiciones, donde podrás consultar en detalle el temario de una lección
	private PnlLeciones pl; //---> Panel de Lecciones, donde según el curso en el que estes aparecerán unos niveles u otros
	private VPreguntas vp; //---> Ventana de Preguntas, donde se mostrarán las preguntas con sus respuestas

	// CLASES PERSISTENCIAS
	private UsuariosPer up; //---> Clase que se encarga de la gestión de la tabla usuarios
	private UsuPregPer upp; //---> Clase que se encarga de la gestión de las preguntas
	private LeccionesPer lp; //---> Clase que se encarga de la gestión de las lecciones
	private UsuTienda ut; //---> Clase que se encarga de la gestión de la tienda
	private NotificacionesPer np; //---> Clase que se encarga de enviar las notificaciones
	private UsuNotificacionesPer unp; //---> Clase que se encarga de crear las notificaciones de cada usuario
	private UsuLecPer ulp; //---> Clase que se encarga de crear las lecciones
	
	// CLASES POJOS
	private Usuarios usuario; //---> Clase POJO que se encarga de representar un Usuario

	
	private int lenguaje; //---> Variable que se encarga de almacenar el curso en el que esta el usuario
	private int nivActual; //---> Variable que se encarga de almacenar el nivel actual
	private String correoUsuActual; //---> Variable que se encarga de almacenar el correo del usuario
	
	// PREGUNTAS
	private int pregPos; //---> Variable que se encarga de almacenar el curso en el que esta el usuario
	private ArrayList<Preguntas> preguntas; //---> Colección que se encarga de almacenar las preguntas
	
	// FALLOS Y PUNTOS
	private int cantFallos = 0; //---> Variable que se encarga de almacenar la cantidad de fallos cometidos en los niveles
	private int pipas = 0; //---> Variable que se encarga de almacenar la cantidad de monedas ganadas
	private int puntos = 0; //---> Variable que se encarga de almacenar la cantidad de puntos ganados
	
	private String img; //---> Variable que se encarga de almacenar la imagen seleccionada por el usuario
	
	public ProjectListener(VInicioSesion vi) {
		this.vi = vi;
		
		np = new NotificacionesPer();
		unp = new UsuNotificacionesPer();
		upp = new UsuPregPer();
		lp = new LeccionesPer();
		up = new UsuariosPer();
		ut = new UsuTienda();
		ulp = new UsuLecPer();
	}

	
	public void actionPerformed(ActionEvent e) {
		
		// BOTONES
		if (e.getSource() instanceof JButton) {
			
			//BOTONES INICIO/REGISTRO
			// Regístrate (REGISTRO)
			if (e.getSource().equals(vr.getBtnRegistrar())) {
				
				String nombre = vr.getTxtNombre();
				String correo = vr.getTxtCorreo();
				String passw = vr.getTxtContrasenia();
				String confPasswd = vr.getTxtConfirmarContrasenia();
				Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
		        Matcher mat = pattern.matcher(correo);
				
				if (nombre.isBlank()) {
					JOptionPane.showMessageDialog(vr, "Introduce un nick", "Error de datos", JOptionPane.ERROR_MESSAGE);
					
				} else if (nombre.length() > FlipasPipasConst.TAM_NOMBRE) {
					JOptionPane.showMessageDialog(vr, "El nick no puede contener más de " + FlipasPipasConst.TAM_NOMBRE + " caracteres"
							, "Error de datos", JOptionPane.ERROR_MESSAGE);
					
				} else if (correo.isBlank()) {
					JOptionPane.showMessageDialog(vr, "Introduce un correo", "Error de datos", JOptionPane.ERROR_MESSAGE);
					
				} else if (!mat.matches()) {
					JOptionPane.showMessageDialog(vr, "El correo debe tener formato 'texto@direccion.abc'",
							"Error de datos", JOptionPane.ERROR_MESSAGE);
					
				} else if (up.correoRepetido(correo)) {
					JOptionPane.showMessageDialog(vr, "El correo introducido ya existe", "Error de datos", JOptionPane.ERROR_MESSAGE);
					
				} else if (passw.isBlank()) {
					JOptionPane.showMessageDialog(vr, "Introduzca una contraseña", "Error de datos", JOptionPane.ERROR_MESSAGE);
				
				} else if(passw.length() > FlipasPipasConst.TAM_CONTRASENIA) {
					JOptionPane.showMessageDialog(vr, "La contraseña no puede tener más de " + FlipasPipasConst.TAM_CONTRASENIA + " caracteres", "Error de datos", JOptionPane.ERROR_MESSAGE);
				
				} else if (confPasswd.isBlank()) {
					JOptionPane.showMessageDialog(vr, "Introduzca la confirmación de contraseña", "Error de datos", JOptionPane.ERROR_MESSAGE);
					
				} else if (!passw.equals(confPasswd)) {
					JOptionPane.showMessageDialog(vr, "Las contraseñas no coinciden", "Error de datos", JOptionPane.ERROR_MESSAGE);
					
				} else {
					
					boolean correoYaExiste = up.correoRepetido(correo);
					
					if (correoYaExiste) {
						JOptionPane.showMessageDialog(vr, "El correo ya está registrado", "Error de datos", JOptionPane.ERROR_MESSAGE);
					} else {
						usuario = new Usuarios(0, nombre, correo, "/img/usuario.png", 0, passw, 0);
						up.registrarUsuario(usuario);
						
						JOptionPane.showMessageDialog(vr, "Usuario creado con éxito", "Registro correcto", JOptionPane.INFORMATION_MESSAGE);
						
						up.getUser(correo);
						ut.crearTienda(up.getId_usuario());
						ulp.insertarLecciones(up.getId_usuario());
						
						vn.limpiar();
						
						unp.enviarNotificacion(up.getId_usuario());
						
						vr.dispose();
						vr.limpiarDatos();
						vi.hacerVisible();
					}
					
				}
				
			}
			
			else if(e.getSource().equals(vu.getBtnCerrarVentana())) {
				vu.dispose();
			}
			
			// Volver (REGISTRO)
			else if (e.getSource().equals(vr.getBtnVolver())) {
				vr.dispose();
				vr.limpiarDatos(); 
				vi.hacerVisible(); // ---> Te lleva a inicio de sesión
			}
			
			// Iniciar sesión (INICIAR SESIÓN)
			else if (e.getSource().equals(vi.getBtnIniciarSesion())) {
				
				String correo = vi.getTxtCorreo();
				String passw = vi.getPwdPassw();
				
				if (correo.isBlank()) {
					JOptionPane.showMessageDialog(vi, "Introduzca el correo", "Error de datos", JOptionPane.ERROR_MESSAGE);
					
				} else if (passw.isBlank()) {
					JOptionPane.showMessageDialog(vi, "Introduzca la contraseña", "Error de datos", JOptionPane.ERROR_MESSAGE);
					
				} else if(passw.length() > FlipasPipasConst.TAM_CONTRASENIA) {
					JOptionPane.showMessageDialog(vi, "La contraseña no puede tener más de " + FlipasPipasConst.TAM_CONTRASENIA + " caracteres", "Error de datos", JOptionPane.ERROR_MESSAGE);
				
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
							 
							 up.getUser(correo);
							 
							 vi.dispose();
							 vi.limpiarDatos();
							 
							 String foto = up.getFotoPerfil();
							 
							 if(foto != null) {
								 vm.cambiarFotoPerfil(foto);
							 }
							 img = null;
							 pti.cargarObjetos(ut.cargarBotones(up.getId_usuario())); //---> Carga los objetos que tengas comprados en la tienda
							 vn.setNotificaciones(np.selectNotificaciones(FlipasPipasConst.NOTIFICACIONES[1], up.getId_usuario())); //---> Envía una notificación al iniciar sesión
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
						img = vcu.getTxtFP1(); //---> Recoge al ruta relativa de la imagen
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
				
				if(img == null) { //---> Si le das al botón guardar sin seleccionar antes una imagen se te pone la por defecto
					img = "/img/usuario.png";
				}
				
				String nom = vcu.getTxtNombre().getText();
				
				if (nom.length() <= FlipasPipasConst.TAM_NOMBRE) {
					int res = up.customizarPerfil(img, vcu.getTxtNombre().getText());
					if(res != 0) {
						vm.cambiarFotoPerfil(img);
						vu.getLblNomUsuario().setText(vcu.getTxtNombre().getText()); //---> Pone el nuevo nombre en VUsuario
						JOptionPane.showMessageDialog(vcu, "Guardado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
						vcu.dispose();
						vu.hacerVisible();
					} else {
						JOptionPane.showMessageDialog(vcu, "Algo no ha ido como esperado", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(vr, "El nick no puede contener más de " + FlipasPipasConst.TAM_NOMBRE + " carácteres"
							, "Error de datos", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
			// Registrarse (INICIAR SESIÓN)
			else if (e.getSource().equals(vi.getBtnRegistrarse())) {
				vi.dispose();
				vi.limpiarDatos();
				vr.hacerVisible();
			}
			
			
			//BOTONES MENÚ
			// Home (CURSOS)
			else if (e.getSource().equals(vm.getBtnHome())) {
				vm.cargarPanel(pc);
			}
			
			else if(e.getSource().equals(vm.getBtnTienda())){
				pti.cargarObjetos(ut.cargarBotones(up.getId_usuario())); //---> Se habilitan los botones de la tienda si no tiene comprados los iconos
				
				int saldo = up.comprobarSaldo();
				pti.cargarSaldo(saldo); //---> Carga el label con las monedas que tiene el usuario
				
				vm.cargarPanel(pti);
			}
			
			else if(e.getSource().equals(vm.getBtnRanking())){
				vm.cargarPanel(pr);
				
				vn.setNotificaciones(np.selectNotificaciones(FlipasPipasConst.NOTIFICACIONES[3], up.getId_usuario())); //---> Envía una notificación al usuario
				
				// Guardar nombre y puntos de los usuarios en un HashMap
				HashMap<String, Integer> tablaUsuPnt = up.nickPuntUsu(); //---> Coge el nombre y los puntos de los usuarios con mayor puntuación
				// Busco las imágenes de los usuarios
				ArrayList<String> imagenesUsu = up.imgUsu(); //---> Coge la ruta de la imagen de los usuarios
				// Esto lo uso para hacer un entry en un arraylist
				ArrayList<Entry<String, Integer>> tablaRanking = new ArrayList<Entry<String,Integer>>(tablaUsuPnt.entrySet());
				pr.mostrarRanking(tablaRanking,imagenesUsu); //---> Ordena los usuarios por puntos y carga los datos
			}
			
			else if(e.getSource().equals(vm.getBtnTemario())){
				vm.cargarPanel(pte);
			}
			
			else if(e.getSource().equals(vm.getBtnAjustes())){
				va.hacerVisible();
			}
			
			else if(e.getSource().equals(vm.getBtnNotificaciones())){
				vn.hacerVisible();
			}
			
			else if(e.getSource().equals(vm.getBtnPerfil())){
				Usuarios usuario = up.cargarDatosUsuario();
				
				vu.getLblEmailUsuario().setText(usuario.getEmail());
				vu.getLblNomUsuario().setText(usuario.getNick());
				vu.getLblPipaCoins().setText(String.valueOf(usuario.getMonedas()) + " flipa coins");
				vu.getLblPuntos().setText(usuario.getPuntos() + " Ptns");
				
				vu.hacerVisible();
			}
						
			
			//BOTONES DEFINICIÓN
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
			

			//BOTONES DEFINICION
			else if(e.getSource().equals(pl.getBtnDfn_1())) {
				ArrayList<String> defList = lp.getDef(lenguaje);
				vd.mostrarDef(defList.get(0));
				vd.hacerVisible();
			}
			
			else if(e.getSource().equals(pl.getBtnDfn_2())) {
				ArrayList<String> defList = lp.getDef(lenguaje);
				vd.mostrarDef(defList.get(1));
				vd.hacerVisible();
			}
			
			else if(e.getSource().equals(pl.getBtnDfn_3())) {
				ArrayList<String> defList = lp.getDef(lenguaje);
				vd.mostrarDef(defList.get(2));
				vd.hacerVisible();
			}
			
			else if(e.getSource().equals(pl.getBtnDfn_4())) {
				ArrayList<String> defList = lp.getDef(lenguaje);
				vd.mostrarDef(defList.get(3));
				vd.hacerVisible();
			}
			
			
			// Botón atrás en lecciones
			else if (e.getSource().equals(pl.getBtnAtrasLecciones())) {
				vm.cargarPanel(pc);
			}
					
			//BOTONES USUARIO
			//CUSTOMIZACIÓN
			else if(e.getSource().equals(vu.getBtnEditarPerfil())) {
				vu.dispose();
				vcu.cargarObjetos(ut.cargarBotones(up.getId_usuario())); //---> Habilita los botones si el usuario actual tiene comprado los iconos de la tienda
				vcu.getTxtNombre().setText(vu.getLblNomUsuario().getText());
				vcu.hacerVisible();
			}
			
			//BOTONES CONFIRMACIÓN
			else if(e.getSource() == vu.getBtnCerrarSesion() || e.getSource() == va.getBtnBorrarCuenta()) {
				String texto = e.getActionCommand();

				
				int res = JOptionPane.showConfirmDialog( vp,"¿Estás seguro?", "Confirmación", JOptionPane.YES_NO_OPTION);
				
				if(res == JOptionPane.YES_OPTION) {
					switch (texto) {
					case VUsuario.ACT_COM_BTN_CERRARSESION:
						vu.dispose();
						vm.dispose();
						vi.hacerVisible();
						break;
					case VAjustes.ACT_CMD_BTN_BORRAR_CUENTA:
						vm.dispose();
						up.borrarcuenta();
						va.dispose();
						vi.hacerVisible();
						break;
					}
				}
				
			}


			// CURSOS
				// CSS
			else if (e.getSource().equals(pc.getBtnCss())) {
				lenguaje = FlipasPipasConst.ID_CURSO_CSS; //---> Almacenamos el lenguaje seleccionado
				cargarLecCur(FlipasPipasConst.ID_CURSO_CSS); //---> Carga los nombres de los niveles, la lección y habilita los niveles que haya completado y el siguiente nivel
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
				cargarPregunta(19, 13, 1, 7); //---> Recoge los primeros niveles de cada curso dependiendo de donde estés
				estabelcerNivelActual(1, 7, 13, 19); //---> Dependiendo de en que curso estés, se te cargará unas preguntas
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
					if (pregPos != preguntas.size()) {
						JOptionPane.showMessageDialog(vm, "¡Pregunta acertada, muy bien!", "Sigue así", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				// Si fallas
				else preguntaFallada();
			}
				
				// Botón B
			else if (e.getSource().equals(vp.getBtnB())) {
				// Si aciertas la pregunta
				if (vp.getBtnB().getText().equals(preguntas.get(pregPos).getCorrecta())) {
					preguntaAcertada();
					if (pregPos != preguntas.size()) {
						JOptionPane.showMessageDialog(vm, "¡Pregunta acertada, muy bien!", "Sigue así", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				// Si fallas
				else preguntaFallada();
			}
				
				// Botón C
			else if (e.getSource().equals(vp.getBtnC())) {
				// Si aciertas la pregunta
				if (vp.getBtnC().getText().equals(preguntas.get(pregPos).getCorrecta())) {
					preguntaAcertada();
					if (pregPos != preguntas.size()) {
						JOptionPane.showMessageDialog(vm, "¡Pregunta acertada, muy bien!", "Sigue así", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				// Si fallas
				else preguntaFallada();
			}
				
				// Botón D
			else if (e.getSource().equals(vp.getBtnD())) {
				// Si aciertas la pregunta
				if (vp.getBtnD().getText().equals(preguntas.get(pregPos).getCorrecta())) {
					preguntaAcertada();
					if (pregPos != preguntas.size()){
						JOptionPane.showMessageDialog(vm, "¡Pregunta acertada, muy bien!","Sigue así", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				// Si fallas
				else {
					preguntaFallada();
				}
			}

			
			//BOTONES SALIR
			else if(e.getSource().equals(va.getBtnSalir())) {
				va.dispose();
			}			
			
			else if(e.getSource().equals(vn.getBtnSalir())) {
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
			
			else if(e.getSource().equals(vcu.getBtnSalir())) {
				vcu.dispose();
				vu.hacerVisible();
			}
			

			else if (e.getSource().equals(vd.getBtnSalirDef())) {
				vd.dispose();;
			}
			
			else if(e.getSource() == vcu.getBtnGuardar()) {
				int res = up.customizarPerfil(img, vu.getLblNomUsuario().getText());
				
				if(res != 0) {
					JOptionPane.showMessageDialog(vcu, "Guardado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
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
				
				int res = JOptionPane.showConfirmDialog(pti, "¿Estás seguro?", "Confirmación Compra", JOptionPane.YES_NO_OPTION);
				Tienda objeto = null;
				
				if(res == JOptionPane.YES_OPTION) {
					switch (boton) {
					case "Objeto1":
						objeto = ut.comprobarObjeto(pti.getBtnObj1().getText()); //---> Recoge el objeto de tipo Tienda y lo guarda en una variable
						break;
					case "Objeto2":
						objeto = ut.comprobarObjeto(pti.getBtnObj2().getText());
						break;
					case "Objeto3":
						objeto = ut.comprobarObjeto(pti.getBtnObj3().getText());
						break;
					case "Objeto4":
						objeto = ut.comprobarObjeto(pti.getBtnObj4().getText());
						break;
					case "Objeto5":
						objeto = ut.comprobarObjeto(pti.getBtnObj5().getText());
						break;
					case "Objeto6":
						objeto = ut.comprobarObjeto(pti.getBtnObj6().getText());
						break;
					}
				}
				
				boolean comprado = false;
				
				if(objeto != null) {
					int saldo = pti.getSaldo(); 
					if(saldo > 0) {
						int realizado = ut.comprarObjeto(objeto, up.getId_usuario()); //---> Actualiza en la base de datos que el objeto está comprado
						
						if(realizado != 0) {
							int actualizado = up.compradoObjeto(saldo - objeto.getPrecio()); //---> Modifica las monedas de la base de datos del usuario
							
							if(actualizado != 0) {
								comprado = true;
								pti.cargarObjetos(ut.cargarBotones(up.getId_usuario())); //---> Actualiza la tienda
								
								saldo = up.comprobarSaldo();
								pti.cargarSaldo(saldo); //---> Actualiza las monedas dentro del label
								
								JOptionPane.showMessageDialog(pti, "Ha comprado el icono", "Compra Realizada", JOptionPane.INFORMATION_MESSAGE);
								vn.setNotificaciones(np.selectNotificaciones(FlipasPipasConst.NOTIFICACIONES[2], up.getId_usuario()));
							}
						} 
					}
				}
				if(!comprado && objeto != null) { 
					JOptionPane.showMessageDialog(pti, "No se ha podido completar la transacción", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				
			} else if (e.getSource().equals(vm.getBtnSalirMenu())) {
				int opc = JOptionPane.showConfirmDialog(vm, "¿Segur@ de que desea salir?", "Confirmación",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
				if (opc == JOptionPane.YES_OPTION) {
					System.exit(0);
					
				}
			}
				
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
		
		if (lenguaje == FlipasPipasConst.ID_CURSO_CSS) {
			obtenerEstablecerPregunta(css); //---> Establece la pregunta actual del nivel
			
		}
		else if (lenguaje == FlipasPipasConst.ID_CURSO_HTML) {
			obtenerEstablecerPregunta(html);
			
		}
		else if (lenguaje == FlipasPipasConst.ID_CURSO_JAVA) {
			obtenerEstablecerPregunta(java);
			
		}
		else if (lenguaje == FlipasPipasConst.ID_CURSO_SQL) {
			obtenerEstablecerPregunta(sql);
			
		}
	}


	private void obtenerEstablecerPregunta(int num) {
		preguntas = upp.getPreg(num); //---> Recoge las preguntas y las mete en un array
		vm.dispose();
		vp.setPregunta(preguntas.get(pregPos)); //---> Manda una pregunta de dentro del array a la ventana donde la cargará
		vp.hacerVisible();
	}


	private void preguntaFallada() {
		JOptionPane.showMessageDialog(vp, "¡Has fallado!", "Respuesta incorrecta" , JOptionPane.ERROR_MESSAGE);
		
		// 
		if (cantFallos < Math.floor(FlipasPipasConst.CANT_PIPAS_LECCION/FlipasPipasConst.CANT_PIPAS_PENALIZACION)) {
			cantFallos+=1;
		}
		
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
			// Calcular cantidad de monedas
			pipas = FlipasPipasConst.CANT_PIPAS_LECCION - cantFallos*FlipasPipasConst.CANT_PIPAS_PENALIZACION;
			puntos = FlipasPipasConst.CANT_PIPAS_LECCION - cantFallos*FlipasPipasConst.CANT_PIPAS_PENALIZACION;
			JOptionPane.showMessageDialog(vp, "¡Has acabado la lección! Has obtenido " + pipas + " pipacoins y "
					+ puntos + " puntos", "¡Enhorabuena!", JOptionPane.INFORMATION_MESSAGE);
			
			vn.setNotificaciones(np.selectNotificaciones(FlipasPipasConst.NOTIFICACIONES[0], up.getId_usuario()));
			
			// Añadir monedas al usuario
			up.aniadirPipas(correoUsuActual, pipas);
			up.aniadirPuntos(correoUsuActual, puntos);
			
//			 Añadir monedas a los bots
			int pntsUsuario = up.getPipasUsuario(correoUsuActual);
			Random rd = new Random();
			
			//SELECT PNTS 3 PRIMEROS ID's (Bots)
			int[] pntsBots = new int[3];
			pntsBots = up.getPntsBots();
			
			//Calculamos la cantidad de puntos para los bots
			int puntosBot1 = rd.nextInt((int) Math.round(pntsUsuario*FlipasPipasConst.PIPAS_MIN_BOT), (int) Math.round(pntsUsuario*FlipasPipasConst.PIPAS_MAX_BOT));
			
			int puntosBot2 = rd.nextInt((int) Math.round(pntsUsuario*FlipasPipasConst.PIPAS_MIN_BOT), (int) Math.round(pntsUsuario*FlipasPipasConst.PIPAS_MAX_BOT));
			
			int puntosBot3 = rd.nextInt((int) Math.round(pntsUsuario*FlipasPipasConst.PIPAS_MIN_BOT), (int) Math.round(pntsUsuario*FlipasPipasConst.PIPAS_MAX_BOT));
			
			// LE SUMO LAS PARTES DEL ARRAY
			up.puntosABots(pntsBots[0]+puntosBot1, pntsBots[1]+puntosBot2, pntsBots[2]+puntosBot3);
			
			if(nivActual != 6 || nivActual != 12 || nivActual != 18 || nivActual != 24) {
				ulp.desbloquearLeccion(up.getId_usuario(), nivActual + 1); //---> Una vez completada una lección se habilitará la siguiente
				pl.cargarLec(lp.datosLeccion(lenguaje), lenguaje, ulp.cargarLecciones(up.getId_usuario(), lenguaje)); //---> Actualiza el panel de lecciones
			}
			vp.dispose();
			vm.cargarPanel(pl);
			vm.hacerVisible();
			
			// Reestablecer cantidad de fallos ganadas
			cantFallos = 0;
		}
		// Si no
		else {
			vp.setPregunta(preguntas.get(pregPos));

		}
	}
	
	private void cargarLecCur(int id_curso) {
		vm.cargarPanel(pl);
		
		ArrayList<Boolean> nvlsOK = ulp.cargarLecciones(up.getId_usuario(), id_curso); //---> Busca los niveles completados y no completados del curso seleccionado
		ArrayList<String> nomLec = lp.datosLeccion(id_curso); //---> Busca el nombre del título y de los niveles según el curso seleccionado

		pl.cargarLec(nomLec, lenguaje, nvlsOK); //---> Lleva la información al panel para cargar los datos buscados


	}

	// Métodos 'set' encargados de optimizar el constructor
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
	
	public void setVentana(VNotificaciones notificaciones) {
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
