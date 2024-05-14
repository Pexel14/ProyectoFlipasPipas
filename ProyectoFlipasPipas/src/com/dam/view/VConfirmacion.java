package com.dam.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.dam.control.ProjectListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;

public class VConfirmacion extends JDialog {
	
	public static final String ACT_COM_BTN_SI = "Si";
	public static final String ACT_COM_BTN_NO = "No";
	private static final int ANCHO = 300;
	private static final int ALTO = 200;
	
	private JButton btnRespSi;
	private JButton btnRespNo;
	
	private static VMenu vm;
	
	public VConfirmacion() {
		
		super(vm, "Confirmacion", true);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(50, 50, 75));
		
		JLabel lblPregunta = new JLabel("¿Está segur@?");
		lblPregunta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPregunta.setForeground(Color.WHITE);
		lblPregunta.setBounds(75, 30, 135, 25);
		getContentPane().add(lblPregunta);
		
		btnRespSi = new JButton(ACT_COM_BTN_SI);
		btnRespSi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRespSi.setBounds(28, 118, 100, 35);
		getContentPane().add(btnRespSi);
		
		btnRespNo = new JButton(ACT_COM_BTN_NO);
		btnRespNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRespNo.setBounds(156, 118, 100, 35);
		getContentPane().add(btnRespNo);
		configurarFrame();
		
	}

	public JButton getBtnRespNo() {
		return btnRespNo;
	}
	
	public JButton getBtnRespSi() {
		return btnRespSi;
	}
	
	private void configurarFrame() {
		
		setSize(ANCHO, ALTO);
//		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}

	public void setListener(ProjectListener listener) {
		btnRespNo.addActionListener(listener);
		btnRespSi.addActionListener(listener);
	}

	public void hacerVisible() {
		setVisible(true);
		
	}
	
}
