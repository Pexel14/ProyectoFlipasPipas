package com.dam.view;

import java.awt.Color;

import javax.swing.JFrame;

import com.dam.control.ProjectListener;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VInicioSesion extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static final String ACT_COM_BTN_INICIO_SESION = "Iniciar sesión";
	public static final String ACT_COM_BTN_REGISTRO = "¿Aún no tienes cuenta?";
	private static final int ANCHO = 1920;
	private static final int ALTO = 1080;
	private JTextField txtCorreo;
	private JPasswordField pwdPassw;
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
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(420, 190, 700, 50);
		getContentPane().add(txtCorreo);
		
		pwdPassw = new JPasswordField();
		pwdPassw.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pwdPassw.setColumns(10);
		pwdPassw.setBounds(420, 330, 700, 50);
		getContentPane().add(pwdPassw);
		
		btnIniciarSesion = new JButton(ACT_COM_BTN_INICIO_SESION);
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnIniciarSesion.setBounds(595, 430, 350, 100);
		getContentPane().add(btnIniciarSesion);
		
		btnRegistrarse = new JButton(ACT_COM_BTN_REGISTRO);
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegistrarse.setBounds(595, 700, 350, 50);
		getContentPane().add(btnRegistrarse);
		
		JLabel lblCorreo = new JLabel("Correo :");
		lblCorreo.setForeground(new Color(240, 240, 240));
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCorreo.setBounds(420, 150, 200, 30);
		getContentPane().add(lblCorreo);
		
		JLabel lblContrasenia = new JLabel("Contraseña :");
		lblContrasenia.setForeground(new Color(240, 240, 240));
		lblContrasenia.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblContrasenia.setBounds(420, 290, 200, 30);
		getContentPane().add(lblContrasenia);
		
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

	public String getPwdPassw() {
		return String.valueOf(pwdPassw.getPassword());
	}

	public void setTxtPassw(String texto) {
		pwdPassw.setText(texto);
	}

	public void limpiarDatos() {
		txtCorreo.setText("");
		pwdPassw.setText("");
	}
}
