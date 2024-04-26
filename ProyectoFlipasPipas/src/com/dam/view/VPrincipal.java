package com.dam.view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.dam.control.ListenerProvisional;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;

public class VPrincipal extends JFrame {
	public static final int ALTO_PANEL = 845;
	public static final int ANCHO_PANEL = 1292;
	private static final int ANCHO = 1920;
	private static final int ALTO = 1080;
	private final ButtonGroup botonesMenu = new ButtonGroup();
	private JScrollPane scrpPanel;
	private JButton btnHome;
	private JButton btnRanking;
	private JButton btnTemario;
	private JButton btnTienda;
	private JButton btnNotis;
	private JButton btnVidas;
	private JButton btnPerfil;
	private JButton btnAjustes;

	public VPrincipal() {
		super("Flipas Pipas");
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
		
		btnHome = new JButton("Home");
		botonesMenu.add(btnHome);
		btnHome.setBounds(1320, 109, 75, 75);
		getContentPane().add(btnHome);
		
		btnRanking = new JButton("Ranking");
		botonesMenu.add(btnRanking);
		btnRanking.setBounds(1320, 293, 75, 75);
		getContentPane().add(btnRanking);
		
		btnTemario = new JButton("Temario");
		botonesMenu.add(btnTemario);
		btnTemario.setBounds(1320, 477, 75, 75);
		getContentPane().add(btnTemario);
		
		btnTienda = new JButton("Tienda");
		botonesMenu.add(btnTienda);
		btnTienda.setBounds(1320, 661, 75, 75);
		getContentPane().add(btnTienda);
		
		btnNotis = new JButton("Notis");
		botonesMenu.add(btnNotis);
		btnNotis.setBounds(1445, 477, 75, 75);
		getContentPane().add(btnNotis);
		
		btnVidas = new JButton("Vidas");
		botonesMenu.add(btnVidas);
		btnVidas.setBounds(1445, 293, 75, 75);
		getContentPane().add(btnVidas);
		
		btnPerfil = new JButton("Perfil");
		botonesMenu.add(btnPerfil);
		btnPerfil.setBounds(1445, 109, 75, 75);
		getContentPane().add(btnPerfil);
		
		btnAjustes = new JButton("Ajustes");
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
		
		scrpPanel = new JScrollPane();
		scrpPanel.setBounds(0, -1, ANCHO_PANEL, ALTO_PANEL);
		getContentPane().add(scrpPanel);
		
	}
	
	public void configurarFrame(JPanel panel) {
		scrpPanel.setViewportView(panel);
	}
	
	public void mostrarVentana() {
		setVisible(true);
	}
	
	public JButton getBtn(int i) {
		
		switch (i) {
			case 1 :
				return btnHome;
			default :
				return null;
		}
	}


	public void setListener(ListenerProvisional listener) {
		
		btnHome.addActionListener(listener);
		
	}
	
	public void cerrarVentana() {
		System.exit(0);
	}
}