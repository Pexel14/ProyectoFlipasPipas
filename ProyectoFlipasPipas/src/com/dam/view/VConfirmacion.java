package com.dam.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;

public class VConfirmacion extends JFrame {
	
	private static final int ANCHO = 300;
	private static final int ALTO = 200;

	public VConfirmacion() {
		
		super("Confirmacion");
		getContentPane().setLayout(null);
		
		JLabel lblPregunta = new JLabel("¿Está segur@?");
		lblPregunta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPregunta.setBounds(75, 30, 135, 25);
		getContentPane().add(lblPregunta);
		
		JButton btnRespSi = new JButton("Si");
		btnRespSi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRespSi.setBounds(28, 118, 100, 35);
		getContentPane().add(btnRespSi);
		
		JButton btnRespNo = new JButton("No");
		btnRespNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRespNo.setBounds(156, 118, 100, 35);
		getContentPane().add(btnRespNo);
		configurarFrame();
		
	}

	private void configurarFrame() {
		
		setSize(ANCHO, ALTO);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
}
