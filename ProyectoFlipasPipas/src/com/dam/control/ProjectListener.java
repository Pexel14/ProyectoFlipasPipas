package com.dam.control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.dam.db.persistencias.TiendaPer;
import com.dam.db.persistencias.UsuariosPer;
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
	private VConfirmacion vco;
	private Vdefiniciones vd;
	
	//CLASES NIVELES
	private PnlLeciones pl;
	private VPreguntas vp;
	
	//PERSISTENCIAS
	private UsuariosPer up;
	private TiendaPer tp;
	
//	public ProjectListener() {
//		
//	}
	
	public ProjectListener(VInicioSesion vi) {
		this.vi = vi;
		up = new UsuariosPer();
		tp = new TiendaPer();
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
				vr.dispose();
				vm.cargarPanel(pc);
				vm.hacerVisible();
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
				vi.dispose();
				vm.cargarPanel(pc);
				vm.hacerVisible();
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
				pti.cargarObjetos(tp.cargarBotones());
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
				up.cargarDatosUsuario();
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
				vcu.cargarObjetos(tp.cargarBotones());
				vcu.hacerVisible();
			}
			
			
			//BOTONES CONFIRMACION
			else if(e.getSource() == vu.getBtnCerrarSesion() || e.getSource() == va.getBtnBorrarCuenta()) {
				String texto = e.getActionCommand();
				Object ventana = e.getSource();
//				vco.hacerVisible();
				
				int res = JOptionPane.showConfirmDialog((Component) ventana,"¿Estás seguro?", "Confirmacion", JOptionPane.YES_NO_OPTION);
				
				if(res == JOptionPane.YES_OPTION) {
					switch (texto) {
					case VUsuario.ACT_COM_BTN_CERRARSESION:
						vu.dispose();
						vm.dispose();
						vi.hacerVisible();
						break;
					case VAjustes.ACT_CMD_BTN_BORRAR_CUENTA:
						
						break;
					}
				}
				
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
				int res = up.customizarPerfil(img);
				
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
				int res = JOptionPane.showConfirmDialog(pti, "¿Estás seguro?", "Confirmacion Compra", JOptionPane.YES_NO_CANCEL_OPTION);
				int id = 0;
				if(res == JOptionPane.YES_OPTION) {
					switch (boton) {
					case "Objeto1":
						id = tp.comprobarObjeto(pti.getBtnObj1().getText());
						break;
					case "Objeto2":
						
						break;
					case "Objeto3":
						
						break;
					case "Objeto4":
						
						break;
					case "Objeto5":
						
						break;
					case "Objeto6":
						
						break;
					}

				}
				
				if(id != 0) {
					int realizado = tp.comprarObjeto(id);
					
					if(realizado != 0) {
						JOptionPane.showMessageDialog(pti, "Ha comprado el icono", "Compra Realizada", JOptionPane.PLAIN_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(pti, "No se ha podido completar la transaccion", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
			}
				
		}
		
	}

	public void setPanel(PnlTienda tienda) {
		this.pti = tienda;
		tp.setVentana(tienda);
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
	
	public void setVentana(VConfirmacion confirmacion) {
		this.vco = confirmacion;
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
		up.setVentana(vu);
	}
	
	public void setVentana(VRegistro registro) {
		this.vr = registro;
	}
	
	public void setVentana(VMenu menu) {
		this.vm = menu;
	}
}
