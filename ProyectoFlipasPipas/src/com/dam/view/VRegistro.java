package com.dam.view;

import java.awt.Color;

import javax.swing.JFrame;

import com.dam.control.ProjectListener;

import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VRegistro extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static final int ANCHO = 1920;
	private static final int ALTO = 1080;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JPasswordField txtContrasenia;
	private JPasswordField txtConfirmarContrasenia;
	private JButton btnRegistrar;
	private JButton btnVolver;

	public VRegistro() {
		super("Registro");
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
		
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setForeground(Color.WHITE);
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblRegistro.setBounds(642, 25, 255, 75);
		getContentPane().add(lblRegistro);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtNombre.setBounds(420, 167, 700, 50);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(420, 284, 700, 50);
		getContentPane().add(txtCorreo);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtContrasenia.setColumns(10);
		txtContrasenia.setBounds(420, 401, 700, 50);
		getContentPane().add(txtContrasenia);
		
		txtConfirmarContrasenia = new JPasswordField();
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
		
		JLabel lblNombre = new JLabel("Nick :");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNombre.setBounds(339, 166, 71, 50);
		getContentPane().add(lblNombre);
		
		JLabel lblCorreo = new JLabel("Correo :");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCorreo.setBounds(310, 284, 100, 50);
		getContentPane().add(lblCorreo);
		
		JLabel lblContrasenia = new JLabel("Contraseña :");
		lblContrasenia.setForeground(Color.WHITE);
		lblContrasenia.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblContrasenia.setBounds(250, 400, 160, 50);
		getContentPane().add(lblContrasenia);
		
		JLabel lblConfContrasenia = new JLabel("<HTML>\r\nConfirmar<br>contraseña :\r\n</HTML>");
		lblConfContrasenia.setForeground(Color.WHITE);
		lblConfContrasenia.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblConfContrasenia.setBounds(255, 508, 155, 60);
		getContentPane().add(lblConfContrasenia);
		
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}
	
	public JButton getBtnVolver() {
		return btnVolver;
	}
	
	public String getTxtNombre() { 
		return txtNombre.getText();
	}

	public String getTxtCorreo() {
		return txtCorreo.getText();
	}

	public String getTxtContrasenia() {
		return String.valueOf(txtContrasenia.getPassword());
	}

	public String getTxtConfirmarContrasenia() {
		return String.valueOf(txtConfirmarContrasenia.getPassword());
	}

	public void setListener(ProjectListener listener) {
		btnRegistrar.addActionListener(listener);
		btnVolver.addActionListener(listener);
	}

	public void limpiarDatos() {
		txtNombre.setText("");
		txtCorreo.setText("");
		txtContrasenia.setText("");
		txtConfirmarContrasenia.setText("");
	}
}
