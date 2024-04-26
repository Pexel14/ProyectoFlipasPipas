package com.dam.main;

import java.awt.EventQueue;
import com.dam.control.ListenerProvisional;
import com.dam.view.PnlCursos;
import com.dam.view.VInicioSesion;
import com.dam.view.VPrincipal;
import com.dam.view.VRegistro;

public class Inicio {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				VPrincipal vp = new VPrincipal();
				VRegistro vr = new VRegistro();
				VInicioSesion vi = new VInicioSesion();
				PnlCursos pc = new PnlCursos();
				
				ListenerProvisional l = new ListenerProvisional(vp, vr, vi, pc);
				vp.setListener(l);
				vr.setListener(l);
				vi.setListener(l);
				pc.setListener(l);

				
				vi.mostrarVentana(); // Empezar en INICIAR SESIÓN
			}
			
		});
	}

}
