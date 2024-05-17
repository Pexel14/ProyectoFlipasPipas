package com.dam.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.dam.control.ProjectListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VInicioSesion extends JFrame {
	
	public static final String ACT_COM_BTN_INICIO_SESION = "Iniciar sesión";
	public static final String ACT_COM_BTN_REGISTRO = "¿Aún no tienes cuenta?";
	private static final int ANCHO = 1920;
	private static final int ALTO = 1080;
	private JTextField txtCorreo;
	private JTextField txtPassw;
	private JButton btnRegistrarse;
	private JButton btnIniciarSesion;

	public VInicioSesion() {
		super(ACT_COM_BTN_INICIO_SESION);
		configurarFrame();
		componentes();
	}

	private void componentes() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(ANCHO, ALTO);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}

	private void configurarFrame() {
		getContentPane().setLayout(null);
		
		getContentPane().setBackground(new Color(50, 50, 75));
		
		JLabel lblIniciarSesin = new JLabel(ACT_COM_BTN_INICIO_SESION);
		lblIniciarSesin.setForeground(Color.WHITE);
		lblIniciarSesin.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblIniciarSesin.setBounds(565, 25, 410, 75);
		getContentPane().add(lblIniciarSesin);
		
		txtCorreo = new JTextField();
		txtCorreo.setText("Correo");
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(420, 167, 700, 50);
		getContentPane().add(txtCorreo);
		
		txtPassw = new JTextField();
		txtPassw.setText("Contraseña");
		txtPassw.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPassw.setColumns(10);
		txtPassw.setBounds(420, 284, 700, 50);
		getContentPane().add(txtPassw);
		
		btnIniciarSesion = new JButton(ACT_COM_BTN_INICIO_SESION);
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnIniciarSesion.setBounds(595, 401, 350, 100);
		getContentPane().add(btnIniciarSesion);
		
		btnRegistrarse = new JButton(ACT_COM_BTN_REGISTRO);
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegistrarse.setBounds(595, 700, 350, 30);
		getContentPane().add(btnRegistrarse);
		
	}
	
	public void hacerVisible() {
		setVisible(true);
	}

	public JButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}
	
	public JButton getBtnRegistrarse() {
		return btnRegistrarse;
	}
	
	public void setListener(ProjectListener listener) {
		
		btnIniciarSesion.addActionListener(listener);
		btnRegistrarse.addActionListener(listener);
		
	}

	public String getTxtCorreo() {
		return txtCorreo.getText();
	}

	public void setTxtCorreo(String texto) {
		txtCorreo.setText(texto);
	}

	public String getTxtPassw() {
		return txtPassw.getText();
	}

	public void setTxtPassw(String texto) {
		txtPassw.setText(texto);
	}

//	public JButton getBtn(int i) {
//		
//		switch (i) {
//			case 1:
//				return btnIniciarSesion;
//			case 2:
//				return btnRegistrarse;
//			default:
//				return null;
//		}
//		
//	}
	
}
