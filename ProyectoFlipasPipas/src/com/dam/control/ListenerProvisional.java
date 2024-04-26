package com.dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.dam.view.PnlCursos;
import com.dam.view.VInicioSesion;
import com.dam.view.VPrincipal;
import com.dam.view.VRegistro;

public class ListenerProvisional implements ActionListener {
	
	private VPrincipal vp;
	private VRegistro vr;
	private VInicioSesion vi;
	private PnlCursos pc;

	public ListenerProvisional(VPrincipal vp, VRegistro vr , VInicioSesion vi, PnlCursos pc) {
		this.vp = vp;
		this.vr = vr;
		this.vi = vi;
		this.pc = pc;
	}

	public void actionPerformed(ActionEvent e) {
		
		// BOTONES
		if (e.getSource() instanceof JButton) {
			
			// Home (CURSOS)
			if (e.getSource().equals(vp.getBtn(1))) {
				
				vp.configurarFrame(pc);
				
			}
			
			// Regístrate (REGISTRO)
			if (e.getSource().equals(vr.getBtn(1))) {
				
				vr.ocultarVentana();
				
				vp.configurarFrame(pc);
				vp.mostrarVentana();
				
			}
			
			// Volver (REGISTRO)
			if (e.getSource().equals(vr.getBtn(2))) {

				vi.mostrarVentana();
				
				vr.ocultarVentana();
				
			}
			//
			// Iniciar sesión (INICIAR SESIÓN)
			if (e.getSource().equals(vi.getBtn(1))) {
				
				vi.ocultarVentana();
				
				vp.configurarFrame(pc);
				vp.mostrarVentana();
				
			}
			
			// Registrarse (INICIAR SESIÓN)
			if (e.getSource().equals(vi.getBtn(2))) {
				
				vi.ocultarVentana();
				
				vr.mostrarVentana();
				
			}
			
		}
		
	}

}
