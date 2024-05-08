package com.dam.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VCustomizacion extends JFrame {
	
	private static final int ANCHO = 500;
	private static final int ALTO = 550;
	private static final String ACT_CMD_BTN_SALIRCUSTOM = "X";
	private JTextField txtNombre;
	private JButton btnFP2;
	private JButton btnFP1;
	private JButton btnNewFP3;
	private JButton btnFP4;
	private JButton btnFP6;
	private JButton btnFP5;
	private JButton btnGuardar;
	private JButton btnSalir;
	
	public VCustomizacion() {
		super("Customizacion");
		configurarFrame();
		
		configurarComponentes();
	}

	private void configurarFrame() {
		getContentPane().setBackground(new Color(100, 100, 125));
		setSize(ANCHO, ALTO);
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();                
		setLocation((pantalla.width - this.getSize().width) / 2, (pantalla.height - this.getSize().height) / 2);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	private void configurarComponentes() {
		getContentPane().setLayout(null);
		
		JLabel lblCustomizacion = new JLabel("Customización");
		lblCustomizacion.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCustomizacion.setForeground(new Color(255, 255, 255));
		lblCustomizacion.setBounds(175, 20, 150, 30);
		getContentPane().add(lblCustomizacion);
		
		JButton btnA1 = new JButton("");
		btnA1.setBackground(new Color(64, 64, 81));
		btnA1.setForeground(new Color(64, 64, 81));
		btnA1.setEnabled(false);
		btnA1.setBounds(48, 61, 408, 15);
		getContentPane().add(btnA1);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario.setForeground(Color.WHITE);
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNombreDeUsuario.setBounds(58, 87, 212, 30);
		getContentPane().add(lblNombreDeUsuario);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setBounds(58, 128, 334, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnA2 = new JButton("");
		btnA2.setForeground(new Color(64, 64, 81));
		btnA2.setEnabled(false);
		btnA2.setBackground(new Color(64, 64, 81));
		btnA2.setBounds(48, 179, 408, 15);
		getContentPane().add(btnA2);
		
		JLabel lblFotoDePerfil = new JLabel("Foto de Perfil:");
		lblFotoDePerfil.setForeground(Color.WHITE);
		lblFotoDePerfil.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFotoDePerfil.setBounds(58, 209, 150, 30);
		getContentPane().add(lblFotoDePerfil);
		
		btnSalir = new JButton(ACT_CMD_BTN_SALIRCUSTOM);
		btnSalir.setBounds(401, 11, 48, 41);
		getContentPane().add(btnSalir);
		
		btnFP1 = new JButton("");
		btnFP1.setBounds(54, 260, 89, 76);
		getContentPane().add(btnFP1);
		
		btnNewFP3 = new JButton("");
		btnNewFP3.setBounds(202, 260, 89, 76);
		getContentPane().add(btnNewFP3);
		
		btnFP5 = new JButton("");
		btnFP5.setBounds(350, 260, 89, 76);
		getContentPane().add(btnFP5);
		
		btnFP2 = new JButton("");
		btnFP2.setBounds(54, 355, 89, 76);
		getContentPane().add(btnFP2);
		
		btnFP4 = new JButton("");
		btnFP4.setBounds(202, 355, 89, 76);
		getContentPane().add(btnFP4);
		
		btnFP6 = new JButton("");
		btnFP6.setBounds(350, 355, 89, 76);
		getContentPane().add(btnFP6);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(351, 457, 105, 30);
		getContentPane().add(btnGuardar);
		
	}
	
	public void setListener() {
		//TODO
	}
	
}
