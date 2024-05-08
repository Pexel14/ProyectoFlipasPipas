package com.dam.view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextArea;

public class Vdefiniciones extends JFrame {
	
	private static final int ANCHO = 265;
	private static final int ALTO = 270;
	private JTextArea txtInfo;
	public Vdefiniciones() {
		super("definición");
				
		configurarFrame();
		componentes();		
		
	}

	private void configurarFrame() {
		
		setSize(ANCHO, ALTO);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(50, 50, 75));	
		
	}

	private void componentes() {
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		txtInfo = new JTextArea();
		scrollPane.setViewportView(txtInfo);
		
	}
	
	public void mostrarVentana() {
		setVisible(true);
	}
}
