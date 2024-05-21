package com.dam.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map.Entry;

public class PnlRanking extends JPanel {
	
	private static final int CANT_USU_RNKG = 4;
	private JLabel[] lblNomUsuarios = new JLabel[CANT_USU_RNKG];
    private JLabel[] lblPuntosUsuarios = new JLabel[CANT_USU_RNKG];
    //private JButton[] btnImgUsu = new JButton[CANT_USU_RNKG];

	public PnlRanking() {
		
		configurarPanel();
		componentes();
		
	}

	private void configurarPanel() {
		setBackground(new Color(50, 50, 75));
		setSize(VMenu.ANCHO_PANEL, VMenu.ALTO_PANEL);
	}

	private void componentes() {
		setLayout(null);
		
		int [] pnlPosY = {150,298,446,594};
		int pnlPosX = 323;
		int pnlAlt = 100;
		int pnlAnch = 646;
		
		JPanel pnlUsuario;
		JPanel pnlPuesto;
		JLabel lblPuesto;
		
		for (int i = 0; i < CANT_USU_RNKG; i++) {
			
			pnlUsuario = new JPanel();
			pnlUsuario.setBackground(new Color(32, 20, 52));
			pnlUsuario.setBounds(pnlPosX, pnlPosY[i], pnlAnch, pnlAlt);
			add(pnlUsuario);
			pnlUsuario.setLayout(null);
			
			//btnImgUsu[i] = new JButton("");
			
			lblNomUsuarios[i] = new JLabel("");
			lblNomUsuarios[i].setFont(new Font("Tahoma", Font.BOLD, 40));
			lblNomUsuarios[i].setForeground(new Color(240, 240, 240));
			lblNomUsuarios[i].setBounds(125, 0, 351, 100);
			pnlUsuario.add(lblNomUsuarios[i]);
			
			lblPuntosUsuarios[i] = new JLabel("");
			lblPuntosUsuarios[i].setForeground(new Color(240, 240, 240));
			lblPuntosUsuarios[i].setFont(new Font("Tahoma", Font.BOLD, 30));
			lblPuntosUsuarios[i].setBounds(486, 0, 135, 100);
			pnlUsuario.add(lblPuntosUsuarios[i]);
			
			//PUESTOS
			pnlPuesto = new JPanel();
			pnlPuesto.setBackground(new Color(32, 20, 52));
			pnlPuesto.setBounds(173, pnlPosY[i], 100, 100);
			add(pnlPuesto);
			pnlPuesto.setLayout(null);
			
			lblPuesto = new JLabel("#" + (i+1));
			lblPuesto.setForeground(new Color(240, 240, 240));
			lblPuesto.setFont(new Font("Tahoma", Font.BOLD, 40));
			lblPuesto.setBounds(20, 0, 60, 100);
			pnlPuesto.add(lblPuesto);
		}
	}

	public void mostrarRanking(ArrayList<Entry<String, Integer>> tablaRanking) {
		// Lo ordeno comparando por valor de mayor a menor
		tablaRanking.sort(Entry.comparingByValue(Comparator.reverseOrder()));
		
		for (int i = 0; i < CANT_USU_RNKG; i++) {
			lblNomUsuarios[i].setText(tablaRanking.get(i).getKey());
			lblPuntosUsuarios[i].setText(tablaRanking.get(i).getValue() + " pts.");
		}
	}

}
