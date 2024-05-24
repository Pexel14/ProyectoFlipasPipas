package com.dam.main;

import java.awt.EventQueue;
import com.dam.control.ProjectListener;
import com.dam.view.PnlCursos;
import com.dam.view.PnlLeciones;
import com.dam.view.PnlRanking;
import com.dam.view.PnlTemario;
import com.dam.view.PnlTienda;
import com.dam.view.VAjustes;
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
				Vdefiniciones vd = new Vdefiniciones();
				
				//CLASES NIVELES
				PnlLeciones pl = new PnlLeciones();
				VPreguntas vp = new VPreguntas();
				
				
				ProjectListener listener = new ProjectListener(vi);
				
				listener.setVentana(vr);
				listener.setVentana(vm);
				listener.setPanel(pti);
				listener.setPanel(pr);
				listener.setPanel(pte);
				listener.setPanel(pc);
				listener.setVentana(va);
				listener.setVentana(vn);
				listener.setVentana(vu);
				listener.setVentana(vcu);
				listener.setVentana(vd);
				listener.setPanel(pl);
				listener.setVentana(vp);
				
				vr.setListener(listener);
				vi.setListener(listener);
				vm.setListener(listener);
				pti.setListener(listener);
				pte.setListener(listener);
				pc.setListener(listener);
				va.setListener(listener);
				vn.setListener(listener);
				vu.setListener(listener);
				vcu.setListener(listener);
				pl.setListener(listener);
				vp.setListener(listener);
				vd.setListener(listener);
				
				vi.hacerVisible(); // Empezar en INICIAR SESIÓN
			}

		
			
		});
	}

}
