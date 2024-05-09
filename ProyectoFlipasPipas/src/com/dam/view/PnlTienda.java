package com.dam.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.dam.control.ProjectListener;

public class PnlTienda extends JPanel {
	
	private static final int ANCHO = VMenu.ANCHO_PANEL;
	private static final int ALTO = VMenu.ALTO_PANEL;
	private JButton btnObj1;
	private JButton btnObj2;
	private JButton btnObj3;
	private JButton btnObj4;
	private JButton btnObj5;
	private JButton btnObj6;
	private JLabel lblCantPipas;
	private JButton btnImgPipa;
	
	public PnlTienda() {
		configurarComponentes();
		configurarFrame();
	}

	private void configurarComponentes() {
		setLayout(null);
		
		JLabel lblPipaCoins = new JLabel("Pipa Coins");
		lblPipaCoins.setForeground(new Color(240, 240, 240));
		lblPipaCoins.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPipaCoins.setBounds(116, 111, 175, 50);
		add(lblPipaCoins);
		
		btnImgPipa = new JButton("");
		btnImgPipa.setBounds(410, 111, 50, 50);
		add(btnImgPipa);
		
		btnObj1 = new JButton("5000");
		btnObj1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnObj1.setVerticalAlignment(SwingConstants.BOTTOM);
		btnObj1.setBounds(116, 272, 275, 175);
		add(btnObj1);
		
		btnObj2 = new JButton("5000");
		btnObj2.setVerticalAlignment(SwingConstants.BOTTOM);
		btnObj2.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnObj2.setBounds(507, 272, 275, 175);
		add(btnObj2);
		
		btnObj3 = new JButton("5000");
		btnObj3.setVerticalAlignment(SwingConstants.BOTTOM);
		btnObj3.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnObj3.setBounds(898, 272, 275, 175);
		add(btnObj3);
		
		btnObj4 = new JButton("10000");
		btnObj4.setVerticalAlignment(SwingConstants.BOTTOM);
		btnObj4.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnObj4.setBounds(116, 558, 275, 175);
		add(btnObj4);
		
		btnObj5 = new JButton("10000");
		btnObj5.setVerticalAlignment(SwingConstants.BOTTOM);
		btnObj5.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnObj5.setBounds(507, 558, 275, 175);
		add(btnObj5);
		
		btnObj6 = new JButton("10000");
		btnObj6.setVerticalAlignment(SwingConstants.BOTTOM);
		btnObj6.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnObj6.setBounds(898, 558, 275, 175);
		add(btnObj6);
		
		lblCantPipas = new JLabel("10000");
		lblCantPipas.setForeground(UIManager.getColor("Button.background"));
		lblCantPipas.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCantPipas.setBounds(285, 111, 115, 50);
		add(lblCantPipas);
	}

	private void configurarFrame() {
		setBackground(new Color(50, 50, 75));
		setSize(ANCHO, ALTO);
	}

	public void setListener(ProjectListener listener) {
		// TODO Auto-generated method stub
		
	}
}
