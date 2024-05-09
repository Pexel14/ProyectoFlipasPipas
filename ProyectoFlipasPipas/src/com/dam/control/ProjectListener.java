package com.dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

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
	
	
	public ProjectListener(VRegistro vr, VInicioSesion vi, VMenu vm, PnlTienda pti, PnlRanking pr, PnlTemario pte,
			PnlCursos pc, VAjustes va, VNotis vn, VUsuario vu, VCustomizacion vcu, VConfirmacion vco, Vdefiniciones vd,
			PnlLeciones pl, VPreguntas vp) {
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
		this.vd = vd;
		this.pl = pl;
		this.vp = vp;
	}


	public void actionPerformed(ActionEvent e) {
		
		// BOTONES
		if (e.getSource() instanceof JButton) {
			
			//BOTONES INICIO/REGISTRO
			// Regístrate (REGISTRO)
			if (e.getSource().equals(vr.getBtnRegistrar())) {
				vr.dispose();
				vm.cargarPanel(pc);
				vm.hacerVisible();
			}
			
			//BOTONES USUARIO
			//USUARIO
			else if(e.getSource().equals(vu.getBtnEditarPerfil())) {
				vu.dispose();
				vcu.hacerVisible();
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
			
			else if(e.getSource().equals(vu.getBtnEditarPerfil())){
				vm.cargarPanel(pc);
			}
			
			
			
			//BOTONES NIVELES
			//CURSOS
			
			else if(e.getSource().equals(pc.getBtnJava())) {
//				cargarLecciones(); //Posible metodo para diferenciar lecciones segun el lenguaje
				vm.cargarPanel(pl);
			}
			
			else if(e.getSource().equals(pc.getBtnSql())) {
				vm.cargarPanel(pl);
			}
			
			else if(e.getSource().equals(pc.getBtnCss())) {
				vm.cargarPanel(pl);
			}
			
			else if(e.getSource().equals(pc.getBtnHtml())) {
				vm.cargarPanel(pl);
			}
			
			//LECCIONES
			else if(e.getSource().equals(pl.getBtnLec_1())) {
				vm.dispose();
				vp.hacerVisible();
			}
			
			else if(e.getSource().equals(pl.getBtnLec_2())) {
				vm.dispose();
				vp.hacerVisible();				
			}
			
			else if(e.getSource().equals(pl.getBtnLec_3())) {
				vm.dispose();
				vp.hacerVisible();
			}
			
			else if(e.getSource().equals(pl.getBtnLec_4())) {
				vm.dispose();
				vp.hacerVisible();
			}
			
			else if(e.getSource().equals(pl.getBtnRepaso())) {
				vm.dispose();
				vp.hacerVisible();
			}
			
			else if(e.getSource().equals(pl.getBtnExamen())) {
				vm.dispose();
				vp.hacerVisible();
			}
			
			else if(e.getSource().equals(pl.getBtnDfn_1())) {
				vd.hacerVisible();
			}
			
			else if(e.getSource().equals(pl.getBtnDfn_2())) {
				vd.hacerVisible();
			}
			
			else if(e.getSource().equals(pl.getBtnDfn_3())) {
				vd.hacerVisible();
			}
			
			else if(e.getSource().equals(pl.getBtnDfn_4())) {
				vd.hacerVisible();
			}
			
			
			//PREGUNTAS
			else if(e.getSource().equals(vp.getBtnSalir())) {
				vp.dispose();
				vm.hacerVisible();
				vm.cargarPanel(pl);
			}
			
			
			
			
			
			
		}
		
	}

}
