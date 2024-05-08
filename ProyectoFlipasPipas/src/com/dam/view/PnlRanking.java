package com.dam.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;

public class PnlRanking extends JPanel {
	
	private static final int ANCHO = VPrincipal.ANCHO_PANEL;
	private static final int ALTO = VPrincipal.ALTO_PANEL;

	public PnlRanking() {
		
		configurarPanel();
		componentes();
		
	}

	private void configurarPanel() {
		setBackground(new Color(50, 50, 75));
		setSize(ANCHO, ALTO);
		setLayout(null);
	}

	private void componentes() {
		JPanel pnlUsuario1 = new JPanel();
		pnlUsuario1.setBackground(new Color(32, 20, 52));
		pnlUsuario1.setBounds(323, 150, 646, 100);
		add(pnlUsuario1);
		pnlUsuario1.setLayout(null);
		
		JLabel lblNomUsuario1 = new JLabel("Usuario123");
		lblNomUsuario1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNomUsuario1.setForeground(new Color(240, 240, 240));
		lblNomUsuario1.setBounds(125, 0, 351, 100);
		pnlUsuario1.add(lblNomUsuario1);
		
		JLabel lblPuntosUsuario1 = new JLabel("1000 pts");
		lblPuntosUsuario1.setForeground(new Color(240, 240, 240));
		lblPuntosUsuario1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPuntosUsuario1.setBounds(486, 0, 135, 100);
		pnlUsuario1.add(lblPuntosUsuario1);
		
		JPanel pnlUsuario2 = new JPanel();
		pnlUsuario2.setLayout(null);
		pnlUsuario2.setBackground(new Color(32, 20, 52));
		pnlUsuario2.setBounds(323, 298, 646, 100);
		add(pnlUsuario2);
		
		JLabel lblNomUsuario2 = new JLabel("Bot 1");
		lblNomUsuario2.setForeground(UIManager.getColor("Button.background"));
		lblNomUsuario2.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNomUsuario2.setBounds(125, 0, 351, 100);
		pnlUsuario2.add(lblNomUsuario2);
		
		JLabel lblPuntosUsuario2 = new JLabel("900 pts");
		lblPuntosUsuario2.setForeground(UIManager.getColor("Button.background"));
		lblPuntosUsuario2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPuntosUsuario2.setBounds(486, 0, 135, 100);
		pnlUsuario2.add(lblPuntosUsuario2);
		
		JPanel pnlUsuario3 = new JPanel();
		pnlUsuario3.setLayout(null);
		pnlUsuario3.setBackground(new Color(32, 20, 52));
		pnlUsuario3.setBounds(323, 446, 646, 100);
		add(pnlUsuario3);
		
		JLabel lblNomUsuario3 = new JLabel("Bot 2");
		lblNomUsuario3.setForeground(UIManager.getColor("Button.background"));
		lblNomUsuario3.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNomUsuario3.setBounds(125, 0, 351, 100);
		pnlUsuario3.add(lblNomUsuario3);
		
		JLabel lblPuntosUsuario3 = new JLabel("800 pts");
		lblPuntosUsuario3.setForeground(UIManager.getColor("Button.background"));
		lblPuntosUsuario3.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPuntosUsuario3.setBounds(486, 0, 135, 100);
		pnlUsuario3.add(lblPuntosUsuario3);
		
		JPanel pnlUsuario4 = new JPanel();
		pnlUsuario4.setLayout(null);
		pnlUsuario4.setBackground(new Color(32, 20, 52));
		pnlUsuario4.setBounds(323, 594, 646, 100);
		add(pnlUsuario4);
		
		JLabel lblNomUsuario4 = new JLabel("Bot 3");
		lblNomUsuario4.setForeground(UIManager.getColor("Button.background"));
		lblNomUsuario4.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNomUsuario4.setBounds(125, 0, 351, 100);
		pnlUsuario4.add(lblNomUsuario4);
		
		JLabel lblPuntosUsuario4 = new JLabel("700 pts");
		lblPuntosUsuario4.setForeground(UIManager.getColor("Button.background"));
		lblPuntosUsuario4.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPuntosUsuario4.setBounds(486, 0, 135, 100);
		pnlUsuario4.add(lblPuntosUsuario4);
		
		JPanel pnlPuesto1 = new JPanel();
		pnlPuesto1.setBackground(new Color(32, 20, 52));
		pnlPuesto1.setBounds(173, 150, 100, 100);
		add(pnlPuesto1);
		pnlPuesto1.setLayout(null);
		
		JLabel lblPuesto1 = new JLabel("#1");
		lblPuesto1.setForeground(new Color(240, 240, 240));
		lblPuesto1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblPuesto1.setBounds(20, 0, 60, 100);
		pnlPuesto1.add(lblPuesto1);
		
		JPanel pnlPuesto2 = new JPanel();
		pnlPuesto2.setLayout(null);
		pnlPuesto2.setBackground(new Color(32, 20, 52));
		pnlPuesto2.setBounds(173, 298, 100, 100);
		add(pnlPuesto2);
		
		JLabel lblPuesto2 = new JLabel("#2");
		lblPuesto2.setForeground(UIManager.getColor("Button.background"));
		lblPuesto2.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblPuesto2.setBounds(20, 0, 60, 100);
		pnlPuesto2.add(lblPuesto2);
		
		JPanel pnlPuesto3 = new JPanel();
		pnlPuesto3.setLayout(null);
		pnlPuesto3.setBackground(new Color(32, 20, 52));
		pnlPuesto3.setBounds(173, 446, 100, 100);
		add(pnlPuesto3);
		
		JLabel lblPuesto3 = new JLabel("#3");
		lblPuesto3.setForeground(UIManager.getColor("Button.background"));
		lblPuesto3.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblPuesto3.setBounds(20, 0, 60, 100);
		pnlPuesto3.add(lblPuesto3);
		
		JPanel pnlPuesto4 = new JPanel();
		pnlPuesto4.setLayout(null);
		pnlPuesto4.setBackground(new Color(32, 20, 52));
		pnlPuesto4.setBounds(173, 594, 100, 100);
		add(pnlPuesto4);
		
		JLabel lblPuesto4 = new JLabel("#4");
		lblPuesto4.setForeground(UIManager.getColor("Button.background"));
		lblPuesto4.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblPuesto4.setBounds(20, 0, 60, 100);
		pnlPuesto4.add(lblPuesto4);
	}

}
