package com.dam.view;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;

import com.dam.control.ProjectListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class VUsuario extends JDialog {
	
	public static final String ACT_COM_BTN_CERRARSESION = "Cerrar Sesión";
	public static final String ACT_COM_BTN_COINS = " pipa coins";
	public static final String ACT_COM_BTN_RACHA = " días de racha";
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
	private JLabel lblEmailUsuario;

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
		lblPantallaUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblPantallaUsuario.setForeground(new Color(240, 240, 240));
		lblPantallaUsuario.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblPantallaUsuario.setBounds(193, 20, 200, 40);
		getContentPane().add(lblPantallaUsuario);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(50, 50, 75));
		panel.setBounds(50, 75, 500, 10);
		getContentPane().add(panel);
		
		lblNomUsuario = new JLabel("Nombre :");
		lblNomUsuario.setForeground(new Color(240, 240, 240));
		lblNomUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNomUsuario.setBounds(175, 110, 235, 30);
		getContentPane().add(lblNomUsuario);
		
		lblEmailUsuario = new JLabel("Email :");
		lblEmailUsuario.setForeground(new Color(240, 240, 240));
		lblEmailUsuario.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEmailUsuario.setBounds(175, 150, 180, 30);
		getContentPane().add(lblEmailUsuario);
		
		btnEditarPerfil = new JButton(ACT_COM_BTN_EDITAR);
		btnEditarPerfil.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnEditarPerfil.setBounds(465, 110, 85, 30);
		getContentPane().add(btnEditarPerfil);
		
		
		lblPipaCoins = new JLabel(" pipa coins");
		lblPipaCoins.setForeground(new Color(255, 255, 255));
		lblPipaCoins.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPipaCoins.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPipaCoins.setBounds(175, 212, 250, 40);
		getContentPane().add(lblPipaCoins);
		
		btnCerrarSesion = new JButton(ACT_COM_BTN_CERRARSESION);
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCerrarSesion.setBounds(175, 322, 235, 30);
		getContentPane().add(btnCerrarSesion);
		
		btnCerrarVentana = new JButton("");
		btnCerrarVentana.setIcon(new ImageIcon(VUsuario.class.getResource("/img/salir.png")));
		btnCerrarVentana.setBorderPainted(false);
		btnCerrarVentana.setContentAreaFilled(false);
		btnCerrarVentana.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCerrarVentana.setBounds(536, 0, 50, 50);
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
	
	public JLabel getLblNomUsuario() {
		return lblNomUsuario;
	}

	public JLabel getLblRacha() {
		return lblRacha;
	}

	public JLabel getLblPipaCoins() {
		return lblPipaCoins;
	}

	public JLabel getLblEmailUsuario() {
		return lblEmailUsuario;
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
