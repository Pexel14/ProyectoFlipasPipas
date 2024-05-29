package com.dam.view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.dam.control.ProjectListener;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Insets;

public class VMenu extends JFrame {
	public static final int ALTO_PANEL = 845;
	public static final int ANCHO_PANEL = 1292;
	private static final int ANCHO = 1920;
	private static final int ALTO = 1080;
	private JScrollPane scrpPanel;
	private JButton btnHome;
	private JButton btnRanking;
	private JButton btnTemario;
	private JButton btnTienda;
	private JButton btnNotis;
	private JButton btnPerfil;
	private JButton btnAjustes;
	private JButton btnSalirMenu;

	public VMenu() {
		super("Flipas Pipas");
		cargarPanel();
		componentes();
	}


	private void componentes() {
		getContentPane().setBackground(new Color(50, 50, 75));
		setSize(ANCHO, ALTO);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	private void cargarPanel() {
		getContentPane().setLayout(null);
		
		btnHome = new JButton("");
		btnHome.setMargin(new Insets(2, 2, 2, 2));
		btnHome.setIconTextGap(0);
		btnHome.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHome.setAlignmentY(0.0f);
		btnHome.setIcon(new ImageIcon(VMenu.class.getResource("/img/home.png")));
		btnHome.setBorderPainted(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setBounds(1320, 109, 75, 75);
		getContentPane().add(btnHome);
		
		btnRanking = new JButton("");
		btnRanking.setIcon(new ImageIcon(VMenu.class.getResource("/img/ranking.png")));
		btnRanking.setBorderPainted(false);
		btnRanking.setContentAreaFilled(false);
		btnRanking.setBounds(1320, 293, 75, 75);
		getContentPane().add(btnRanking);
		
		btnTemario = new JButton("");
		btnTemario.setIcon(new ImageIcon(VMenu.class.getResource("/img/temario.png")));
		btnTemario.setBorderPainted(false);
		btnTemario.setContentAreaFilled(false);
		btnTemario.setBounds(1320, 477, 75, 75);
		getContentPane().add(btnTemario);
		
		btnTienda = new JButton("");
		btnTienda.setIcon(new ImageIcon(VMenu.class.getResource("/img/tienda.png")));
		btnTienda.setBorderPainted(false);
		btnTienda.setContentAreaFilled(false);
		btnTienda.setBounds(1320, 661, 75, 75);
		getContentPane().add(btnTienda);
		
		btnNotis = new JButton("");
		btnNotis.setIcon(new ImageIcon(VMenu.class.getResource("/img/notis.png")));
		btnNotis.setBorderPainted(false);
		btnNotis.setContentAreaFilled(false);
		btnNotis.setBounds(1445, 293, 75, 75);
		getContentPane().add(btnNotis);
		
		btnPerfil = new JButton("");
		btnPerfil.setIcon(new ImageIcon(VMenu.class.getResource("/img/usuario.png")));
		btnPerfil.setBorderPainted(false);
		btnPerfil.setContentAreaFilled(false);
		btnPerfil.setBounds(1445, 109, 75, 75);
		getContentPane().add(btnPerfil);
		
		btnAjustes = new JButton("");
		btnAjustes.setIcon(new ImageIcon(VMenu.class.getResource("/img/ajustes.png")));
		btnAjustes.setBorderPainted(false);
		btnAjustes.setContentAreaFilled(false);
		btnAjustes.setBounds(1445, 477, 75, 75);
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
		
		btnSalirMenu = new JButton("New button");
		btnSalirMenu.setIcon(new ImageIcon(VMenu.class.getResource("/img/salir_app.png")));
		btnSalirMenu.setBounds(1445, 661, 75, 75);
		btnSalirMenu.setBorderPainted(false);
		btnSalirMenu.setContentAreaFilled(false);
		getContentPane().add(btnSalirMenu);
		
	}
	
	public void cargarPanel(JPanel panel) {
		scrpPanel.setViewportView(panel);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
//	public JButton getBtn(int i) {
//		
//		switch (i) {
//			case 1 :
//				return btnHome;
//			default :
//				return null;
//		}
//	}

	
	
	public JButton getBtnHome() {
		return btnHome;
	}


	public JButton getBtnRanking() {
		return btnRanking;
	}


	public JButton getBtnTemario() {
		return btnTemario;
	}


	public JButton getBtnTienda() {
		return btnTienda;
	}

	public JButton getBtnSalirMenu() {
		return btnSalirMenu;
	}

	public JButton getBtnNotis() {
		return btnNotis;
	}


	public JButton getBtnPerfil() {
		return btnPerfil;
	}


	public JButton getBtnAjustes() {
		return btnAjustes;
	}

	public void cambiarFotoPerfil(String img) {
		btnPerfil.setIcon(new ImageIcon(VMenu.class.getResource(img)));
	}
	
	
	public void setListener(ProjectListener listener) {
		btnHome.addActionListener(listener);
		btnPerfil.addActionListener(listener);
		btnRanking.addActionListener(listener);
		btnTienda.addActionListener(listener);
		btnTemario.addActionListener(listener);
		btnNotis.addActionListener(listener);
		btnAjustes.addActionListener(listener);
		btnSalirMenu.addActionListener(listener);
		
	}
}
