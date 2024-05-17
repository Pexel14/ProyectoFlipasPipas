package com.dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.dam.db.persistencias.UsuariosPer;
import com.dam.model.pojos.Usuarios;
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
	private UsuariosPer usuper = new UsuariosPer();
	
	// CLASES POJOS
	private Usuarios usuario;
	
	
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
			}
			
			else if(e.getSource().equals(vm.getBtnTemario())){
				vm.cargarPanel(pte);
			}
			
			else if(e.getSource().equals(vm.getBtnAjustes())){
				va.hacerVisible();
			}
			
			else if(e.getSource().equals(vm.getBtnNotis())){
				vn.hacerVisible();
			}
			
			else if(e.getSource().equals(vm.getBtnPerfil())){
				vu.hacerVisible();
			}
			
			
			//BOTONES NIVELES
			//CURSOS
			else if(e.getSource().equals(pc.getBtnJava()) || e.getSource().equals(pc.getBtnHtml()) || e.getSource().equals(pc.getBtnCss()) || e.getSource().equals(pc.getBtnSql())) {
//				cargarLecciones(); //Posible metodo para diferenciar lecciones segun el lenguaje
				vm.cargarPanel(pl);
			}
			
			//BOTONES DEFINICION
			else if(e.getSource() == pc.getBtnInterrogante1() || e.getSource() == pc.getBtnInterrogante2() || e.getSource() == pc.getBtnInterrogante3() || e.getSource() == pc.getBtnInterrogante4()) {
				vd.hacerVisible();
			}
			
			
			//LECCIONES
			//JUNTAR TODOS
			else if(e.getSource().equals(pl.getBtnLec_1()) 
					|| e.getSource().equals(pl.getBtnExamen()) 
					|| e.getSource().equals(pl.getBtnRepaso()) 
					|| e.getSource().equals(pl.getBtnLec_2()) 
					|| e.getSource().equals(pl.getBtnLec_3()) 
					|| e.getSource().equals(pl.getBtnLec_4())) {
				vm.dispose();
				vp.hacerVisible();
			}
			
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
				vco.hacerVisible();
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
			
		}
		
	}

}
