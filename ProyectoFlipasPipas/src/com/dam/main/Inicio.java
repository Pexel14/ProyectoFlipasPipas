package com.dam.main;

import java.awt.EventQueue;

import com.dam.view.VHome;

public class Inicio {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				VHome vh = new VHome();
				vh.mostrarVentana();
				
			}
			
		});
	}

}
