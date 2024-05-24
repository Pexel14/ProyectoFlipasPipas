package com.dam.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;

import com.dam.control.ProjectListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;

public class VUsuario extends JDialog {
	
	public static final String ACT_COM_BTN_CERRARSESION = "Cerrar Sesión";
	public static final String ACT_COM_BTN_COINS = "1000 pipa coins";
	public static final String ACT_COM_BTN_RACHA = "100 días de racha";
	public static final String ACT_COM_BTN_EDITAR = "Editar";
	private static final int ANCHO = 600;
	private static final int ALTO = 400;
	private JLabel lblNomUsuario;
	private JButton btnEditarPerfil;
	private JLabel lblRacha;
	private JLabel lblPipaCoins;
	private JButton btnCerrarSesion;
	private JButton btnCerrarVentana;
	private static VMenu vm;

	public VUsuario() {
		super(vm, "Usuario", true);
		configurarFrame();
		componentes();
	}

	private void componentes() {
		
		setSize(ANCHO, ALTO);
//		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}

	private void configurarFrame() {
		getContentPane().setBackground(new Color(100, 100, 125));
		getContentPane().setLayout(null);
		
		JLabel lblPantallaUsuario = new JLabel("Usuario");
		lblPantallaUsuario.setForeground(new Color(240, 240, 240));
		lblPantallaUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPantallaUsuario.setBounds(258, 10, 70, 25);
		getContentPane().add(lblPantallaUsuario);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(50, 50, 75));
		panel.setBounds(50, 45, 500, 10);
		getContentPane().add(panel);
		
		lblNomUsuario = new JLabel("UsuarioDePrueba");
		lblNomUsuario.setForeground(new Color(240, 240, 240));
		lblNomUsuario.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNomUsuario.setBounds(175, 65, 235, 30);
		getContentPane().add(lblNomUsuario);
		
		JLabel lblEmailUsuario = new JLabel("emaildelusuario@mail.com");
		lblEmailUsuario.setForeground(new Color(240, 240, 240));
		lblEmailUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmailUsuario.setBounds(175, 105, 180, 15);
		getContentPane().add(lblEmailUsuario);
		
		btnEditarPerfil = new JButton(ACT_COM_BTN_EDITAR);
		btnEditarPerfil.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnEditarPerfil.setBounds(465, 65, 85, 30);
		getContentPane().add(btnEditarPerfil);
		
		lblRacha = new JLabel(ACT_COM_BTN_RACHA);
		lblRacha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRacha.setBounds(175, 182, 250, 20);
		getContentPane().add(lblRacha);
		
		lblPipaCoins = new JLabel(ACT_COM_BTN_COINS);
		lblPipaCoins.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPipaCoins.setBounds(175, 212, 250, 20);
		getContentPane().add(lblPipaCoins);
		
		btnCerrarSesion = new JButton(ACT_COM_BTN_CERRARSESION);
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCerrarSesion.setBounds(175, 332, 235, 20);
		getContentPane().add(btnCerrarSesion);
		
		btnCerrarVentana = new JButton("");
		btnCerrarVentana.setIcon(new ImageIcon(VUsuario.class.getResource("/img/salir.png")));
		btnCerrarVentana.setBorderPainted(false);
		btnCerrarVentana.setContentAreaFilled(false);
		btnCerrarVentana.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCerrarVentana.setBounds(536, 1, 50, 50);
		getContentPane().add(btnCerrarVentana);
	}
	
	public JButton getBtnEditarPerfil() {
		return btnEditarPerfil;
	}
	
	public JButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}
	
	public JButton getBtnCerrarVentana() {
		return btnCerrarVentana;
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public void setListener(ProjectListener listener) {
		btnEditarPerfil.addActionListener(listener);
		btnCerrarVentana.addActionListener(listener);
		btnCerrarSesion.addActionListener(listener);
	}
}
