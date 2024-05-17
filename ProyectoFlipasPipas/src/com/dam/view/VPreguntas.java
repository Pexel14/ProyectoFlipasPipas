package com.dam.view;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import com.dam.control.ProjectListener;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.ImageIcon;

/*
 * @author alejandro
 * */

public class VPreguntas extends JFrame {
	
	public static final String ACT_CMD_BTN_SALIRPREG = "X";
	public static final String ACT_CMD_BTN_A = "A";
	public static final String ACT_CMD_BTN_B = "B";
	public static final String ACT_CMD_BTN_C = "C";
	public static final String ACT_CMD_BTN_D = "D";
	
	private static final int ANCHO = 1575;
	private static final int ALTO = 1021;
	private JButton btnA;
	private JButton btnB;
	private JButton btnC;
	private JButton btnD;
	private JButton btnSalir;

	public VPreguntas() {
		ConfigurarFrame();

		componentes();
		
	}

	public void hacerVisible() {
		setVisible(true);
	}

	private void componentes() {

		getContentPane().setBackground(new Color(50, 50, 75));
		
		JLabel lblPregunta = new JLabel("Esto es la Pregunta?");
		lblPregunta.setFont(new Font("Tahoma", Font.PLAIN, 70));
		lblPregunta.setBounds(456, 149, 676, 109);
		getContentPane().add(lblPregunta);
		
		btnA = new JButton(ACT_CMD_BTN_A);
		btnA.setBounds(296, 382, 348, 128);
		getContentPane().add(btnA);
		
		btnB = new JButton(ACT_CMD_BTN_B);
		btnB.setBounds(840, 382, 348, 128);
		getContentPane().add(btnB);
		
		btnC = new JButton(ACT_CMD_BTN_C);
		btnC.setBounds(296, 591, 348, 128);
		getContentPane().add(btnC);
		
		btnD = new JButton(ACT_CMD_BTN_D);
		btnD.setBounds(840, 591, 348, 128);
		getContentPane().add(btnD);
		
		btnSalir = new JButton(ACT_CMD_BTN_SALIRPREG);
		btnSalir.setIcon(new ImageIcon("C:\\eclipse\\eclipse-workspace\\UEM\\ProyectoFlipasPipas\\ProyectoFlipasPipas\\img\\salir.png"));
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBounds(1350, 105, 50, 50);
		getContentPane().add(btnSalir);
		
	}

	
	
	public JButton getBtnA() {
		return btnA;
	}

	public JButton getBtnB() {
		return btnB;
	}

	public JButton getBtnC() {
		return btnC;
	}

	public JButton getBtnD() {
		return btnD;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	private void ConfigurarFrame() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(ANCHO, ALTO);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
	}
	
	public void setListener(ProjectListener pl) {
		btnA.addActionListener(pl);
		btnB.addActionListener(pl);
		btnC.addActionListener(pl);
		btnD.addActionListener(pl);
		btnSalir.addActionListener(pl);
	}
	
}
