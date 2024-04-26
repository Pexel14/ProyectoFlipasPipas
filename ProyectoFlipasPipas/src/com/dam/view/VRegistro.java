package com.dam.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.dam.control.ListenerProvisional;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VRegistro extends JFrame {
	
	private static final int ANCHO = 1920;
	private static final int ALTO = 1080;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTextField txtContrasenia;
	private JTextField txtConfirmarContrasenia;
	private JButton btnRegistrar;
	private JButton btnVolver;

	public VRegistro() {
		super("Registro");
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
		
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setForeground(Color.WHITE);
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblRegistro.setBounds(642, 25, 255, 75);
		getContentPane().add(lblRegistro);
		
		txtNombre = new JTextField();
		txtNombre.setText("Nombre");
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtNombre.setBounds(420, 167, 700, 50);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setText("Correo");
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(420, 284, 700, 50);
		getContentPane().add(txtCorreo);
		
		txtContrasenia = new JTextField();
		txtContrasenia.setText("Contraseña");
		txtContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtContrasenia.setColumns(10);
		txtContrasenia.setBounds(420, 401, 700, 50);
		getContentPane().add(txtContrasenia);
		
		txtConfirmarContrasenia = new JTextField();
		txtConfirmarContrasenia.setText("Confirmar contraseña");
		txtConfirmarContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtConfirmarContrasenia.setColumns(10);
		txtConfirmarContrasenia.setBounds(420, 518, 700, 50);
		getContentPane().add(txtConfirmarContrasenia);
		
		btnRegistrar = new JButton("Regístrate");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnRegistrar.setBounds(595, 635, 350, 100);
		getContentPane().add(btnRegistrar);
		
		btnVolver = new JButton("<-");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnVolver.setBounds(50, 50, 65, 65);
		getContentPane().add(btnVolver);
		
	}
	
	public void mostrarVentana() {
		setVisible(true);
	}
	
	public void ocultarVentana() {
		setVisible(false);
	}
	
	public JTextField getTxt(int i) {
		
		switch (i) {
			case 1:
				return txtNombre;
			case 2:
				return txtCorreo;
			default :
				return null;
		}
		
	}
	
	public JButton getBtn(int i) {
		
		switch (i) {
			case 1:
				return btnRegistrar;
			case 2:
				return btnVolver;
			default :
				return null;
		}
		
	}
	
	public void establecerTexto (int i, String s) {
		
		switch (i) {
			case 1:
				txtNombre.setText(s);
			case 2:
				txtCorreo.setText(s);
		}
		
	}

	public void setListener(ListenerProvisional listener) {
		btnRegistrar.addActionListener(listener);
		btnVolver.addActionListener(listener);
	}
}
