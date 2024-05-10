package com.dam.main;

import java.awt.EventQueue;
import com.dam.control.ProjectListener;
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

public class Inicio {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				//CLASES REGISTRO/INICIO
				VRegistro vr = new VRegistro();
				VInicioSesion vi = new VInicioSesion();
				
				//CLASES MENU
				VMenu vm = new VMenu();
				
				PnlTienda pti = new PnlTienda();
				PnlRanking pr = new PnlRanking();
				PnlTemario pte = new PnlTemario();
				PnlCursos pc = new PnlCursos();
				VAjustes va = new VAjustes();
				VNotis vn = new VNotis();
				VUsuario vu = new VUsuario();
				VCustomizacion vcu = new VCustomizacion();
				
				//CLASES GENERALES
				VConfirmacion vco = new VConfirmacion();
				Vdefiniciones vd = new Vdefiniciones();
				
				//CLASES NIVELES
				PnlLeciones pl = new PnlLeciones();
				VPreguntas vp = new VPreguntas();
				
				
				ProjectListener listener = new ProjectListener(vr, vi, vm, pti, pr, pte, pc, va, vn, vu, vcu, vco, pl, vp, vd);
				setListener(vr, vi, vm, pti, pr, pte, pc, va, vn, vu, vcu, vco, pl, vp, vd, listener);

				
				vi.hacerVisible(); // Empezar en INICIAR SESIÓN
			}

			private void setListener(VRegistro vr, VInicioSesion vi, VMenu vm, PnlTienda pti, PnlRanking pr,
					PnlTemario pte, PnlCursos pc, VAjustes va, VNotis vn, VUsuario vu, VCustomizacion vcu,
					VConfirmacion vco, PnlLeciones pl, VPreguntas vp, Vdefiniciones vd, ProjectListener listener) {
				vr.setListener(listener);
				vi.setListener(listener);
				vm.setListener(listener);
				pti.setListener(listener);
				pr.setListener(listener);
				pte.setListener(listener);
				pc.setListener(listener);
				va.setListener(listener);
				vn.setListener(listener);
				vu.setListener(listener);
				vcu.setListener(listener);
				vco.setListener(listener);
				pl.setListener(listener);
				vp.setListener(listener);
				vd.setListener(listener);
			}
			
		});
	}

}
