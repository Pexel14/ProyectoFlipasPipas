package com.dam.view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextArea;

import com.dam.control.ProjectListener;
import javax.swing.JButton;
import java.awt.Font;

public class Vdefiniciones extends JFrame {
	
	private static final int ANCHO = 265;
	private static final int ALTO = 270;
	private JTextArea txtInfo;
	private JButton btnSalirDef;
	public Vdefiniciones() {
		super("definición");
				
		configurarFrame();
		componentes();		
		
	}

	private void configurarFrame() {
		
		setSize(ANCHO, ALTO);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(50, 50, 75));	
		
	}

	private void componentes() {
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 38, 251, 195);
		getContentPane().add(scrollPane);
		txtInfo = new JTextArea();
		scrollPane.setViewportView(txtInfo);
		txtInfo.setBackground(new Color(50, 50, 75));
		txtInfo.setForeground(new Color(255, 255, 255));
		txtInfo.setEditable(false);
		
		btnSalirDef = new JButton("X");
		btnSalirDef.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalirDef.setBounds(181, 0, 60, 34);
		getContentPane().add(btnSalirDef);
	} 
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public JButton getBtnSalirDef() {
		return btnSalirDef;
	}

	public void setListener(ProjectListener listener) {
		// TODO Auto-generated method stub
		
	}
}
