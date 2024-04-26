package com.dam.view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import java.awt.Font;

public class VHome extends JFrame {
	private static final int ANCHO = 500;
	private static final int ALTO = 300;
	private final ButtonGroup botonesMenu = new ButtonGroup();

	public VHome() {
		super("Cursos");

		getContentPane().setBackground(new Color(50, 50, 75));
		
		
		
		
		configurarFrame();
		componentes();
		
	}


	private void componentes() {
		
		setSize(1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		

	}

	private void configurarFrame() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(ANCHO, ALTO);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JButton btnHome = new JButton("Home");
		botonesMenu.add(btnHome);
		btnHome.setBounds(1320, 109, 75, 75);
		getContentPane().add(btnHome);
		
		JButton btnRanking = new JButton("Ranking");
		botonesMenu.add(btnRanking);
		btnRanking.setBounds(1320, 293, 75, 75);
		getContentPane().add(btnRanking);
		
		JButton btnTemario = new JButton("Temario");
		botonesMenu.add(btnTemario);
		btnTemario.setBounds(1320, 477, 75, 75);
		getContentPane().add(btnTemario);
		
		JButton btnTienda = new JButton("Tienda");
		botonesMenu.add(btnTienda);
		btnTienda.setBounds(1320, 661, 75, 75);
		getContentPane().add(btnTienda);
		
		JButton btnNotis = new JButton("Notis");
		botonesMenu.add(btnNotis);
		btnNotis.setBounds(1445, 477, 75, 75);
		getContentPane().add(btnNotis);
		
		JButton btnVidas = new JButton("Vidas");
		botonesMenu.add(btnVidas);
		btnVidas.setBounds(1445, 293, 75, 75);
		getContentPane().add(btnVidas);
		
		JButton btnPerfil = new JButton("Perfil");
		botonesMenu.add(btnPerfil);
		btnPerfil.setBounds(1445, 109, 75, 75);
		getContentPane().add(btnPerfil);
		
		JButton btnAjustes = new JButton("Ajustes");
		botonesMenu.add(btnAjustes);
		btnAjustes.setBounds(1445, 661, 75, 75);
		getContentPane().add(btnAjustes);
		
		JPanel pnlDecoracionMenu = new JPanel();
		pnlDecoracionMenu.setBackground(new Color(100, 100, 125));
		pnlDecoracionMenu.setBounds(1415, 0, 10, 1000);
		getContentPane().add(pnlDecoracionMenu);
		
		JPanel pnlDecoracionMenu2 = new JPanel();
		pnlDecoracionMenu2.setBackground(new Color(100, 100, 125));
		pnlDecoracionMenu2.setBounds(1290, 0, 10, 1000);
		getContentPane().add(pnlDecoracionMenu2);
		
		JButton btnCursoJava = new JButton("JAVA");
		btnCursoJava.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnCursoJava.setBounds(257, 232, 250, 150);
		getContentPane().add(btnCursoJava);
		
		JButton btnCursoSQL = new JButton("SQL");
		btnCursoSQL.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnCursoSQL.setBounds(764, 232, 250, 150);
		getContentPane().add(btnCursoSQL);
		
		JButton btnCursoHTML = new JButton("HTML");
		btnCursoHTML.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnCursoHTML.setBounds(257, 522, 250, 150);
		getContentPane().add(btnCursoHTML);
		
		JButton btnCursoCSS = new JButton("CSS");
		btnCursoCSS.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnCursoCSS.setBounds(764, 522, 250, 150);
		getContentPane().add(btnCursoCSS);
	}
	
	public void mostrarVentana() {
		setVisible(true);
	}
}
