package com.dam.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.dam.control.ListenerProvisional;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VInicioSesion extends JFrame {
	
	private static final int ANCHO = 1920;
	private static final int ALTO = 1080;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnRegistrarse;
	private JButton btnIniciarSesion;

	public VInicioSesion() {
		super("Iniciar sesión");
		configurarFrame();
		componentes();
	}

	private void componentes() {
		
		setSize(ANCHO, ALTO);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}

	private void configurarFrame() {
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(ANCHO, ALTO);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		getContentPane().setBackground(new Color(50, 50, 75));
		
		JLabel lblIniciarSesin = new JLabel("Iniciar sesión");
		lblIniciarSesin.setForeground(Color.WHITE);
		lblIniciarSesin.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblIniciarSesin.setBounds(565, 25, 410, 75);
		getContentPane().add(lblIniciarSesin);
		
		textField_1 = new JTextField();
		textField_1.setText("Correo");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_1.setColumns(10);
		textField_1.setBounds(420, 167, 700, 50);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("Contraseña");
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_2.setColumns(10);
		textField_2.setBounds(420, 284, 700, 50);
		getContentPane().add(textField_2);
		
		btnIniciarSesion = new JButton("Iniciar sesión");
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnIniciarSesion.setBounds(595, 401, 350, 100);
		getContentPane().add(btnIniciarSesion);
		
		btnRegistrarse = new JButton("¿Aún no tienes cuenta?");
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegistrarse.setBounds(595, 700, 350, 30);
		getContentPane().add(btnRegistrarse);
		
	}
	
	public void mostrarVentana() {
		setVisible(true);
	}
	
	public void ocultarVentana() {
		setVisible(false);
	}

	public void setListener(ListenerProvisional listener) {
		
		btnIniciarSesion.addActionListener(listener);
		btnRegistrarse.addActionListener(listener);
		
	}

	public JButton getBtn(int i) {
		
		switch (i) {
			case 1:
				return btnIniciarSesion;
			case 2:
				return btnRegistrarse;
			default:
				return null;
		}
		
	}
	
}
